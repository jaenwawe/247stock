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
    private MenuItem menuItem1;
    private MenuItem menuItem2;
    private MenuItem menuItem3;
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
        menuItem1 = (MenuItem) findViewById(R.id.item1);
        menuItem2 = (MenuItem) findViewById(R.id.item2);

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
            case R.id.item1:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container_main_nav, Fragment_AboutMe.newInstance("1", "2"))
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.item2:

                Intent intent = new Intent(getApplicationContext(), ActivityRecyclerViewVone.class);
                startActivity(intent);
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

