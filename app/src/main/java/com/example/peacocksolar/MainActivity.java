package com.example.peacocksolar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.peacocksolar.Components.AddLeadFragment;
import com.example.peacocksolar.Components.HomeFragment;
import com.example.peacocksolar.Components.ProfileFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // WIDGETS
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private LinearLayout signOut;

    // VAR
    private HomeFragment homeFragmentAdapter;
    private ActionBarDrawerToggle actionBarDrawerToggleRequest;
    private static Menu menu;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment = new HomeFragment();

        switch (menuItem.getItemId()){

            case R.id.nav_my_leads:
                break;

            case R.id.nav_add_lead:
                fragment = new AddLeadFragment();
                break;

            case R.id.nav_check_proposal:
                break;

            case R.id.nav_check_incentive:
                break;

            case R.id.nav_profile:
                fragment = new ProfileFragment();
                break;

            case R.id.nav_raise_query:
                break;

            case R.id.nav_learn_more:
                break;
        }

        // LOAD THE CLICKED FRAGMENT
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();

        // CLOSE DRAWER AFTER LOADING THE CLICKED FRAGMENT
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeFragmentAdapter = new HomeFragment();
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        signOut = findViewById(R.id.nav_sign_out);
        toolbar = findViewById(R.id.toolbar);

        // GET THE MENU
        menu = navigationView.getMenu();


        /* ========================= TOOLBAR SETUP -> START ===========================*/
        // SET TOOLBAR
        setSupportActionBar(toolbar);

        // SETTING UP OF DRAWER
        actionBarDrawerToggleRequest = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
        );

        // ADD LISTENER
        drawerLayout.addDrawerListener(actionBarDrawerToggleRequest);

        // DISPLAYING HAND-BERGER
        actionBarDrawerToggleRequest.setDrawerIndicatorEnabled(true);

        // SYNCING THE DRAWER
        actionBarDrawerToggleRequest.syncState();
        /* ========================= TOOLBAR REQUEST SETUP -> END ===========================*/


        // HANDLING CLICK ON "SETTINGS"
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: HANDLE SIGN-OUT
                Toast.makeText(MainActivity.this, "Signed Out", Toast.LENGTH_SHORT).show();
            }
        });

        // SETTING LISTENER FOR NAVIGATION VIEW
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new HomeFragment())
                .commit();

        // MAKE MENU-ITEM "nav_donate" AS CHECKED SINCE "DONATE FRAGMENT" IS THE DEFAULT FRAGMENT
        menu.findItem(R.id.nav_my_leads).setChecked(true);
    }
}