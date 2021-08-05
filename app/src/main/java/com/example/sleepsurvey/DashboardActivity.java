package com.example.sleepsurvey;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.view.View;
import android.os.Bundle;
import android.content.Intent;

import com.google.android.material.navigation.NavigationView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        NavController nc = Navigation.findNavController(this,R.id.fragmentContainerView);
        NavigationView nv = findViewById(R.id.navigationView);
        NavigationUI.setupWithNavController(nv,nc);


    }

    public void launchSensors(View v) {
        startActivity(new Intent(this, SensingActivity.class));

    }
}