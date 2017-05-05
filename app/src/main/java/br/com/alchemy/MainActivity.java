package br.com.alchemy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import br.com.alchemy.fragment.AddEffectFragment;
import br.com.alchemy.fragment.AddIngredientFragment;
import br.com.alchemy.fragment.EditIngredientFragment;
import br.com.alchemy.fragment.MakePotionFragment;
import br.com.alchemy.model.IngredientObject;
import br.com.alchemy.util.Preferences;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AddIngredientFragment addIngredientFragment;
    private AddEffectFragment addEffectFragment;
    private EditIngredientFragment editIngredientFragment;
    private MakePotionFragment makePotionFragment;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        addIngredientFragment = new AddIngredientFragment();
        addEffectFragment = new AddEffectFragment();
        editIngredientFragment = new EditIngredientFragment();
        makePotionFragment = new MakePotionFragment();

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                fab.setVisibility(View.INVISIBLE);
                replaceFragment(addIngredientFragment);
            }
        });

        replaceFragment(makePotionFragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.app_content, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(fab.getVisibility() == View.INVISIBLE){
            fab.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onBackPressed() {
        if(fab.getVisibility() == View.INVISIBLE){
            fab.setVisibility(View.VISIBLE);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Preferences.clearList(Preferences.INGREDIENT_LIST);
        } else if (id == R.id.nav_size) {
            List<IngredientObject> listIngredient = Preferences.getIngredients();
            Toast.makeText(this, "Existem "+listIngredient.size()+" ingredientes", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_edit) {
            replaceFragment(editIngredientFragment);
        } else if (id == R.id.nav_new_effect) {
            replaceFragment(addEffectFragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
