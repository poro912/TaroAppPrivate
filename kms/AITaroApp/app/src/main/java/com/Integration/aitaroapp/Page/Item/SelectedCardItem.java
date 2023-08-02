package com.Integration.aitaroapp.Page.Item;

public class SelectedCardItem {
    private int selectedNumber;
    private int cardImageResource;

    public SelectedCardItem(int selectedNumber, int cardImageResource) {
        this.selectedNumber = selectedNumber;
        this.cardImageResource = cardImageResource;
    }

    public int getSelectedNumber() {
        return selectedNumber;
    }

    public int getCardImageResource() {
        return cardImageResource;
    }
}