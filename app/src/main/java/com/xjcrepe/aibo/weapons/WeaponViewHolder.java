package com.xjcrepe.aibo.weapons;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.xjcrepe.aibo.R;
import com.xjcrepe.aibo.model.Weapon;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by LiXijun on 2018/3/17.
 */

public class WeaponViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.ivWeapon)
    ImageView ivWeapon;

    @BindView(R.id.tvWeaponName)
    TextView tvWeaponName;

    @BindView(R.id.tvWeaponAttack)
    TextView tvWeaponAttack;

    public WeaponViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public static WeaponViewHolder initViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_weapon, parent, false);
        return new WeaponViewHolder(view);
    }

    public void setItem(Weapon weapon) {
        tvWeaponName.setText(weapon.getName());
        tvWeaponAttack.setText("Rarity" + weapon.getRarity());
    }
}
