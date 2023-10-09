package com.exchatgptapi.Interface;

import com.exchatgptapi.DataClass.ChatGPTRequest;
import com.exchatgptapi.DataClass.ChatGPTResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ChatGPTApi {
    @POST("engines/davinci-codex/completions")
    Call<ChatGPTResponse> completeText(@Header("Authorization") String apiKey, @Body ChatGPTRequest request);
}