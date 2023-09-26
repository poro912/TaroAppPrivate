package com.Integration.aitaroapp.Page.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Item.StoreRecyclerViewItem;
import com.Integration.aitaroapp.Page.StorePage.BackgroundBuyActivity;
import com.Integration.aitaroapp.Page.StorePage.CardBuyActivity;
import com.Integration.aitaroapp.Page.StorePage.SpreadBuyActivity;
import com.Integration.aitaroapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StoreSettingAdapter extends RecyclerView.Adapter<StoreSettingAdapter.StoreViewHolder> {

    private ArrayList<StoreRecyclerViewItem> itemList = new ArrayList<>();

    public StoreSettingAdapter(ArrayList<StoreRecyclerViewItem> itemData) {
        itemList = itemData;
    }

    @NonNull
    @NotNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.store_recycler_view, parent, false);
        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StoreViewHolder holder, @SuppressLint("RecyclerView") int position) {
        StoreRecyclerViewItem item = itemList.get(position);
        holder.storeImage.setImageResource(item.getStoreImage());
        holder.storeText.setText(item.getStoreText());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int mPosition = holder.getAdapterPosition();

                Log.d("loglog", String.valueOf(mPosition));
                Context context = view.getContext();


                if (position == 0) {
                    Intent card_activity = new Intent(context, CardBuyActivity.class);
                    context.startActivity(card_activity);

                } else if (position == 1) {
                    Intent spread_activity = new Intent(context, SpreadBuyActivity.class);
                    context.startActivity(spread_activity);

                } else if (position == 2) {
                    Intent background_activity = new Intent(context, BackgroundBuyActivity.class);
                    context.startActivity(background_activity);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    //뷰홀더 클래스
    public class StoreViewHolder extends RecyclerView.ViewHolder {
        private ImageView storeImage;
        private TextView storeText;
        private CardView cardView;

        public StoreViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.StoreCardView);
            storeImage = itemView.findViewById(R.id.storeImage);
            storeText = itemView.findViewById(R.id.storeText);
        }


    }
}