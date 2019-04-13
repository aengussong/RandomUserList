package com.aengussong.randomuserlist.di;

import com.aengussong.randomuserlist.DetailsActivity;
import com.aengussong.randomuserlist.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity mainActivity();

    @ContributesAndroidInjector
    abstract DetailsActivity detailsActivity();
}