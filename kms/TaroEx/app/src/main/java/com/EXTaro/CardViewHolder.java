package com.EXTaro;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.AITaro.taro.R;

public class CardViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;

    public CardViewHolder(View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.card_image);
    }
}
