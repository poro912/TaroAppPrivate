package com.AITaro.taro.Adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.AITaro.taro.Interface.OnClickListener;
import com.AITaro.taro.Items.RecyclerViewItem;
import com.AITaro.taro.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

import static kotlin.concurrent.ThreadsKt.thread;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.ViewHolder> {

    private ArrayList<RecyclerViewItem> items = new ArrayList<>();
    private OnClickListener mLisener = null;

    @NotNull
    @Override
    public CardListAdapter.ViewHolder onCreateViewHolder( @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_list_view,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NotNull CardListAdapter.ViewHolder holder, int position) {
        holder.onBind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void addItem(RecyclerViewItem item){
        items.add(item);
    }


    public void OnClickListener(OnClickListener listener){
       this.mLisener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView taroCard;
        public ViewHolder(@NotNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        //리스너 객체 메서드 호출
                        Log.d("loglog", String.valueOf(pos));
                        CardSelect();

                        if (mLisener != null){
                            mLisener.onItemClick(v,pos);
                        }
                    }

                }
            });

            taroCard = itemView.findViewById(R.id.taroCard);
        }
        public void onBind(RecyclerViewItem item){
            taroCard.setImageResource(item.getTaroImage());
        }
        public void CardSelect(){
            taroCard.setVisibility(View.INVISIBLE);
        }
    }
}

