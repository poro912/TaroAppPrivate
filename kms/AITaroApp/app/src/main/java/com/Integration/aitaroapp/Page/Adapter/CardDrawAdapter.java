package com.Integration.aitaroapp.Page.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.Integration.aitaroapp.Page.Interface.CardSelectionListener;
import com.Integration.aitaroapp.Page.Item.CardItem;
import com.Integration.aitaroapp.Page.Item.SelectedCardItem;
import com.Integration.aitaroapp.R;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CardDrawAdapter extends RecyclerView.Adapter<CardDrawAdapter.DrawCardHolder> {
    private ArrayList<CardItem> drawcardItems = new ArrayList<>();  //카드 정보 어레이리스트
    private ArrayList<SelectedCardItem> card_item = new ArrayList<>();
    private ArrayList<Integer> resultCard = new ArrayList<>();         //뽑은 카드 값 어레이리스트
    private CardSelectionListener cardSelectionListener;
    private ArrayList<CardItem> remove_card_items = new ArrayList<>();
    private Context mcontext;
    private ImageView imageView0, imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7;
    private ArrayList<ImageView> images = new ArrayList<>();

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
        int cardNumber = cardItem.getSelected_num();
        Log.d("CardDrawAdapter", "Card Number: " + cardNumber);

        holder.back_of_taro_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int mPosition = holder.getAdapterPosition();
                removeCard(mPosition);

            }
        });
    }

    public void setCardSelectionListener(CardSelectionListener listener) {
        this.cardSelectionListener = listener;
    }

    private void removeCard(int position) {
        //카드를 뽑은 후 빈공간 클릭시 앱종료되는 문제 해결
        if (position >= 0 && position < drawcardItems.size()) {
            CardItem removed_card = drawcardItems.get(position);

            remove_card_items.add(removed_card);
            drawcardItems.remove(position);
            notifyItemRemoved(position);

            int cardValue = removed_card.getSelected_num();
            resultCard.add(cardValue);

            // 카드를 뽑을 때마다 해당 카드 정보와 뽑힌 카드들의 값을 메인 액티비티로 전달
            if (cardSelectionListener != null) {
                cardSelectionListener.onCardSelected(removed_card, resultCard);
            }
        }
    }

    public void restoreRemovedCards() {
        for (CardItem removedCard : remove_card_items) {
            drawcardItems.add(removedCard);
            // 선택된 카드 목록에서도 삭제된 카드를 제거
            resultCard.remove((Integer) removedCard.getSelected_num());
        }
        remove_card_items.clear(); // 삭제된 카드 목록 초기화
        notifyDataSetChanged(); // 리사이클러뷰 업데이트
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
