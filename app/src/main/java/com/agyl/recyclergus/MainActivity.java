package com.agyl.recyclergus;

import android.support.v4.app.*;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.*;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.agyl.recyclergus.adapters.DrawerRecyclerAdapter;
import com.agyl.recyclergus.models.DrawerListViewData;
import com.agyl.recyclergus.views.FoldersListFragment;
import com.agyl.recyclergus.views.SyncListFragment;

import java.util.ArrayList;


/**
 * Created by rouguiatoudiallo on 16-05-23.
 */

public class MainActivity extends AppCompatActivity implements ActionMode.Callback {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ArrayList<DrawerListViewData> drawerListViewDatas;
    private DrawerRecyclerAdapter adapter;
    private int selectPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerListViewDatas = new ArrayList<DrawerListViewData>();

        findViewById();

        setSupportActionBar(toolbar);

        initDrawerLayout();

        updateMainLayout();
    }

    private void findViewById() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        recyclerView = (RecyclerView) findViewById(R.id.drawerRecyclerView);
    }

    /**
     * Replace fragment to Main layout
     */

    public void updateMainLayout() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.container, new FoldersListFragment());
        transaction.commit();

        setTitle(drawerListViewDatas.get(0).getName());

        //close navigation drawer after replace fragment
        drawerLayout.closeDrawers();
    }

    private void initDrawerLayout() {

        setListViewData();

        //Mount recycler view with adapter
        adapter = new DrawerRecyclerAdapter(drawerListViewDatas);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //Listen for Open and Close Events
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };

        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        // Set the list's click listener
        adapter.setOnItemClickLister(new DrawerRecyclerAdapter.OnItemSelecteListener() {
            @Override
            public void onItemSelected(View v, int position) {
                selectPosition = position;
                //Toast.makeText(MainActivity.this, "You clicked at position: " + position, Toast.LENGTH_SHORT).show();
                drawerListViewItemClickDisplay(position);

            }
        });
    }

    private void setListViewData() {
        drawerListViewDatas.add(new DrawerListViewData(R.drawable.icon_menu_folders, "Dossiers"));
        drawerListViewDatas.add(new DrawerListViewData(R.drawable.icon_menu_sync, "Synchronisation"));
    }

    public void drawerListViewItemClickDisplay(int pos) {
        // update the main content by replacing fragments
        Fragment fragment = null;

        Log.i("GUS", "pos "+pos);

        switch (pos) {
            case 1:
                fragment = new FoldersListFragment();
                break;
            case 2:
                fragment = new SyncListFragment();
                break;

            default:
                break;
        }

        if (fragment != null) {

            Log.i("GUS", "Fragment not null");
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.container, fragment);
            transaction.commit();

            // update selected item and title, then close the drawer
            setTitle(drawerListViewDatas.get(pos-1).getName());
            drawerLayout.closeDrawers();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {

        mode.getMenuInflater().inflate(R.menu.menu_main, menu);
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }
}