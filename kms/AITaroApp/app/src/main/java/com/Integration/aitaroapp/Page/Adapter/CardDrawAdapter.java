package com.Integration.aitaroapp.Page.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Item.CardItem;
import com.Integration.aitaroapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CardDrawAdapter extends RecyclerView.Adapter<CardDrawAdapter.DrawCardHolder> {

    private ArrayList<CardItem> drawcardItems = new ArrayList<>();
    private Context mcontext;

    public CardDrawAdapter(Context context, ArrayList<CardItem> cardItems) {
        this.mcontext = context;
        this.drawcardItems = cardItems;
    }

    @Override
    public int getItemCount() {
        return drawcardItems.size();
    }

    @NonNull
    @NotNull
    @Override
    public DrawCardHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.draw_card_recycler_view, parent, false);
        return new DrawCardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DrawCardHolder holder, int position) {
        CardItem cardItem = drawcardItems.get(position);
        holder.back_of_taro_card.setImageResource(cardItem.getCard_item());

        holder.back_of_taro_card.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                removeCard(holder.getAdapterPosition());
            }
        });
    }

    private void removeCard(int position){
        drawcardItems.remove(position);
        notifyItemRemoved(position);
    }

    public void addItem(CardItem item) {
        drawcardItems.add(item);
    }


    public class DrawCardHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private ImageView back_of_taro_card;
        public DrawCardHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.draw_card_view);
            back_of_taro_card = itemView.findViewById(R.id.back_of_card);
        }
    }
}
