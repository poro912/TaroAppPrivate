package TaroInterface;

import java.util.ArrayList;

public class Spread {
    // 카드를 배치할 공간을 둠
    ArrayList<CardHolder> placement;

    // 카드 개수
    int cardCount;

    Spread(int cardCount){
        this.cardCount = cardCount;
        placement = new ArrayList<CardHolder>(this.cardCount);
    }


}
