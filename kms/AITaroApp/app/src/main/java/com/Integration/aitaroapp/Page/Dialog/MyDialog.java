package com.Integration.aitaroapp.Page.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.Integration.aitaroapp.Page.Interface.ExitDialogListener;
import com.Integration.aitaroapp.databinding.DialogBinding;

public class MyDialog extends Dialog {

    private DialogBinding binding_dialog;
    private Context mContext;

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
        binding_dialog.dialogOKBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // 다이얼로그 닫기

                if (mContext instanceof ExitDialogListener) {
                    ((ExitDialogListener) mContext).onExitConfirmed();
                }
            }
        });

        binding_dialog.dialogCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss(); // 다이얼로그 닫기
            }
        });
    }
}