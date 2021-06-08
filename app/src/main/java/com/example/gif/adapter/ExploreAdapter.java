package com.example.gif.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gif.R;
import com.example.gif.model.explore.ExploreItem;

import java.util.ArrayList;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder> {

    private ArrayList<ExploreItem> exploreItems = new ArrayList<>();
    private Context context;
   // private static String BASE_IMAGE_URL = "https://api.tenor.com/v1/";

    public ExploreAdapter(Context context){this.context = context;}

    public void setData(ArrayList<ExploreItem> items){
        exploreItems.clear();
        exploreItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExploreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_explore,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExploreAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(exploreItems.get(position)
        .getImage()).into(holder.ivThumb);

        holder.tvTag.setText(exploreItems.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return exploreItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivThumb;
        TextView tvTag;
        CardView cvItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cvItem = itemView.findViewById(R.id.itemlist_cvk);
            ivThumb = itemView.findViewById(R.id.itemlist_ivk_thumbnail);
            tvTag = itemView.findViewById(R.id.itemlist_tv_name);
        }
    }
}
