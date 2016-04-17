package jaenwawe.miniInventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements Fragment_FrontPage.OnFragmentInteractionListener, NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private MenuItem menuItemAboutMe;
    private MenuItem menuItemonHand;
    private MenuItem menuItemPending;
    private MenuItem menuItemUnordered;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    public void onFragmentInteraction(int fragment) {
//for task 2 and 3 load activities. n

        switch (fragment) {
            case 1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_main_nav, Fragment_AboutMe.newInstance("1", "2"))
                        .addToBackStack(null)
                        .commit();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        //initialize toolbar as actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar_bottom_nav);
        toolbar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);

        //items activity_navigation_drawer.xml
        menuItemAboutMe = (MenuItem) findViewById(R.id.itemAboutMe);
        menuItemonHand = (MenuItem) findViewById(R.id.itemOnHand);
        menuItemPending = (MenuItem) findViewById(R.id.itemInventoryPending);
        menuItemUnordered = (MenuItem) findViewById(R.id.itemInventoryUnordered);


        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };

        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //hamburger icon appears with sync state
        actionBarDrawerToggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container_main_nav, Fragment_AboutMe.newInstance("1","2"))
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_blue_share_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_edit:
                Toast.makeText(getApplicationContext(), "Pen Clicked", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_bluetooth:
                Toast.makeText(getApplicationContext(), "Activity Two", Toast.LENGTH_LONG).show();
                return true;

            case R.id.action_blue_share:
                Toast.makeText(getApplicationContext(), "Activity Three", Toast.LENGTH_LONG).show();
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);//super delegates to fragement
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.itemAboutMe:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_main_nav, Fragment_AboutMe.newInstance("1", "2"))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.itemOnHand:

                Intent intentOnHand = new Intent(getApplicationContext(), ActivityRecyclerView.class);
                startActivity(intentOnHand);
                break;

            case R.id.itemInventoryPending:

                Intent intentInventoryPending = new Intent(getApplicationContext(), ActivityRecyclerView.class);
                startActivity(intentInventoryPending );
                break;


            case R.id.itemInventoryUnordered:

                Intent intentInventoryUnOrdered = new Intent(getApplicationContext(), ActivityRecyclerView.class);
                startActivity(intentInventoryUnOrdered);
                break;


            default:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_main_nav, FragmentRecyclerView.newInstance(0))
                        .addToBackStack(null)
                        .commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}

