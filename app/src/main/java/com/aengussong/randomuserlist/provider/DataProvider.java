package com.aengussong.randomuserlist.provider;

import com.aengussong.randomuserlist.model.RandomUserResponse;
import com.aengussong.randomuserlist.provider.remote.ApiClient;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static com.aengussong.randomuserlist.util.Constants.PAGE_SIZE;

public class DataProvider {

    private ApiClient remoteDataProvider;

    public DataProvider(ApiClient apiClient) {
        remoteDataProvider = apiClient;
    }

    public Single<RandomUserResponse> getPage(int page, String seed) {
        return remoteDataProvider.getNextPage(page, PAGE_SIZE, seed)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
