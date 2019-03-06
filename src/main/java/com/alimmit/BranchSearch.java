package com.alimmit;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;

public class BranchSearch implements Serializable {

    private String institutionName;
    private String q;
    private String[] fields;

    public BranchSearch() {
    }

    BranchSearch(final String institutionName) {
        this(institutionName, StringUtils.EMPTY);
    }

    BranchSearch(final String institutionName, final String q) {
        this(institutionName, q, new String[] {});
    }

    BranchSearch(final String institutionName, final String q, final String[] fields) {
        this.institutionName = institutionName;
        this.q = q;
        this.fields = fields;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(final String institutionName) {
        this.institutionName = institutionName;
    }

    public String getQ() {
        return q;
    }

    public void setQ(final String q) {
        this.q = q;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(final String[] fields) {
        this.fields = fields;
    }
}
