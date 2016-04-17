package jaenwawe.miniInventory;

import android.support.v4.app.Fragment;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

public class Activity_MasterDetails extends AppCompatActivity {

    Fragment mFragment;
    ProductData product;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_details);
        product = new ProductData();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, FragmentRecyclerView.newInstance(0))
                    .commit();
        }
    }

    protected void replaceFragment(HashMap<String, ?> data, View sharedImage) {

        mFragment = Fragment_MasterDetail.newInstance(data, sharedImage);

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main_container, mFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

