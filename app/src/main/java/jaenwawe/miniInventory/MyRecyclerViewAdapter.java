package jaenwawe.miniInventory;

import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jae Nwawe on 2/24/2016.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<Map<String, ?>> mDataset;
    private Context mContext;
    OnItemClickListener mItemClickListener;
    private MyRecyclerViewAdapter mRecyclerViewAdapter;  //not in pg. 16, but necessary
    //why don't I create a viewholder here to show the views given from the adapter
    //why don't I create a position integer variable to show what views to display?

    public MyRecyclerViewAdapter(Context myContext, List<Map<String, ?>> myDataset) {
        mContext = myContext;
        mDataset = myDataset;
    }

    public interface OnItemClickListener {
        void onItemClick(View v, int position);

        void onItemLongClick(View v, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;

        switch (viewType) {
            case 0:
                v = LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.fragment_row, parent, false);
                break;

            case 1:  v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.fragment_row_above, parent, false);
                break;

            default:
                v = LayoutInflater.from(parent.getContext()).
                        inflate(R.layout.fragment_row_above, parent, false);
                break;
        }
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Map<String, ?> movie = mDataset.get(position);
        holder.bindMovieData(movie);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position){
        int type;
        double rating = (Double) mDataset.get(position).get("rating");
        if (rating > 8)
            type = 1;
        else type = 0;

        return type;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView vIcon;
        public TextView vTitle;
        public TextView vDescription;
        public CheckBox vCheckbox;

        public void bindMovieData(Map<String, ?> movie) {
            vTitle.setText((String) movie.get("name"));
            vDescription.setText((String) movie.get("description"));
            vIcon.setImageResource((Integer) movie.get("image"));
            vCheckbox.setChecked((Boolean) movie.get("selection"));
        }

        public ViewHolder(View v) {
            super(v); //What does this do?
            vIcon = (ImageView) v.findViewById(R.id.icon);
            vTitle = (TextView) v.findViewById(R.id.title);
            vDescription = (TextView) v.findViewById(R.id.description);
            vCheckbox = (CheckBox) v.findViewById(R.id.selection);

            vCheckbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    HashMap item = (HashMap) mDataset.get(getAdapterPosition());
                    item.put("selection", true);
                }
            });


            v.setOnClickListener((new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mItemClickListener != null) {
                        mItemClickListener.onItemClick(v, getAdapterPosition());
                    }
                }
            }));

            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    if (mItemClickListener != null)
                        mItemClickListener.onItemLongClick(v, getAdapterPosition());

                    return true;
                }
            });
        }
    }
}
