package com.xjcrepe.aibo.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.xjcrepe.aibo.R;
import com.xjcrepe.aibo.weapons.WeaponsActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btnWeapons)
    Button btnWeapons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btnWeapons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onWeaponClick();
            }
        });
    }

    private void onWeaponClick() {
        Intent intent = WeaponsActivity.createIntent(MainActivity.this);
        startActivity(intent);
    }
}
