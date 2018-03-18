package com.xjcrepe.aibo.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.xjcrepe.aibo.model.Weapon;

@Database(entities = {Weapon.class}, version = 1, exportSchema = false)
public abstract class MhwDb extends RoomDatabase{

    abstract public WeaponDao weaponDao();
}
