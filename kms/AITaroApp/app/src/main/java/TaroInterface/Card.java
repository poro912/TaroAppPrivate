package TaroInterface;

import java.util.ArrayList;

// 싱글톤 형식으로 데이터를 쌓아 공유함
public class Card {
    // 추가 데이터는 json에서 직접 읽어온다.
    // Json json;

    String type;

    private int number = -1;
    private String name = "";
    private String category = "";

    public ArrayList<String> forward;
    public ArrayList<String> reverse;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Card(String name, int number) {
        this.name = name;
        this.number = number;
        forward = new ArrayList<String>();
        reverse = new ArrayList<String>();
    }

    public Card(String name, int number, String category) {
        this.name = name;
        this.number = number;
        this.category = category;
        forward = new ArrayList<>();
        reverse = new ArrayList<>();
    }

    public void addForwardMean(String mean) {
        forward.add(mean);
    }

    public void addReverseMean(String mean) {
        reverse.add(mean);
    }
}
