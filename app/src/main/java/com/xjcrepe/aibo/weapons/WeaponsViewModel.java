package com.xjcrepe.aibo.weapons;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.xjcrepe.aibo.model.Weapon;

import java.util.List;

public class WeaponsViewModel extends ViewModel{

    private MutableLiveData<List<Weapon>> weaponMutableLiveData;

    public MutableLiveData<List<Weapon>> getWeapons() {
        if (weaponMutableLiveData == null) {
            weaponMutableLiveData = new MutableLiveData<>();
            loadWeapons();
        }

        return weaponMutableLiveData;
    }

    private void loadWeapons() {

    }
}
