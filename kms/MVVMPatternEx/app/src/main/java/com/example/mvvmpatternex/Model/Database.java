package com.example.mvvmpatternex.Model;

import android.util.Log;

import java.util.ArrayList;

public class Database {
    private static Database instance;
    private ArrayList<Person> personList = new ArrayList<>();
    private String winner;
    private DatabaseListener databaseListener;

    private Database(){
        Log.d("Model인 Database 생성","Model인 Database 생성");
        personList.add(new Person(0, "정은지"));
        personList.add(new Person(1, "김민성"));
        personList.add(new Person(2, "이무현"));
    }
    public static Database getInstance(){
        Log.d("Model에 접근 할 수 있도록 DB 인스턴스 값 요청","Model에 접근 할 수 있도록 DB 인스턴스 값 요청");
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void getUser(){
        Log.d("닻첨자 획득", "당첨자 획득");
        winner = personList.get((int)(Math.random()*5)).getName();
        notifyChanged();
    }
    private void notifyChanged(){
        if (databaseListener != null){
            Log.d("Model | Data 변경 되어 notify 하라고 알림","Model | Data 변경 되어 notify 하라고 알림");
            databaseListener.onChanged();
        }
    }

    public void setOnDatabaseListener(DatabaseListener databaseListener){
        Log.d("DatabaseListener 구현 객체 참조 변수 세팅 (arg1 : %s)",databaseListener.getClass().getSimpleName());
        this.databaseListener = databaseListener;
    }

    public interface DatabaseListener{
        void onChanged();
    }
}

