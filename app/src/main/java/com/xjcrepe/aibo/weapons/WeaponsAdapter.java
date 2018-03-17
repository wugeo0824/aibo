package com.xjcrepe.aibo.weapons;

import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.xjcrepe.aibo.model.Weapon;

import java.util.List;

public class WeaponsAdapter extends RecyclerView.Adapter<WeaponViewHolder> {

    private List<Weapon> weaponList;

    public WeaponsAdapter(List<Weapon> weaponList) {
        this.weaponList = weaponList;
    }

    public void refresh(List<Weapon> weaponsNew) {
//        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new WeaponsDiffCallback(weaponList, weaponsNew));
//        diffResult.dispatchUpdatesTo(this);
        weaponList = weaponsNew;
        notifyDataSetChanged();
    }

    @Override
    public WeaponViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return WeaponViewHolder.initViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(WeaponViewHolder holder, int position) {
        Weapon weapon = weaponList.get(position);
        holder.setItem(weapon);
    }

    @Override
    public int getItemCount() {
        return weaponList.size();
    }
}
