package com.coc.chessgame;

import android.graphics.Color;
import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;

import android.widget.*;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {





    private ImageButton[][] buttons = new ImageButton[8][8];
    private ImageButton selected ;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                String buttonId = "button_" + i + j;
                int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
                buttons[i][j] = (ImageButton) findViewById(resId);
                buttons[i][j].setOnClickListener(this);

            }
        }


        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttons[0][0].setImageResource(R.drawable.rook3);
        buttons[0][0].setTag(Integer.valueOf(R.drawable.rook3));
        buttons[0][7].setImageResource(R.drawable.rook3);
        buttons[0][1].setImageResource(R.drawable.night2);
        buttons[0][1].setTag(Integer.valueOf(R.drawable.night2))
        buttons[0][6].setImageResource(R.drawable.night2);
        buttons[0][2].setImageResource(R.drawable.bishop2);
        buttons[0][2].setTag(Integer.valueOf(R.drawable.bishop2))
        buttons[0][5].setImageResource(R.drawable.bishop2);
        buttons[0][3].setImageResource(R.drawable.queen2);
        buttons[0][3].setTag(Integer.valueOf(R.drawable.queen2))
        buttons[0][4].setImageResource(R.drawable.king2);
        buttons[0][4].setTag(Integer.valueOf(R.drawable.king2))

        buttons[7][0].setImageResource(R.drawable.rook1);
        buttons[7][0].setTag(Integer.valueOf(R.drawable.rook1));
        buttons[7][7].setImageResource(R.drawable.rook1);
        buttons[7][1].setImageResource(R.drawable.night1);
        buttons[7][0].setTag(Integer.valueOf(R.drawable.rook1));
        buttons[7][6].setImageResource(R.drawable.night1);
        buttons[7][2].setImageResource(R.drawable.bishop1);
        buttons[7][0].setTag(Integer.valueOf(R.drawable.rook1));
        buttons[7][5].setImageResource(R.drawable.bishop1);
        buttons[7][3].setImageResource(R.drawable.queen1);
        buttons[7][0].setTag(Integer.valueOf(R.drawable.rook1));
        buttons[7][4].setImageResource(R.drawable.king1);
        buttons[7][0].setTag(Integer.valueOf(R.drawable.rook1));

        for (int i = 0; i < 8; ++i) {
            buttons[1][i].setImageResource(R.drawable.pawn2);
            buttons[1][i].setTag(Integer.valueOf(R.drawable.pawn2));
            buttons[6][i].setImageResource(R.drawable.pawn1);
            buttons[6][i].setTag(Integer.valueOf(R.drawable.pawn1));
        }
    }




    @Override
    public void onClick(View v) {
                    int draw = (Integer) v.getTag();
                    switch (draw){
                        case R.drawable.bishop1: if (draw == R.drawable.bishop1){
                                                    
                        }
                    }
                    if (selected != null)
                    for (int i = 0; i < 8; ++i){
                        for (int j = 0; j < 8; ++j){
                            if (((i + j) % 2 ) == 0){
                                buttons[i][j].setBackgroundResource(R.drawable.black);
                            }else{
                                buttons[i][j].setBackgroundResource(R.drawable.white);
                            }
                            selected = null;
                        }
                    }
                }




    }


