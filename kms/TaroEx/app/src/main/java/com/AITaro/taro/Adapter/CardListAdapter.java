package com.AITaro.taro.Adapter;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.AITaro.taro.Interface.OnClickListener;
import com.AITaro.taro.Items.RecyclerViewItem;
import com.AITaro.taro.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static kotlin.concurrent.ThreadsKt.thread;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {

    private ArrayList<RecyclerViewItem> items = new ArrayList<>();
    private ArrayList<RecyclerViewItem> selectedItemList = new ArrayList<>();
    private OnClickListener mLisener = null;

    @NotNull
    @Override
    public CardListAdapter.ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void removeCard(int position){
        items.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onBindViewHolder(@NotNull CardListAdapter.ViewHolder holder, int position) {
        RecyclerViewItem goneItem = items.get(position);
        holder.onBind(goneItem);

        holder.taroCard.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                removeCard(holder.getAdapterPosition());

            }
        });

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItem(RecyclerViewItem item) {
        items.add(item);
    }


    public void OnClickListener(OnClickListener listener) {
        this.mLisener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView taroCard;

        public ViewHolder(View itemView) {
            super(itemView);

            taroCard = itemView.findViewById(R.id.taroCard);
        }

        public void onBind(RecyclerViewItem item) {
            taroCard.setImageResource(item.getTaroImage());
        }

        public void CardSelect() {
            taroCard.setVisibility(View.INVISIBLE);
        }
    }
}

