package com.example.yourmeal.viewmodels;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yourmeal.model.User;

public class LoginViewModel {
    public Boolean checkLogin(String username, String pass) {
        // gọi hàm get data từ repository
//        Log.d("mess",username+" "+pass);
        if(username.equals("trongld") && pass.equals("123")) { // pass phải dùng md5
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
