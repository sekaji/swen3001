package com.drawingtest.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.drawingtest.R;
import com.drawingtest.ui.dialog.GridDialog;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Switch home_switch;
    private Button home_shapes, home_canvas, home_grid;
    private DrawerLayout home_drawer;
    private ActionBarDrawerToggle home_toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            setTheme(R.style.DarkTheme);
        } else setTheme(R.style.AppTheme);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home_switch = (Switch) findViewById(R.id.home_switch);
        home_canvas = (Button) findViewById(R.id.home_canvas);
        home_grid = (Button) findViewById(R.id.home_grid);
        home_shapes = (Button) findViewById(R.id.home_shapes);
        home_drawer= (DrawerLayout) findViewById(R.id.home_drawer);
        home_toggle= new ActionBarDrawerToggle(this, home_drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        home_drawer.addDrawerListener(home_toggle);
        home_toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        home_canvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickCanvas();
            }
        });

        home_grid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGrid();
            }
        });

        home_shapes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickShapes();
            }
        });

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            home_switch.setChecked(true);
        }

        home_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    restartApp();
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    restartApp();
                }
            }
        });
    }

    private void onClickShapes() {
        Intent intent = new Intent(getApplicationContext(), ShapeActivity.class);
        startActivity(intent);
    }

    private void onClickGrid() {
        Intent intent = new Intent(getApplicationContext(), GridActivity.class);
        startActivity(intent);
    }

    private void onClickCanvas() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    private void restartApp() {
        Intent intent= new Intent(getApplicationContext(), HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        if (home_toggle.onOptionsItemSelected(item)){
            return super.onOptionsItemSelected(item);
        }
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_canvas:
                Toast toast=Toast. makeText(getApplicationContext(),"Hello Javatpoint "+item.getItemId(),Toast. LENGTH_SHORT);
                toast.show();
        }


        /*if (id == R.id.nav_canvas) {
            Intent myIntent = new Intent(this, MainActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_shape) {
            Intent myIntent = new Intent(this, ShapeActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.nav_grid) {
            Intent myIntent = new Intent(this, GridActivity.class);
            startActivity(myIntent);
        /*} else if (id == R.id.nav_web) {
            Intent myIntent = new Intent(this, WebActivity.class);
            startActivity(myIntent);/*
        } else if (id == R.id.nav_share) {
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Best wishes to you :)");
            shareIntent.setType("text/plain");
            startActivity(shareIntent);
        } else if (id == R.id.nav_send) {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:xucanhao@gmail.com"));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Ask a question");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Do you like the Solar System or the Alpha Centauri?");
            startActivity(emailIntent);
        }
        *
         */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.home_drawer);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
