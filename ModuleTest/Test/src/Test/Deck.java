package Test;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards = new ArrayList();
    private int idx = 0;

    public Deck() {
    }

    public Card get(int index) {
        return index >= 0 && index < this.cards.size() ? (Card)this.cards.get(index) : null;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void addFront(Card card) {
        this.cards.add(0, card);
    }

    public Card find(int n) {
        return (Card)this.cards.get(n);
    }

    public Card pop() {
        if (this.cards.size() == 0) {
            System.out.println("데이터가 존재하지 않습니다");
            return null;
        } else {
            return (Card)this.cards.remove(this.cards.size() - 1);
        }
    }

    public Card peek() {
        if (this.cards.size() == 0) {
            System.out.println("데이터가 존재하지 않습니다");
            return null;
        } else {
            return (Card)this.cards.get(this.cards.size() - 1);
        }
    }

    public void push(Card card) {
        this.cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
        Collections.shuffle(this.cards);
        Collections.shuffle(this.cards);
    }

    public Card random() {
        if (this.cards.size() == 0) {
            System.out.println("데이터가 존재하지 않습니다");
            return null;
        } else {
            int randomIndex = (int)(Math.random() * (double)this.cards.size());
            return (Card)this.cards.get(randomIndex);
        }
    }

    public Card next() {
        if (++this.idx >= this.cards.size()) {
            this.idx %= this.cards.size();
        }

        return (Card)this.cards.get(this.idx);
    }
}
