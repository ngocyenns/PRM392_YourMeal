package com.example.yourmeal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private TextView txtEmail;
    private Button btnLogout;

    public ProfileActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        // init fireauth
        firebaseAuth = FirebaseAuth.getInstance();
        checkUser();

        // handle click
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                checkUser();
            }
        });
    }

    private void checkUser() {
        //get current user
        FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        if(firebaseUser == null) {
            // user not logged in
            startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            finish();
        } else {
            // user logged in
            // get user info
            String email = firebaseUser.getEmail();
            // set email
            txtEmail.setText(email);
        }
    }
}