package com.Integration.aitaroapp.Page.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.Integration.aitaroapp.Page.Interface.ExitDialogListener;
import com.Integration.aitaroapp.Page.StartActivity;
import com.Integration.aitaroapp.databinding.DialogBinding;

public class MyDialog extends Dialog {

    private DialogBinding binding_dialog;
    private Context mContext;
    private String title_name;
    private String content_name;
    private Intent intentMainActivity;
    public MyDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding_dialog = DialogBinding.inflate(getLayoutInflater());
        setContentView(binding_dialog.getRoot());

        init();
        setCanceledOnTouchOutside(false);

    }
    private void init(){
        BtnClick();
    }

    private void BtnClick(){
        binding_dialog.dialogExitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismissBtn();
                dialogBtn("exit");

            }
        });

        binding_dialog.dialogCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               dismissBtn();
            }
        });
    }

    private void dismissBtn(){
        dismiss(); // 다이얼로그 닫기
    }

    public void dialogBtn(String action){
        //앱 종료
        if (mContext instanceof ExitDialogListener && action.equals("exit"))
        {
            binding_dialog.dialogExitBtn.setVisibility(View.VISIBLE);

            //앱 종료 캐스팅, 인터페이스
            ((ExitDialogListener) mContext).onExitConfirmed();
        }
        //메인 액티비티로 돌아가기
        else if (action.equals("back_pressed"))
        {
            dialogInit("back_pressed");
            binding_dialog.dialogBackBtn.setVisibility(View.VISIBLE);
            binding_dialog.dialogBackBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //앱 액티비티 종료 캐스팅, 인터페이스
                    if (mContext instanceof ExitDialogListener.Finished){
                        ((ExitDialogListener.Finished) mContext).onFinishActivity();
                    }
                }
            });
        }
    }

    private void dialogInit(String use){
        if ("back_pressed".equals(use))
        {
            title_name = "메인화면으로 돌아갈까요?";
            content_name = "선택하신 정보들이 저장되지 않을 수 있어요!";
            binding_dialog.dialogTitle.setTextSize(23);
            binding_dialog.dialogTitle.setText(title_name);
            binding_dialog.dialogContent.setText(content_name);
        }
    }
}