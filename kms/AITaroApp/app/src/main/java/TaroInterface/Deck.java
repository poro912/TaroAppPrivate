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

    /*
    // 스택, 환영 큐, 등 여러 자료형을 한번에 사용할 수 있도록 설계함
    public List<Card> cards;
    private int idx = 0;

    public Card? this[int index]
    {
        get {
        if(0 <= index && index < cards.Count)
            return cards[index];
        return null;
    }
    }

    public Deck()
    {
        cards = new List<Card>();
    }

    public void addCard(Card card)
    {
        cards.Add(card);
    }

    public void addFront(Card card)
    {
        cards.Insert(0, card);
    }

    public Card? pop()
    {
        return null;
    }

    public Card? peek()
    {
        return null;
    }

    public Card? push()
    {
        return null;
    }

    public void shuffle()
    {

    }

    public Card? random()
    {
        return null;
    }

    public Card? Next()
    {
        if(++idx >= cards.Count) idx %= cards.Count;
        return cards[idx];
    }
    */
}
