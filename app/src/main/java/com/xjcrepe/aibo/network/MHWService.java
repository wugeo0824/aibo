package com.xjcrepe.aibo.network;

import com.xjcrepe.aibo.model.Weapon;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MHWService {

    @GET("weapons")
    Single<List<Weapon>> getWeapons();

    @GET("weapons/{id}")
    Single<Weapon> getWeaponById(@Path("id") String id);

}
