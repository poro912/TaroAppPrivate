package com.exchatgptapi.DataClass;

import android.util.Log;

public class ChatGPTRequest {
    private int maxTokens;
    private String prompt;

    public ChatGPTRequest(String prompt, int maxTokens) {
        this.prompt = prompt;
        this.maxTokens = maxTokens;
    }

    public ChatGPTRequest() {

    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        if (prompt != null) {
            this.prompt = prompt;
        } else {
            Log.d("loglog", "null타입");
        }
    }

    public int getMaxTokens() {
        return maxTokens;
    }

    public void setMaxTokens(int maxTokens) {
        this.maxTokens = maxTokens;
    }
}