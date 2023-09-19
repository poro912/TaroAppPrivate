package TaroInterface;

public class CardHolder {
    // 각도
    int rotation;
    // 가중치
    String weight;
    // 좌표
    private int x, y;
    private Card card;
    private String mean;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public Card getCard() {
        return card;
    }

    public boolean registCard(Card card) {
        this.card = card;
        return true;
    }

    public boolean removeCard() {
        if (this.card == null) {
            return false;
        }

        this.card = null;
        return true;
    }
}
