package com.example.tictactoe.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tictactoe.R;
import com.example.tictactoe.auth.LoginActivity;
import com.example.tictactoe.auth.SignUpActivity;

public class NavigationActivity extends AppCompatActivity {
Button lgn,sgn,guest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        getSupportActionBar().hide();
        lgn=findViewById(R.id.button2);
        sgn=findViewById(R.id.button);
        guest=findViewById(R.id.button4);

        lgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this, LoginActivity.class));
            }
        });

        sgn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this, SignUpActivity.class));
            }
        });

        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NavigationActivity.this, PlayersActivity.class));
            }
        });
    }
}