package jaenwawe.miniInventory;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;

public class Fragment_MasterDetail extends Fragment {

    ProductData ProductData = new ProductData();
    ImageView productImage;
    TextView productNameTV;
    TextView productWeightTV;
    TextView productDescriptionTV;
    TextView productPriceTV;
    TextView productAISNTV;

    ShareActionProvider mShareActionProvider;

    int position = 0;
    HashMap<String, ?> ARG_PARAM1 = (HashMap<String, ?>) ProductData.getItem(position);
    private static final String ARG_PARAM2 = "param2";

    public Fragment_MasterDetail() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, final MenuInflater inflater) {
        //prevent duplication
        if (menu.findItem(R.id.cardList) == null)
            inflater.inflate(R.menu.detail_fragment_actionprovider, menu);

        MenuItem shareItem = menu.findItem(R.id.action_share_detailsFragment);
        mShareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        shareItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(Intent.EXTRA_TEXT, (String) ProductData.getItem(position).get("name"));
                startActivity(intentShare);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        HashMap Product = (HashMap<String, ?>) getArguments().getSerializable(ARG_PARAM2);

        int imageId = (Integer) Product.get("image");
        String productName = (String) Product.get("name");
        String productAISN = (String) Product.get("aisn");
        String productweight = (String) Product.get("weight");
        String productDescription = (String) Product.get("description");
        String productPrice = (String) Product.get("price").toString();


        View view = inflater.inflate(R.layout.fragment_master_detail, container, false);

        //configure xml objects
        productNameTV = (TextView) view.findViewById(R.id.ProductName);
        productImage = (ImageView) view.findViewById(R.id.ProductImage);
        productPriceTV = (TextView) view.findViewById(R.id.ProductPrice);
        productWeightTV = (TextView) view.findViewById(R.id.ProductWeight);
        productDescriptionTV = (TextView) view.findViewById(R.id.ProductDescription);
        productAISNTV = (TextView) view.findViewById(R.id.ProductAISN);

        //set XML objects to values in productData hashmap
        productNameTV.setText(productName);
        productAISNTV.setText(productAISN);
        productDescriptionTV.setText(productDescription);
        productWeightTV.setText(productweight);
        productPriceTV.setText((productPrice.toString()));
        productImage.setImageResource(imageId);

        return view;
    }

    public static Fragment_MasterDetail newInstance(HashMap<String, ?> Product, View sharedImage) {
        Fragment_MasterDetail fragment = new Fragment_MasterDetail();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM2, Product);
        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment_MasterDetail newInstance(HashMap<String, ?> Product) {
        Fragment_MasterDetail fragment = new Fragment_MasterDetail();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM2, Product);
        fragment.setArguments(args);
        return fragment;
    }
}