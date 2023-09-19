package com.example.aitaro;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

public class CardViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;

    public CardViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.card_image);
    }
}
