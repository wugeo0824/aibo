package com.xjcrepe.aibo.weapons;

import android.arch.lifecycle.MutableLiveData;

import com.xjcrepe.aibo.base.RxAwareViewModel;
import com.xjcrepe.aibo.base.RxSchedulers;
import com.xjcrepe.aibo.data.WeaponRepository;
import com.xjcrepe.aibo.model.Weapon;
import com.xjcrepe.aibo.network.MHWService;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

public class WeaponsViewModel extends RxAwareViewModel {

    private final WeaponRepository weaponRepository;
    private final RxSchedulers rxSchedulers;
    private MutableLiveData<List<Weapon>> weaponMutableLiveData;

    @Inject
    WeaponsViewModel(WeaponRepository weaponRepository, RxSchedulers rxSchedulers) {
        this.weaponRepository = weaponRepository;
        this.rxSchedulers = rxSchedulers;
    }

    public MutableLiveData<List<Weapon>> getWeapons() {
        if (weaponMutableLiveData == null) {
            weaponMutableLiveData = new MutableLiveData<>();
        }

        if (weaponMutableLiveData.getValue() == null || weaponMutableLiveData.getValue().isEmpty()) {
            loadWeapons();
        }

        return weaponMutableLiveData;
    }

    private void loadWeapons() {
        weaponRepository.loadWeapons(1)
                .observeOn(rxSchedulers.getUi())
                .subscribe(new SingleObserver<List<Weapon>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // TODO: send loading state
                        disposeWhenClear(d);
                    }

                    @Override
                    public void onSuccess(List<Weapon> weapons) {
                        weaponMutableLiveData.setValue(weapons);
                    }

                    @Override
                    public void onError(Throwable e) {
                        // TODO: send error state
                    }
                });
    }
}
