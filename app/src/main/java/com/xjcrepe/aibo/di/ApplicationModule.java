package com.xjcrepe.aibo.di;

import android.app.Application;
import android.content.Context;

import com.xjcrepe.aibo.base.RxSchedulers;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

    @Provides
    @Singleton
    RxSchedulers provideRxScedulers() {
        return new RxSchedulers();
    }
}
