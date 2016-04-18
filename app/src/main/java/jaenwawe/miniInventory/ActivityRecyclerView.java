package jaenwawe.miniInventory;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;

import java.util.HashMap;

public class ActivityRecyclerView extends AppCompatActivity implements FragmentRecyclerView.OnRowClick {

    RecyclerView mRecyclerView;
    ProductData productData;
    ImageButton productImage;
    private Toolbar toolbar;
    private SearchView search;

  @Override
  public void onItemSelected(HashMap<String, ?> product, View sharedImage) {

        productData = new ProductData();
      Fragment_MasterDetail details = Fragment_MasterDetail.newInstance(product, sharedImage);
      details.setSharedElementEnterTransition(new DetailsTransition());
      details.setEnterTransition(new Fade());
      details.setExitTransition(new Fade());
      details.setSharedElementReturnTransition(new DetailsTransition());

      getSupportFragmentManager().beginTransaction()
              .replace(R.id.framelayout_container_recyclerview, details)
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

            FragmentRecyclerView fragment = FragmentRecyclerView.newInstance(0);
            fragment.setEnterTransition(new Slide(Gravity.BOTTOM));
            AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getApplicationContext(),
                    R.animator.fancy_animation);
            set.setTarget(productImage);
            set.start();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.framelayout_container_recyclerview, fragment)
                    .commit();
        }
    }


}