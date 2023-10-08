package com.example.tictactoe.game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.tictactoe.R.drawable.o;
import static com.example.tictactoe.R.drawable.x;

import com.example.tictactoe.R;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    String p1,p2;
    ImageView img;
    static ImageView et1, et2, et3, et4, et5, et6, et7, et8, et9;
    public Button restart;
    public TextView status;
    int xplayer=0;
    int oplayer=1;
    int count=8;
    int currentPlayer=xplayer;
    Integer[] positions={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    boolean activeGame=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        getSupportActionBar().hide();
        status = findViewById(R.id.status);
        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        et6 = findViewById(R.id.et6);
        et7 = findViewById(R.id.et7);
        et8 = findViewById(R.id.et8);
        et9 = findViewById(R.id.et9);
        restart = findViewById(R.id.button3);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        et1.setOnClickListener(this);
        et2.setOnClickListener(this);
        et3.setOnClickListener(this);
        et4.setOnClickListener(this);
        et5.setOnClickListener(this);
        et6.setOnClickListener(this);
        et7.setOnClickListener(this);
        et8.setOnClickListener(this);
        et9.setOnClickListener(this);
        p1 = getIntent().getStringExtra("player1");
        p2 = getIntent().getStringExtra("player2");
        String versus=p1+"    V/S    "+p2;
        status.setText(versus);
    }

    @Override
    public void onClick(View v)
    {
        if (!activeGame)
        {
            return;
        }
        img=findViewById(v.getId());
        int tag= Integer.parseInt(v.getTag().toString());

        if (currentPlayer==xplayer)
        {
            img.setImageResource(x);
            img.setEnabled(false);
            positions[tag]=xplayer;
            currentPlayer=oplayer;
            check();
        }else{
            img.setImageResource(o);
            img.setEnabled(false);
            positions[tag]=oplayer;
            currentPlayer=xplayer;
            check();
        }
    }

    public void check()
    {

        int[][] winPos ={{0,1,2},{3,4,5},{6,7,8},{2,4,6},{0,4,8},{0,3,6},{1,4,7},{2,5,8}};

            for (int i=0;i<8;i++)
            {
                int pos1=winPos[i][0];
                int pos2=winPos[i][1];
                int pos3=winPos[i][2];

                if(positions[pos1]==positions[pos2] && positions[pos1]==positions[pos3])
                {
                    if (positions[pos1]!=-1)
                    {
                        activeGame=false;
                        if (positions[pos1]==xplayer)
                        {
                            displayToast(p1+" WON");
                            return;
                        }else{
                            displayToast(p2+" WON");
                            return;
                        }
                    }
                }
            }
            List<Integer> posiList=new ArrayList<>(Arrays.asList(positions));
            if(!posiList.contains(-1))
            {
                displayToast("Match Tie");
                activeGame=false;
            }
    }

    public void displayToast(String txt)
    {
        LayoutInflater inflater=getLayoutInflater();
        View v1=inflater.inflate(R.layout.customtoast,(ViewGroup)findViewById(R.id.customt));
        TextView textView=v1.findViewById(R.id.textView);
        textView.setText(txt);
        ImageView imageView=v1.findViewById(R.id.imageView);
        if (txt == "Match Tie")
            imageView.setImageResource(R.drawable.go);
        Toast toast=new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(v1);
        toast.show();
    }
}

