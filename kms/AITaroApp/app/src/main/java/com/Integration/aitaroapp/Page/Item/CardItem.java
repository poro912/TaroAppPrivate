package com.Integration.aitaroapp.Page.Item;

import androidx.annotation.NonNull;
import org.jetbrains.annotations.NotNull;

public class CardItem {
    private int card_item;
    private int selected_num;
    private int card_value;

    public int getCard_value() {
        return card_value;
    }

    public void setCard_value(int card_value) {
        this.card_value = card_value;
    }

    public int getSelected_num() {
        return selected_num;
    }

    public void setSelected_num(int selected_num) {
        this.selected_num = selected_num;
    }

    public int getCard_item() {
        return card_item;
    }

    public void setCard_item(int card_item) {
        this.card_item = card_item;
    }


    @NonNull
    @NotNull
    @Override
    public String toString() {
        return " CardItem{ " +
                " card_item= " + card_item +
                " , selected_num= " + selected_num +
                " card_value " + card_value +
                 '}';
    }
}
