package card;
import java.util.*;


public class Deck {
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
        if(cards.size()==0){
            System.out.println("데이터가 존재하지 않습니다");
            return null;
        }
        return cards.remove(cards.size()-1);
        //대상카드를 반환 해야함, remove -> 리턴. ture or false 가 나올 가능성이 높음.
        //main에서 print 문장 찍어보기. 덱이라는 클래스를 실행해본다.
        //콘솔로 실행하는 방법 찾아보고 실행하는 것! 덱클래스를 인스턴스로 바꿔서 하기. 반환값을 메인쪽에서 실행. 데이터 푸시 하고 값 나오는지 확인!
    }

    public Card peek() {
        /*if(cards.size()==0){
            System.out.println("데이터가 존재하지 않습니다.");
            return null;
        }

        cards.stream().filter(user -> user.getName().equals("유저가 선택한 카드"))
                .peek(e -> System.out.println("유저가 선택한 카드"+ e));
        return null;
*/

        if (cards.size() == 0) {
            System.out.println("데이터가 존재하지 않습니다");
            return null;
        }
        return cards.get(cards.size() - 1);

    }

    public void push(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
        Collections.shuffle(cards);
        Collections.shuffle(cards);
    }

    public Card random() {
        if (cards.size() == 0) {
            System.out.println("데이터가 존재하지 않습니다");
            return null;
        }
        int randomIndex = (int) (Math.random() * cards.size());
        return cards.get(randomIndex);
    }

    public Card next() {
        if (++idx >= cards.size()) {
            idx %= cards.size();
        }
        return cards.get(idx);
    }
}
