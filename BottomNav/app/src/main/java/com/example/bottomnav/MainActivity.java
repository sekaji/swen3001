package com.example.bottomnav;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView= findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CanvasFragment());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener= new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectFragement=null;

            switch (menuItem.getItemId()){
                case R.id.canvas_frag:
                    selectFragement= new CanvasFragment();
                    break;
                case R.id.grid_frag:
                    selectFragement= new GridFragment();
                    break;
                case R.id.dialog_view:
                    selectFragement= new DialogsFragment();
                    break;
                case R.id.component_view:
                    selectFragement= new ComponentsFragment();
                    break;
                case R.id.switch_view:
                    selectFragement= new SwitchFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragement).commit();
            return true;
        }
    };

}
