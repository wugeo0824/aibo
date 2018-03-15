package com.xjcrepe.aibo.di;

import com.xjcrepe.aibo.dashboard.MainActivity;
import com.xjcrepe.aibo.weapons.WeaponsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract MainActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector()
    abstract WeaponsActivity weaponsActivity();

}
