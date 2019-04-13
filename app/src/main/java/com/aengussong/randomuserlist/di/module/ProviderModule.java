package com.aengussong.randomuserlist.di.module;

import android.arch.paging.PagedList;

import com.aengussong.randomuserlist.model.RandomUser;
import com.aengussong.randomuserlist.provider.DataProvider;
import com.aengussong.randomuserlist.provider.RandomUserPositionalDataSource;
import com.aengussong.randomuserlist.provider.remote.ApiClient;
import com.aengussong.randomuserlist.util.MainThreadExecutor;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static com.aengussong.randomuserlist.util.Constants.PAGE_SIZE;

@Module
public class ProviderModule {

    @Singleton
    @Provides
    DataProvider providerDataProvider(ApiClient apiClient) {
        return new DataProvider(apiClient);
    }

    @Provides
    PagedList.Config providePagedListConfig() {
        return new PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(PAGE_SIZE)
                .build();
    }

    @Provides
    MainThreadExecutor provideMainThreadExecutor() {
        return new MainThreadExecutor();
    }

    @Provides
    PagedList<RandomUser> provideRandomUserPagedList(RandomUserPositionalDataSource dataSource, PagedList.Config config, MainThreadExecutor mainExecutor) {
        return new PagedList.Builder<>(dataSource, config)
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .setNotifyExecutor(mainExecutor)
                .build();
    }
}
