package com.Integration.aitaroapp.Page.Interface;

import android.content.Intent;
import com.Integration.aitaroapp.Page.Item.CardItem;

import java.util.ArrayList;

public interface CardSelectionListener {
    void onCardSelected(CardItem cardItem, ArrayList<Integer> cardDrawn);

}

