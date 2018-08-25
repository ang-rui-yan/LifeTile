package com.quintuple.lifetile;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.btmNavBar);
        BottomNavigationBarHelper.disableShiftMode(bottomNavigationView);

        final Fragment activitiesFragment = new ActivitiesFragment();
        final Fragment scheduleFragment = new ScheduleFragment();
        final Fragment rpgFragment = new RPGFragment();
        final Fragment rewardsFragment = new RewardsFragment();
        final Fragment profileFragment = new ProfileFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container, rpgFragment).commit();

        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (item.getItemId()) {
                    case R.id.nav_activities:
                        fragmentTransaction.replace(R.id.container, activitiesFragment).commit();
                        return true;
                    case R.id.nav_schedule:
                        fragmentTransaction.replace(R.id.container, scheduleFragment).commit();
                        return true;
                    case R.id.nav_rpg:
                        fragmentTransaction.replace(R.id.container, rpgFragment).commit();
                        return true;
                    case R.id.nav_rewards:
                        fragmentTransaction.replace(R.id.container, rewardsFragment).commit();
                        return true;
                    case R.id.nav_profile:
                        fragmentTransaction.replace(R.id.container, profileFragment).commit();
                        return true;
                }
                return true;
            }
        });


    }


}
