import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import card.Deck;
import card.Card;


public class Test extends JFrame implements ActionListener {
    String[] constrait = {"North", "Center", "South"};
    String[] btnText = {"pop", "peek", "push", "shuffle", "random"};
    JTextField[] tf = new JTextField[3];
    JButton[] btn = new JButton[btnText.length];
    ArrayList<Integer> card = new ArrayList<>(); // card ����Ʈ�� �ν��Ͻ� ������ ����

    public Test() {
        JPanel[] pan = new JPanel[constrait.length];

        for (int i = 0; i < pan.length; i++) {
            tf[i] = new JTextField(15);
            pan[i] = new JPanel();
            add(pan[i], constrait[i]);
        }

        for (int i = 0; i < btn.length; i++) {
            btn[i] = new JButton(btnText[i]);
            btn[i].addActionListener(this);
            pan[1].add(btn[i]);
        }

        pan[0].add(tf[0]);
        pan[2].add(tf[2]);

        setTitle("card �׽�Ʈ");
        setBounds(700, 400, 500, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton eBut = (JButton)e.getSource();
        String inputText = tf[0].getText(); // �ؽ�Ʈ �ʵ��� ���� ������

        // �Է� ���� ��� �ִ� ��� �⺻���� 0.0���� �ʱ�ȭ
        double num1 = inputText.isEmpty() ? 0.0 : Double.parseDouble(inputText);

        double result = 0;
        String exp = "";

        if (eBut == btn[0]) { // pop
            if (card.size() == 0) {
                exp = "�����Ͱ� �������� �ʽ��ϴ�.";
            } else {
                card.remove(card.size() - 1);
                exp = "pop: " + card.toString();
            }
        } else if (eBut == btn[1]) { // peek
            if (card.size() == 0) {
                exp = "�����Ͱ� �������� �ʽ��ϴ�.";
            } else {
                int lastValue = card.get(card.size() - 1);
                exp = "peek: " + lastValue;
            }
        } else if (eBut == btn[2]) { // push
            card.addAll(card);
            exp = "push: " + card.toString();
        } else if (eBut == btn[3]) { // shuffle
            Collections.shuffle(card);
            exp = "shuffle: " + card.toString();
        } else { // random
            if (card.size() == 0) {
                exp = "�����Ͱ� �������� �ʽ��ϴ�.";
            } else {
                int randomIndex = (int)(Math.random() * card.size());
                int randomValue = card.get(randomIndex);
                exp = "random: " + randomValue;
            }
        }
        tf[2].setText(exp);
    }

    public static void main(String[] args) {
        Card card1 = new Card("�ٺ�, ����",0);
        Card card2 = new Card("������",1);
        Card card3 = new Card("������",2);
        Card card4 = new Card("��Ȳ��",3);
        Card card5 = new Card("Ȳ��",4);
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
       
        
    }
}
