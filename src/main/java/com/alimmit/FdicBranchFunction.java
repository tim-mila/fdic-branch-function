package com.alimmit;

import com.alimmit.query.FdicQuery;
import com.alimmit.query.Filter;
import io.micronaut.function.FunctionBean;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;

@FunctionBean("fdic-branch-function")
public class FdicBranchFunction implements Function<BranchSearch, String> {

    @Override
    public String apply(final BranchSearch branchSearch) {

        final Filter institutionFilter = Filter.value("NAME", "\"" + branchSearch.getInstitutionName() + "\"");

        Filter filter = institutionFilter;
        if (StringUtils.isNotBlank(branchSearch.getQ())) {
            filter = Filter.and(institutionFilter, Filter.value("OFFNAME", branchSearch.getQ()));
        }

        int limit = branchSearch.getLimit() > 0 ? branchSearch.getLimit() : 10;
        int offset = branchSearch.getOffset() > 0 ? branchSearch.getOffset() : 0;

        final FdicQuery query = FdicQuery.from(Endpoint.Location).filter(filter).offset(offset).limit(limit).sortBy("OFFNAME").sortOrder(FdicQuery.SortOrder.ASC);

        if (null != branchSearch.getFields() && branchSearch.getFields().length > 0) {
            query.fields(branchSearch.getFields());
        }

        return new FdicClient().query(query);
    }
}
