package com.Integration.aitaroapp.Page.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Item.CardItem;
import com.Integration.aitaroapp.Page.Item.MainBtnSelected;
import com.Integration.aitaroapp.Page.MainActivity;
import com.Integration.aitaroapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GameSelectedRecyclerViewAdapter extends RecyclerView.Adapter<GameSelectedRecyclerViewAdapter.MainCardSelectedViewHolder> {
    private ArrayList<MainBtnSelected> btn_item = new ArrayList<>();
    private ArrayList<CardItem> cardItems = new ArrayList<>();


    public GameSelectedRecyclerViewAdapter(ArrayList<MainBtnSelected> btn_item) {
        this.btn_item = btn_item;
    }
    
    @NonNull
    @NotNull
    @Override
    public MainCardSelectedViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_selected_recycler_view, parent, false);
        return new MainCardSelectedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull MainCardSelectedViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MainBtnSelected btnSelected = btn_item.get(position);
        holder.main_btn_text.setText(btnSelected.getBtnText());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mPosition = holder.getAdapterPosition();

                Context context = v.getContext();

                Intent cardActivity = new Intent(context, MainActivity.class);

                if (position == 0)
                {
                    cardActivity.putExtra("three_card","three_card");
                    context.startActivity(cardActivity);
                }
                if (position == 1)
                {
                    cardActivity.putExtra("five_card","five_card");
                    context.startActivity(cardActivity);
                }
                if (position == 2)
                {
                    cardActivity.putExtra("eight_card","eight_card");
                    context.startActivity(cardActivity);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return btn_item.size();
    }

    public class MainCardSelectedViewHolder extends RecyclerView.ViewHolder {
        private TextView main_btn_text;
        private CardView cardView;
        public MainCardSelectedViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.selected_card_view);
            main_btn_text = itemView.findViewById(R.id.selected_text);
        }
    }
}
