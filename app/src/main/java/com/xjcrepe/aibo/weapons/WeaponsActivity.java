package com.xjcrepe.aibo.weapons;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xjcrepe.aibo.R;

public class WeaponsActivity extends AppCompatActivity {

    public static Intent createIntent(Context context) {
        return new Intent(context, WeaponsActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weapon);
    }
}
