package com.aengussong.randomuserlist.di;

import com.aengussong.randomuserlist.ui.DetailsActivity;
import com.aengussong.randomuserlist.ui.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract DetailsActivity detailsActivity();
}