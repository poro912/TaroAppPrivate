package com.AITaro.taro.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.AITaro.taro.Items.RecyclerViewItem;
import com.AITaro.taro.Items.StoreRecyclerViewItem;
import com.AITaro.taro.R;
import com.StoreSettingPackage.StoreActivity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class StoreSettingAdapter extends RecyclerView.Adapter<StoreSettingAdapter.StoreViewHolder> {

    private ArrayList<StoreRecyclerViewItem> itemList = new ArrayList<>();

    public StoreSettingAdapter(ArrayList<StoreRecyclerViewItem> itemData){
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
    public void onBindViewHolder(@NonNull @NotNull StoreViewHolder holder, int position) {
       StoreRecyclerViewItem item = itemList.get(position);
       holder.storeImage.setImageResource(item.getStoreImage());
       holder.storeText.setText(item.getStoreText());

       holder.cardView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int mPosition = holder.getAdapterPosition();

               Context context = v.getContext();

               Intent moveActivity = new Intent(context, StoreActivity.class);
               moveActivity.putExtra("butCard", "buyCard");
               moveActivity.putExtra("buySpread", "buySpread");
               moveActivity.putExtra("buybg", "buybg");


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