package com.aengussong.randomuserlist.di.module;

import com.aengussong.randomuserlist.provider.DataProvider;
import com.aengussong.randomuserlist.provider.remote.ApiClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ProviderModule {

    @Singleton
    @Provides
    DataProvider providerDataProvider(ApiClient apiClient){
        return new DataProvider(apiClient);
    }
}
