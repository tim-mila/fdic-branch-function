package com.alimmit;

import io.micronaut.function.client.FunctionClient;
import io.micronaut.http.annotation.Body;
import io.reactivex.Single;

import javax.inject.Named;

@FunctionClient
public interface FdicBranchFunctionClient {

    @Named("fdic-branch-function")
    Single<String> apply(@Body BranchSearch request);

}
