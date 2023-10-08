package com.example.tictactoe.home;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.tictactoe.R;
import com.example.tictactoe.game.GameActivity;

public class PlayersActivity extends AppCompatActivity {
public String PLAYER1="",PLAYER2;
    EditText name1,name2;
Button guest,lgn,sgn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        getSupportActionBar().hide();
        guest=findViewById(R.id.btnGuest);
        lgn=findViewById(R.id.button2);
        sgn=findViewById(R.id.button);
        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);
        PLAYER1=getIntent().getStringExtra("game_name");
        name1.setText(PLAYER1);
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name1.getText().toString().equals("") || name2.getText().toString().equals(""))
                {
                    name1.setError("Player's Name can't be empty");
                    name2.setError("Player's Name can't be empty");
                    return;
                }
                PLAYER1=name1.getText().toString();
                PLAYER2=name2.getText().toString();
                Intent intent=new Intent(PlayersActivity.this, GameActivity.class);
                intent.putExtra("player1",PLAYER1);
                intent.putExtra("player2",PLAYER2);
                startActivity(intent);
            }
        });
    }
}