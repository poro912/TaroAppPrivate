package com.Integration.aitaroapp.Page.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Item.StoreBuyItemClass;
import com.Integration.aitaroapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class StoreItemRecyclerViewAdapter extends RecyclerView.Adapter<StoreItemRecyclerViewAdapter.StoreViewHolder> {
    private ArrayList<StoreBuyItemClass> imageList = new ArrayList<>();

    public StoreItemRecyclerViewAdapter(ArrayList<StoreBuyItemClass> arrayList){
        this.imageList = arrayList;
    }

    @NonNull
    @NotNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_sotre_item, parent, false);

        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StoreViewHolder holder, int position) {
        StoreBuyItemClass storeBuyItemClass = imageList.get(position);
        holder.image_item.setImageResource(storeBuyItemClass.getImage_item());
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    class StoreViewHolder extends RecyclerView.ViewHolder{
        private ImageView image_item;
        public StoreViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

           image_item = itemView.findViewById(R.id.card_image_item);
        }
    }
}
