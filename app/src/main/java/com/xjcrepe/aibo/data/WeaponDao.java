package com.xjcrepe.aibo.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.xjcrepe.aibo.model.Weapon;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface WeaponDao {

    @Query("SELECT * FROM weapons")
    public Single<List<Weapon>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAll(List<Weapon> weapons);

    @Query("SELECT * FROM weapons LIMIT (:itemsPerPage) OFFSET (:offsetNum)")
    public Single<List<Weapon>> getWeaponsFromIndex(int itemsPerPage, int offsetNum);
}
