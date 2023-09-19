import java.util.ArrayList;
import java.util.List;

public class Dack {
    public ArrayList<Card> card_list;

    public Dack()
    {
        card_list = new ArrayList<Card>();
    }

    public void addCard(Card card)
    {
        card_list.add(card);
    }

}
