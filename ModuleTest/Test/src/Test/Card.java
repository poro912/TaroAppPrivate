package Test;

import java.util.ArrayList;

public class Card {
    String type;
    private int number = -1;
    private String name = "";
    private String category = "";
    public ArrayList<String> forward;
    public ArrayList<String> reverse;

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Card(String name, int number) {
        this.name = name;
        this.number = number;
        this.forward = new ArrayList();
        this.reverse = new ArrayList();
    }

    public Card(String name, int number, String category) {
        this.name = name;
        this.number = number;
        this.category = category;
        this.forward = new ArrayList();
        this.reverse = new ArrayList();
    }

    public void addForwardMean(String mean) {
        this.forward.add(mean);
    }

    public void addReverseMean(String mean) {
        this.reverse.add(mean);
    }

    public String toString() {
        return this.name + " " + this.number;
    }
}
