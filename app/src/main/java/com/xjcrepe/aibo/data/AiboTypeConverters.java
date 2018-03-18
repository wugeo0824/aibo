package com.xjcrepe.aibo.data;

import android.arch.persistence.room.TypeConverter;

import com.xjcrepe.aibo.model.WeaponType;

public class AiboTypeConverters {

    @TypeConverter
    public static String fromWeaponTypeToString(WeaponType weaponType) {
        return weaponType.getWeaponsType();
    }

    @TypeConverter
    public static WeaponType fromStringToWeaponType(String typeString) {
        return WeaponType.valueOf(typeString);
    }
}
