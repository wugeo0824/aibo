package com.xjcrepe.aibo.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.xjcrepe.aibo.base.RxSchedulers;
import com.xjcrepe.aibo.model.Weapon;
import com.xjcrepe.aibo.network.MHWService;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

@Singleton
public class WeaponRepository {

    private final static int ITEMS_PER_PAGE = 20;

    private final WeaponDao weaponDao;

    private final MHWService mhwService;

    private final RxSchedulers rxSchedulers;

    private MutableLiveData<List<Weapon>> weaponsLiveData;

    @Inject
    public WeaponRepository(WeaponDao weaponDao, MHWService mhwService, RxSchedulers rxSchedulers) {
        this.weaponDao = weaponDao;
        this.mhwService = mhwService;
        this.rxSchedulers = rxSchedulers;
        weaponsLiveData = new MutableLiveData<>();
    }

    public void loadWeapons(int page) {
        int offset = (page - 1) * ITEMS_PER_PAGE;

//        weaponDao.getWeaponsFromIndex(ITEMS_PER_PAGE, offset)
        weaponDao.getAll()
                .subscribeOn(rxSchedulers.getComputation())
                .subscribe(new SingleObserver<List<Weapon>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //NO-OP
                    }

                    @Override
                    public void onSuccess(List<Weapon> weapons) {
                        if (weapons != null && !weapons.isEmpty()){
                            weaponsLiveData.setValue(weapons.subList(0,19));
                        } else {
                            loadFromNetwork();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        loadFromNetwork();
                    }
                });
    }

    public MutableLiveData<List<Weapon>> getWeaponsLiveData() {
        return weaponsLiveData;
    }

    private void loadFromNetwork() {
        mhwService.getWeapons()
                .subscribeOn(rxSchedulers.getNetwork())
                .subscribe(new SingleObserver<List<Weapon>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        //NO-OP
                    }

                    @Override
                    public void onSuccess(List<Weapon> weapons) {
                        weaponDao.insertAll(weapons);
                        weaponsLiveData.setValue(weapons.subList(0, 19));
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("WeaponsRepo", "loadFromNetwork error: " + e.getLocalizedMessage());
                    }
                });
    }
}
