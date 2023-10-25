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
            System.out.println("�����Ͱ� �������� �ʽ��ϴ�");
            return null;
        }
        return cards.remove(cards.size()-1);
        //���ī�带 ��ȯ �ؾ���, remove -> ����. ture or false �� ���� ���ɼ��� ����.
        //main���� print ���� ����. ���̶�� Ŭ������ �����غ���.
        //�ַܼ� �����ϴ� ��� ã�ƺ��� �����ϴ� ��! ��Ŭ������ �ν��Ͻ��� �ٲ㼭 �ϱ�. ��ȯ���� �����ʿ��� ����. ������ Ǫ�� �ϰ� �� �������� Ȯ��!
    }

    public Card peek() {
        /*if(cards.size()==0){
            System.out.println("�����Ͱ� �������� �ʽ��ϴ�.");
            return null;
        }

        cards.stream().filter(user -> user.getName().equals("������ ������ ī��"))
                .peek(e -> System.out.println("������ ������ ī��"+ e));
        return null;
*/

        if (cards.size() == 0) {
            System.out.println("�����Ͱ� �������� �ʽ��ϴ�");
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
            System.out.println("�����Ͱ� �������� �ʽ��ϴ�");
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
