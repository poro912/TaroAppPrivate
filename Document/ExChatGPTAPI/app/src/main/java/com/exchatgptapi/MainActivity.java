package com.exchatgptapi;

import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.exchatgptapi.Builder.RetrofitClient;
import com.exchatgptapi.DataClass.ChatGPTRequest;
import com.exchatgptapi.DataClass.ChatGPTResponse;
import com.exchatgptapi.Interface.ChatGPTApi;
import com.exchatgptapi.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding bindingMain;
    private Retrofit retrofit;
    private ChatGPTApi chatGPTApi;
    private ChatGPTRequest request;
    private int maxTokens;     //최대 글자수 할당량 토큰값
    private String APIKey;      //chatGPT key값
    private String TAG = "loglog";
    private  Call<ChatGPTResponse> call;
    private String prompt;      //전송할 문자

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindingMain = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(bindingMain.getRoot());

        prompt = bindingMain.chatGPTEdit.toString();
        APIKey = "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".trim();
        retrofit = RetrofitClient.getRetrofit();
        maxTokens = 150;    //최대 토큰 수
        chatGPTApi = retrofit.create(ChatGPTApi.class);

        init();
    }

    private void init() {

        if (prompt != null){
            request = new ChatGPTRequest(prompt, maxTokens);
            call = chatGPTApi.completeText(APIKey, request);
        }


        bindingMain.chatGPTBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatGPTAPI();
            }
        });
    }

    private void ChatGPTAPI() {
        call.enqueue(new Callback<ChatGPTResponse>() {
            @Override
            public void onResponse(Call<ChatGPTResponse> call, Response<ChatGPTResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Success?");
                    ChatGPTResponse chatGPTResponse = response.body();
                    if (chatGPTResponse != null && chatGPTResponse.getChoices() != null && chatGPTResponse.getChoices().size() > 0) {
                        String answer = chatGPTResponse.getChoices().get(0).getMessage().getContent();
                        // answer = chatGPT 답변
                        Log.d(TAG, answer);
                        bindingMain.chatGPTText.setText(answer);
                    } else {
                        Log.d(TAG, "응답이 비어있음");
                    }
                } else {
                    Log.d(TAG, "요청실패");
                    Log.d(TAG, response.toString());
                }
            }

            @Override
            public void onFailure(Call<ChatGPTResponse> call, Throwable t) {
                Log.e(TAG, "네트워크 연결 실패: " + t.getMessage());
            }
        });
    }
}
