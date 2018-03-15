package com.xjcrepe.aibo.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.xjcrepe.aibo.base.AiboViewModelFactory;
import com.xjcrepe.aibo.weapons.WeaponsViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
abstract class ViewModelBuilder {

    @Binds
    @IntoMap
    @ViewModelKey(WeaponsViewModel.class)
    abstract ViewModel bindsWeaponseViewModel(WeaponsViewModel weaponsViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(AiboViewModelFactory factory);
}
