package com.example.aitaro;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private List<CardItem> cardItems;

    public CardAdapter(List<CardItem> cardItems) {
        this.cardItems = cardItems;
    }
    public void removeCard(int position) {
        cardItems.remove(position);
        notifyItemRemoved(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CardItem cardItem = cardItems.get(position);
        holder.cardImageView.setImageResource(cardItem.getImageResource());
    }

    @Override
    public int getItemCount() {
        return cardItems.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public CardViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.card_image);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
        CardItem currentItem = cardItems.get(position);
        holder.cardImageView.setImageResource(currentItem.getImageResource());

        // 카드 이미지 클릭 리스너 설정
        holder.cardImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 카드를 클릭하여 사라지는 동작을 수행
                removeCard(holder.getAdapterPosition());
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView cardImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardImageView = itemView.findViewById(R.id.card_image);
        }
    }
}
