package jaenwawe.miniInventory;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.ImageView;


import java.util.HashMap;
import java.util.Locale;

/**
 * Created by Jae Nwawe on 2/21/2016.
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    int count;
    ProductData productData;

    public MyFragmentPagerAdapter(FragmentManager fm, int size) {
        super(fm);
        count = size;
    }

    @Override
    public Fragment getItem(int position) {

        productData = new ProductData();
        ImageView sharedImage = null;
        HashMap<String, ?> product = (HashMap<String, ?>) productData.getItem(position);

        Fragment_MasterDetail details = Fragment_MasterDetail.newInstance(product);
        return details;
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        HashMap<String, ?> movie = (HashMap<String, ?>) productData.getItem(position);
        String name = (String) movie.get("name");
        return name.toUpperCase(l);
    }
}