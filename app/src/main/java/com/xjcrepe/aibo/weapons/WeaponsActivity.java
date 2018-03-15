package com.xjcrepe.aibo.weapons;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.xjcrepe.aibo.R;
import com.xjcrepe.aibo.model.Weapon;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class WeaponsActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.tvWeaponsCount)
    TextView tvWeaponsCount;

    private WeaponsViewModel weaponsViewModel;

    public static Intent createIntent(Context context) {
        return new Intent(context, WeaponsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon);
        ButterKnife.bind(this);

        weaponsViewModel = ViewModelProviders.of(this, viewModelFactory).get(WeaponsViewModel.class);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("onStart", "on start: ");
        weaponsViewModel.getWeapons().observe(this, new Observer<List<Weapon>>() {
            @Override
            public void onChanged(@Nullable List<Weapon> weapons) {
                Log.d("onStart", "onChanged: ");
                if (weapons != null) {
                    tvWeaponsCount.setText("size is: " + weapons.size());
                } else {
                    tvWeaponsCount.setText("Null Weapons Data");
                }
            }
        });
    }
}
