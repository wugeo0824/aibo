package com.xjcrepe.aibo.di;

import com.xjcrepe.aibo.dashboard.MainActivity;
import com.xjcrepe.aibo.weapons.WeaponsActivity;
import com.xjcrepe.aibo.weapons.WeaponsActivityBuilder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @AcitivityScoped
    @ContributesAndroidInjector()
    abstract MainActivity mainActivity();

    @AcitivityScoped
    @ContributesAndroidInjector(modules = WeaponsActivityBuilder.class)
    abstract WeaponsActivity weaponsActivity();

}
