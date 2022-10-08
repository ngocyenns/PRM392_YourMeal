package com.example.yourmeal.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.yourmeal.R;

import com.example.yourmeal.viewmodels.LoginViewModel;

public class LoginActivity extends AppCompatActivity {
    private EditText edtUsername;
    private EditText edtPass;
    private Button btnLogin;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUserName);
        edtPass = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        loginViewModel = new LoginViewModel();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtUsername.getText().toString();
                String pass = edtPass.getText().toString();
                Log.d("mess",username+" "+pass);

                Boolean statusLogin = loginViewModel.checkLogin(username, pass);
                Intent intent;
                if(statusLogin) {
                    intent = new Intent(LoginActivity.this, HomeLocalActivity.class);
                } else {
                    intent = new Intent(LoginActivity.this, LoginActivity.class);
                    intent.putExtra("error","Tài khoản hoặc mật khẩu không đúng!!!");
                }
                startActivity(intent);
            }
        });
    }
}