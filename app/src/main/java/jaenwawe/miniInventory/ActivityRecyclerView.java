package jaenwawe.miniInventory;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.HashMap;

public class ActivityRecyclerView extends AppCompatActivity implements FragmentRecyclerView.OnRowClick {

    private Toolbar toolbar;
    private SearchView search;
    RecyclerView mRecyclerView;
    ProductData productData;

  @Override
    public void onItemSelected (HashMap<String, ?> Product, View sharedImage) {

        productData = new ProductData();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.framelayout_container_recyclerview, Fragment_MasterDetail.newInstance(Product, sharedImage))
                .addToBackStack(null)
                .commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        toolbar = (Toolbar) findViewById(R.id.toolbar_recyclerview);
        //initialize toolbar as actionbar
        toolbar.setVisibility(View.VISIBLE);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.framelayout_container_recyclerview, FragmentRecyclerView.newInstance(0))
                    .commit();
        }
    }


}