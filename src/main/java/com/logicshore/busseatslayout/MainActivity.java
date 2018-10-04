package com.logicshore.busseatslayout;



import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout=(DrawerLayout)findViewById(R.id.navigation_Drawer_view);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setTitle("My Application Bus");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        fragmentManager=getSupportFragmentManager();


        //getSupportActionBar().setHomeButtonEnabled(true);

        //toolbar.setTitle("My Application Bus");

        if (findViewById(R.id.fragmentcontainer) != null) {
            if (savedInstanceState != null) {
                return;
            }
            Seat_Fragment seat_fragment = new Seat_Fragment();

            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction()
                    .add(R.id.fragmentcontainer,seat_fragment,null);
            fragmentTransaction.commit();


        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
