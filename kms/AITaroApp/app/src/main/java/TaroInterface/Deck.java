package TaroInterface;

import java.util.*;


//public class Main {
//    public static void main(String[] args) {
//        // Deck 클래스의 객체 생성
//        Deck deck = new Deck();
//
//        // 카드 추가
//        Card card1 = new Card(1)
//        Card card2 = new Card("다이아몬드")
//        deck.addCard(card1);
//        deck.addCard(card2);
//
//        // 카드 셔플
//        deck.shuffle();
//
//        // 카드 출력
//        System.out.println("덱의 카드 목록:");
//        for (int i = 0; i < deck.size(); i++) {
//            Card card = deck.get(i);
//            System.out.println(card);
//        }
//
//        // 다른 메서드 호출 및 테스트
//        // ...
//
//        // 더 많은 테스트 코드를 추가할 수 있습니다.
//    }
//}

public class Deck {
    // 조건에 따라 카드를 찾아 반환함
    /*그레들(안드로이드 번역기)이 아니라 컴파일로 돌리지 말고 자바*/

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
        if(cards.size()==0){
            System.out.println("데이터가 존재하지 않습니다.");
            return null;
        }
        cards = (int)(Math.random() * cards.size();
        /*
        Random random = new Random();
        while (0<list.size())
        {
            int index = random.nextInt(cards.size());//꺼낼 번호를 랜덤하게 선택합니다.
            Integer in = (int)cards.remove(index);//중복되지 않도록 제거합니다.
        }
        //GPT
        if (cards.size() == 0) {
            System.out.println("데이터가 존재하지 않습니다");
            return null;
        }
        int randomIndex = (int) (Math.random() * cards.size());
        return cards.get(randomIndex);
    }
*/
    }

    public Card next() {
        if (++idx >= cards.size()) {
            idx %= cards.size();
        }
        return cards.get(idx);
    }
}
