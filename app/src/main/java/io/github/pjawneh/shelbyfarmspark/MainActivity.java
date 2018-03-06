package io.github.pjawneh.shelbyfarmspark;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by pjawneh on 2/23/2018.
 */

public class MainActivity extends AppCompatActivity{
    Toolbar toolbar;
    TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        toolbar = findViewById(R.id.hButton);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mTitle = toolbar.findViewById(R.id.toolbar_title);


        final Fragment exploreFrag = new ExploreFragment();
        final Fragment mapFrag = new MapFragment();
        final Fragment joinFrag = new JoinFragment();
        final Fragment aboutFrag = new AboutFragment();

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        BottomNavHelper.disableShiftMode(bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_explore: //Explore
                        commitFragment(exploreFrag);
                        mTitle.setText("Explore");
                        break;
                    case R.id.nav_map: //Map
                        mTitle.setText("Map");
                        commitFragment(mapFrag);
                        break;
                    case R.id.nav_join: //Join
                        commitFragment(joinFrag);
                        mTitle.setText("Join");
                        break;
                    case R.id.nav_info: //About
                        commitFragment(aboutFrag);
                        mTitle.setText("About");
                        break;
                    default:
                        commitFragment(exploreFrag);
                        break;
                }

                return true;
            }
        });

        bottomNav.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_explore: //Explore
                        commitFragment(exploreFrag);
                        mTitle.setText("Explore");
                        break;
                    case R.id.nav_map: //Map
                        mTitle.setText("Map");
                        commitFragment(mapFrag);
                        break;
                    case R.id.nav_join: //Join
                        commitFragment(joinFrag);
                        mTitle.setText("Join");
                        break;
                    case R.id.nav_info: //About
                        commitFragment(aboutFrag);
                        mTitle.setText("About");
                        break;
                    default:
                        commitFragment(exploreFrag);
                        break;
                }
            }
        });

        if(savedInstanceState == null){
            bottomNav.setSelectedItemId(R.id.nav_explore);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment alerts = new AlertsFragment();
        commitFragment(alerts);
        mTitle.setText("Alerts");
        return super.onOptionsItemSelected(item);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.options_menu, popup.getMenu());
        popup.show();
    }

    private void commitFragment(Fragment fragment){
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction fragTransition = fm.beginTransaction();
        fragTransition.replace(R.id.viewframe,fragment).commit();
    }
}
