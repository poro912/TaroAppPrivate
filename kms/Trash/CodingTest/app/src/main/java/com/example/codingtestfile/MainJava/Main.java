package com.example.codingtestfile.MainJava;


import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    private static ArrayList<Integer> stArray = new ArrayList<>();                 //기본 ArrayList
    private static ArrayList<Integer> ndArray = new ArrayList<>(stArray);        //다른 Collection으로 초기화
    private static ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("red", "blue", "pink", "black", "white"));  //Array.asList() 가변인자를 전달 받아 기본값으로 사용가능

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println("q누르면 종료\n" + "입력:");
        System.out.println();

        while (true) {

            if(!"q".trim().equals(sc.next())) {
                if ("add".trim().equals(sc.next())) {
                    System.out.println("입력add값:");
                    main.addArray(sc.next());
                } else if ("2".trim().equals(sc.next())) {
                    System.out.println("index값:");
                    main.indexArray(sc.nextInt(), sc.next());
                } else if ("3".trim().equals(sc.next())) {
                    System.out.println("indexOf값, 값 입력 시 리스트에 값이 있으면 배열을 불러오고 없으면 -1반환");
                    main.indexOfArray(sc.next());
                } else if ("4".trim().equals(sc.next())) {
                    System.out.println("숫자 입력시 숫자에 맞는 배열값 출력");
                    main.getArray(sc.nextInt());
                } else if ("5".equals(sc.next())) {
                    System.out.println("index값으로 배열 번호 지정 후 값 내용 변경");
                    main.setArray(sc.nextInt(), sc.next());
                } else if ("6".equals(sc.next())) {
                    System.out.println("배열 크기:");
                    main.sizeArray();
                } else if ("7".equals(sc.next())) {
                    System.out.println("배열 번호 지정 시 지정번호 배열 값 삭제");
                    main.removeArray(sc.nextInt());
                } else if ("8".equals(sc.next())) {
                    System.out.println("배열 전체 삭제");
                    main.clearArray();
                }
            }else if ("q".trim().equals(sc.next())){
                break;
            }


        }
    }

    void addArray(String item) {

        arrayList.add(item);
        System.out.println(arrayList);

    }

    void indexArray(int i, String item) {
        arrayList.add(i, item);
        System.out.println(arrayList);
    }

    int indexOfArray(String item) {

        if (!arrayList.contains(item)) {
            System.out.println(-1);

        } else  System.out.println(arrayList);

        return -1;
    }

    void getArray(int i) {
        System.out.println(arrayList.get(i));
    }

    void setArray(int i, String item){
        System.out.println(arrayList.set(i, item));
    }

    void sizeArray(){
        System.out.println(arrayList.size());
    }

    void removeArray(int i){
        arrayList.remove(i);
        System.out.println(arrayList);
    }
    void clearArray(){
        arrayList.clear();
        System.out.println(arrayList);
    }
}