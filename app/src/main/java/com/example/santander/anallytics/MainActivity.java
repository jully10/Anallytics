package com.example.santander.anallytics;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Itens do Handle navigation view
        int id = item.getItemId();



        android.app.FragmentManager fragmentManager = getFragmentManager();

        //condição para cada link/conteudo_fragmento na package res.layout/vai retornar sempre true
        if (id == R.id.nav_primeira) {
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, new FregmentoPrimeiraTela()).commit();
        } else if (id == R.id.nav_segunda) {
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, new FregmentoSegundaTela()).commit();

        } else if (id == R.id.nav_terceira) {
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, new FregmentoTerceiraTela()).commit();
        }
        else if (id == R.id.nav_quarta) {
            fragmentManager.beginTransaction().replace(R.id.conteudo_fragmento, new FregmentoQuartaTela()).commit();
        }
        else if (id == R.id.nav_portal) {
            Intent intent = new Intent(this, Portal.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;


    }
}