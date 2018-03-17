package com.xjcrepe.aibo.weapons;

import android.support.v7.util.DiffUtil;

import com.xjcrepe.aibo.model.Weapon;

import java.util.List;

public class WeaponsDiffCallback extends DiffUtil.Callback {

    private List<Weapon> oldList;
    private List<Weapon> newList;

    public WeaponsDiffCallback(List<Weapon> oldList, List<Weapon> newList) {
        this.oldList = oldList;
        this.newList = newList;
    }

    @Override
    public int getOldListSize() {
        return oldList.size();
    }

    @Override
    public int getNewListSize() {
        return newList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        Weapon newItem = newList.get(newItemPosition);
        Weapon oldItem = oldList.get(oldItemPosition);
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Weapon newItem = newList.get(newItemPosition);
        Weapon oldItem = oldList.get(oldItemPosition);
        return oldItem.equals(newItem);
    }
}
