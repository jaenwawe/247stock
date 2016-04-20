package jaenwawe.miniInventory;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class Activity_ViewPager extends AppCompatActivity {
    //view pager variables
    MyFragmentPagerAdapter myPagerAdapter;
    ViewPager mViewPager;
    ProductData productData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__view_pager);
        productData = new ProductData();

        myPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), productData.getSize());
        mViewPager = (ViewPager) findViewById(R.id.container_activity_view_pager);
        mViewPager.setAdapter(myPagerAdapter);
        mViewPager.setCurrentItem(3);
    }
}