package com.xjcrepe.aibo.weapons;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.xjcrepe.aibo.R;
import com.xjcrepe.aibo.model.Weapon;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.support.DaggerAppCompatActivity;

public class WeaponsActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @BindView(R.id.rvWeapons)
    RecyclerView rvWeapons;

    private WeaponsAdapter weaponsAdapter;
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

        weaponsAdapter = new WeaponsAdapter(Collections.<Weapon>emptyList());
        rvWeapons.setLayoutManager(new LinearLayoutManager(this));
        rvWeapons.setHasFixedSize(false);
        rvWeapons.setAdapter(weaponsAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();

        weaponsViewModel.getWeapons().observe(this, new Observer<List<Weapon>>() {
            @Override
            public void onChanged(@Nullable final List<Weapon> weapons) {
                if (weapons != null) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            weaponsAdapter.refresh(weapons.subList(0, 10));
                        }
                    });
                } else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(WeaponsActivity.this, "Null Weapon Data", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });
    }
}
