package com.aengussong.randomuserlist.di;

import com.aengussong.randomuserlist.application.RandomUserApplication;
import com.aengussong.randomuserlist.di.module.NetworkModule;
import com.aengussong.randomuserlist.di.module.ProviderModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {ActivityBuilder.class,
        NetworkModule.class,
        ProviderModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<RandomUserApplication> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<RandomUserApplication> {

    }
}