package TaroInterface;

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> cards;

    Deck(){
        cards = new ArrayList<Card>();
    }
    // 조건에 따라 카드를 찾아 반환함
    Card find(int n){
        return cards.get(n);
    }
}
