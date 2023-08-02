package com.example.mvvmpatternex.ViewModel;

import android.util.Log;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import com.example.mvvmpatternex.Model.Database;
import com.example.mvvmpatternex.Model.Person;

import java.util.ArrayList;
import java.util.List;

public class ViewModel extends BaseObservable {
    // 카메라 버튼이 눌렸는지 확인하기 위한 MutableLiveData
    Boolean isPressed = MutableLiveData <Boolean>(false);

    // 카메라 눌림 감지를 메서드
    fun onClickCameraBtn(v: View) {
        // 버튼 눌림 상태 Toggle
        isPressed. = isPressed.value?.not()
    }
}