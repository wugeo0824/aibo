package com.xjcrepe.aibo.weapons;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

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
    public WeaponsViewModel(MHWService mhwService, RxSchedulers rxSchedulers) {
        this.mhwService = mhwService;
        this.rxSchedulers = rxSchedulers;
    }

    private MutableLiveData<List<Weapon>> weaponMutableLiveData;

    public MutableLiveData<List<Weapon>> getWeapons() {
        if (weaponMutableLiveData == null) {
            weaponMutableLiveData = new MutableLiveData<>();
            loadWeapons();
        }

        return weaponMutableLiveData;
    }

    private void loadWeapons() {
        mhwService.getWeapons()
                .subscribeOn(rxSchedulers.getNetwork())
                .subscribe(new SingleObserver<List<Weapon>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposeWhenClear(d);
                    }

                    @Override
                    public void onSuccess(List<Weapon> weapons) {
                        weaponMutableLiveData.setValue(weapons);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
