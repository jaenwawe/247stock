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
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;

public class Fragment_MasterDetail extends Fragment {

    MovieData movieData = new MovieData();
    ImageView movieImage;
    TextView movieNameTV;
    TextView movieDescTV;
    TextView movieYearTV;
    RatingBar movieRatingTV;
    TextView movieStarsTV;

    ShareActionProvider mShareActionProvider;

    int position = 0;
    HashMap<String, ?> ARG_PARAM1 = (HashMap<String, ?>) movieData.getItem(position);
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
                intentShare.putExtra(Intent.EXTRA_TEXT, (String) movieData.getItem(position).get("name"));
                startActivity(intentShare);
                return true;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        HashMap movie = (HashMap<String, ?>) getArguments().getSerializable(ARG_PARAM2);


        int imageId = (Integer) movie.get("image");
        String movieName = (String) movie.get("name");
        String movieYearString = (String) movie.get("year");
        String movieDescString = (String) movie.get("description");
        double movieRatingNum = (Double) movie.get("rating");
        String movieStarsString = (String) movie.get("stars");

        View view = inflater.inflate(R.layout.fragment_master_detail, container, false);

        //configure xml objects
        movieNameTV = (TextView) view.findViewById(R.id.movieTitle);
        movieImage = (ImageView) view.findViewById(R.id.movieImage);
        movieDescTV = (TextView) view.findViewById(R.id.movieDescription);
        movieYearTV = (TextView) view.findViewById(R.id.movieYear);
        movieRatingTV = (RatingBar) view.findViewById(R.id.ratingBar);
        movieStarsTV = (TextView) view.findViewById(R.id.movieStars);

        //set XML objects to values in MovieData hashmap
        movieNameTV.setText(movieName);
        movieImage.setImageResource(imageId);
        movieDescTV.setText(movieDescString);
        movieYearTV.setText(movieYearString);
        movieRatingTV.setRating((float) (movieRatingNum / 2));
        movieStarsTV.setText(movieStarsString);

        return view;
    }

    public static Fragment_MasterDetail newInstance(HashMap<String, ?> movie, View sharedImage) {
        Fragment_MasterDetail fragment = new Fragment_MasterDetail();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM2, movie);
        fragment.setArguments(args);
        return fragment;
    }
}
