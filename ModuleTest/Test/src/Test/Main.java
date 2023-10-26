package Test;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Card card1 = new Card("바보, 광대",0);
        Card card2 = new Card("마법사",1);
        Card card3 = new Card("여사제",2);
        Card card4 = new Card("여황제",3);
        Card card5 = new Card("황제",4);
        Deck d1 = new Deck();
        d1.push(card1);
        d1.push(card2);
        d1.push(card3);
        d1.push(card4);
        d1.push(card5);
        d1.shuffle();
        System.out.println(d1.peek());
        System.out.println(d1.random());
        System.out.println(d1.pop());
        System.out.println(d1.pop());
        System.out.println(d1.pop());
        System.out.println(d1.pop());
        System.out.println(d1.pop());
        System.out.println(d1.pop());
        //Card temp = d1.pop();
        //System.out.println(temp.getName());
	}

}
