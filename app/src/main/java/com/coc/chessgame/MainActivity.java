package com.coc.chessgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {



   /* private TextView textViewPlayer1;
    private TextView textViewPlayer2;*/

    private ImageButton[][] buttons = new ImageButton[8][8];
    boolean ispressed = false;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*textViewPlayer1 = findViewById(R.id.text_view_p1);
        textViewPlayer2 = findViewById(R.id.text_view_p2);*/

        for (int i = 0; i < 8; ++i){
            for (int j = 0; j < 8; ++j ){
                String buttonId = "button_" + i + j;
                int resId = getResources().getIdentifier(buttonId,"id",getPackageName());
                buttons[i][j] = (ImageButton)findViewById(resId);
                buttons[i][j].setOnClickListener(this);
            }
        }



        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        }


    @Override
    public void onClick(View v) {
        int tagg;
        int tag;
        if (!ispressed){
            for (int i = 0; i < 8; ++i){
                for (int j = 0; j < 8; ++j){
                    tagg = v.getId();
                    tag = (int) buttons[i][j].getId();
                    Log.d("tag1","Hello");
                }
            }
            ispressed = true;
        }


           /* for (int i = 0; i < 8; ++i){
                for (int j = 0; j < 8; ++j){
                    if (!ispressed){

                    if ((i + j)%2 == 0){
                        buttons[i][j].setBackgroundResource(R.drawable.black);
                        //buttons[i][j].setImageDrawable(null);
                    }else {
                        buttons[i][j].setBackgroundResource(R.drawable.white);
                        //buttons[i][j].setImageDrawable(null);
                    }
                    ispressed = true;

                }
            }


        }*/


    }
}

