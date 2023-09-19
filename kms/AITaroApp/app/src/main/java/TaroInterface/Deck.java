package TaroInterface;

import java.util.ArrayList;

public class Deck {
    // 조건에 따라 카드를 찾아 반환함
    /**/

    private ArrayList<Card> cards;
    private int idx = 0;

    public Deck() {
        cards = new ArrayList<Card>();
    }

    public Card get(int index) {
        if (0 <= index && index < cards.size()) {
            return cards.get(index);
        }
        return null;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void addFront(Card card) {
        cards.add(0, card);
    }

    public Card find(int n){
        return cards.get(n);
    }

    public Card pop() {
        // 구현 필요
        return null;
    }

    public Card peek() {
        // 구현 필요
        return null;
    }

    public void push() {
        // 구현 필요
    }

    public void shuffle() {
        // 구현 필요
    }

    public Card random() {
        // 구현 필요
        return null;
    }

    public Card next() {
        if (++idx >= cards.size()) {
            idx %= cards.size();
        }
        return cards.get(idx);
    }
}
