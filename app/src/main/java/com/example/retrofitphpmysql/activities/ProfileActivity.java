package com.example.retrofitphpmysql.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.retrofitphpmysql.R;
import com.example.retrofitphpmysql.fragment.HomeFragment;
import com.example.retrofitphpmysql.fragment.SettingsFragment;
import com.example.retrofitphpmysql.fragment.UserFragment;
import com.example.retrofitphpmysql.storgae.SharedPrefManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnNavigationItemSelectedListener(this);

        displayFragment(new HomeFragment());
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.relativeLayout, fragment)
                .commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch(item.getItemId()){
            case R.id.menu_home:
                fragment = new HomeFragment();
                break;
            case R.id.menu_users:
                fragment = new UserFragment();
                break;
            case R.id.menu_settings:
                fragment = new SettingsFragment();
                break;
        }

        if(fragment != null){
            displayFragment(fragment);
        }

        return false;
    }
}