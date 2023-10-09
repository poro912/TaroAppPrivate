package com.exchatgptapi.DataClass;
import java.util.ArrayList;

public class ChatGPTResponse {
    private ArrayList<Choice> choices;

    public ArrayList<Choice> getChoices() {
        return choices;
    }

    public static class Choice {
        private Message message;

        public Message getMessage() {
            return message;
        }
    }

    public static class Message {
        private String content;

        public String getContent() {
            return content;
        }
    }
}