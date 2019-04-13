package com.aengussong.randomuserlist.provider.remote;

import com.aengussong.randomuserlist.model.RandomUserResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET
    Single<RandomUserResponse> getInitialList();

    @GET
    Single<RandomUserResponse> getNextPage(@Query("page") int page, @Query("results") int results, @Query("seed") String seed);
}
