package com.xjcrepe.aibo.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.xjcrepe.aibo.base.RxSchedulers;
import com.xjcrepe.aibo.data.MhwDb;
import com.xjcrepe.aibo.data.WeaponDao;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
abstract class ApplicationModule {

    @Binds
    abstract Context bindContext(Application application);

    @Provides
    @Singleton
    static RxSchedulers provideRxSchedulers() {
        return new RxSchedulers();
    }

    @Provides
    @Singleton
    static MhwDb provideDb(Context application) {
        return Room.databaseBuilder(application, MhwDb.class, "mhw-db").build();
    }

    @Provides
    @Singleton
    static WeaponDao provideWeaponDao(MhwDb mhwDb) {
        return mhwDb.weaponDao();
    }
}
