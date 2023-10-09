package TaroSystem;

// GPT 모듈
// quary는 비동기로 동작되어야하며, 동작완료 시 구독자에게 알려줘야한다(옵저버 패턴)

import java.util.ArrayList;

public class GPT {
    public static GPT instance;

    private ArrayList<String> resultQueue;

    private GPT() {
        resultQueue = new ArrayList<>();
    }

    // 인스턴스를 얻는 정적 메서드
    public static GPT getInstance() {
        if (instance == null) {
            instance = new GPT();
        }
        return instance;
    }

    public void getHandle(){

    }
    public void setHandle(){

    }

    public void quary(){

    }
    public void recv(){

    }



}