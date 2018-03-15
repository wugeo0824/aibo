package com.xjcrepe.aibo.weapons;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.xjcrepe.aibo.base.RxAwareViewModel;
import com.xjcrepe.aibo.base.RxSchedulers;
import com.xjcrepe.aibo.model.Weapon;
import com.xjcrepe.aibo.network.MHWService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class WeaponsViewModel extends RxAwareViewModel {

    private final MHWService mhwService;
    private final RxSchedulers rxSchedulers;

    @Inject
    WeaponsViewModel(MHWService mhwService, RxSchedulers rxSchedulers) {
        this.mhwService = mhwService;
        this.rxSchedulers = rxSchedulers;
    }

    private MutableLiveData<List<Weapon>> weaponMutableLiveData;

    public MutableLiveData<List<Weapon>> getWeapons() {
        if (weaponMutableLiveData == null) {
            weaponMutableLiveData = new MutableLiveData<>();
        }

        if (weaponMutableLiveData.getValue() == null || weaponMutableLiveData.getValue().isEmpty()) {
            loadWeapons();
        }

        Log.d("MutableLiveData", "getWeapons: ");

        return weaponMutableLiveData;
    }

    private void loadWeapons() {
        Log.d("MutableLiveData", "loadWeapons: ");

        mhwService.getWeapons()
                .subscribeOn(rxSchedulers.getNetwork())
                .observeOn(rxSchedulers.getUi())
                .subscribe(new SingleObserver<List<Weapon>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposeWhenClear(d);
                    }

                    @Override
                    public void onSuccess(List<Weapon> weapons) {
                        weaponMutableLiveData.setValue(weapons);
                        Log.d("MutableLiveData", "onSuccess: " + weapons.size());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("MutableLiveData", "onError: " + e.toString());
                    }
                });
    }
}
