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
    private ImageButton selected = null;
    Location selectedLocation;


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


        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (((i + j) % 2) == 0) {
                    buttons[i][j].setBackgroundResource(R.drawable.black);
                } else {
                    buttons[i][j].setBackgroundResource(R.drawable.white);
                }
                //selected = null;
            }
        }


        buttons[0][0].setImageResource(R.drawable.rook3);
        buttons[0][0].setTag(Integer.valueOf(R.drawable.rook3));
        buttons[0][7].setImageResource(R.drawable.rook3);
        buttons[0][7].setTag(Integer.valueOf(R.drawable.rook3));
        buttons[0][1].setImageResource(R.drawable.night2);
        buttons[0][1].setTag(Integer.valueOf(R.drawable.night2));
        buttons[0][6].setImageResource(R.drawable.night2);
        buttons[0][6].setTag(Integer.valueOf(R.drawable.night2));

        buttons[0][2].setImageResource(R.drawable.bishop2);
        buttons[0][2].setTag(Integer.valueOf(R.drawable.bishop2));
        buttons[0][5].setImageResource(R.drawable.bishop2);
        buttons[0][5].setTag(Integer.valueOf(R.drawable.bishop2));

        buttons[0][3].setImageResource(R.drawable.queen2);
        buttons[0][3].setTag(Integer.valueOf(R.drawable.queen2));
        buttons[0][4].setImageResource(R.drawable.king2);
        buttons[0][4].setTag(Integer.valueOf(R.drawable.king2));

        buttons[7][0].setImageResource(R.drawable.rook1);
        buttons[7][0].setTag(Integer.valueOf(R.drawable.rook1));
        buttons[7][7].setImageResource(R.drawable.rook1);
        buttons[7][7].setTag(Integer.valueOf(R.drawable.rook1));
        buttons[7][1].setImageResource(R.drawable.night1);
        buttons[7][1].setTag(Integer.valueOf(R.drawable.night1));
        buttons[7][6].setImageResource(R.drawable.night1);
        buttons[7][6].setTag(Integer.valueOf(R.drawable.night1));

        buttons[7][2].setImageResource(R.drawable.bishop1);
        buttons[7][2].setTag(Integer.valueOf(R.drawable.bishop1));
        buttons[7][5].setImageResource(R.drawable.bishop1);
        buttons[7][5].setTag(Integer.valueOf(R.drawable.bishop1));

        buttons[7][3].setImageResource(R.drawable.queen1);
        buttons[7][3].setTag(Integer.valueOf(R.drawable.queen1));

        buttons[7][4].setImageResource(R.drawable.king1);
        buttons[7][4].setTag(Integer.valueOf(R.drawable.king1));

        for (int i = 0; i < 8; ++i) {
            buttons[1][i].setImageResource(R.drawable.pawn2);
            buttons[1][i].setTag(Integer.valueOf(R.drawable.pawn2));
            buttons[6][i].setImageResource(R.drawable.pawn1);
            buttons[6][i].setTag(Integer.valueOf(R.drawable.pawn1));
        }
    }


    @Override
    public void onClick(View v) {

        Log.v("1st", "1");

        if (selected == null) {
            int draw = (Integer) v.getId();
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttons[i][j].getId() == draw) {
                        selected = buttons[i][j];
                        break;
                    }
                }
                if (selected != null) {
                    break;
                }
            }
        } else {
            ImageButton next = null;
            int viewid = v.getId();

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (buttons[i][j].getId() == viewid) {
                        next = buttons[i][j];
                        break;
                    }
                }
                if (next != null) {
                    break;
                }
            }

            int tag = (Integer) selected.getTag();
            Log.v("tag", Integer.valueOf(tag).toString());
            switch (tag) {
                case (R.drawable.rook1):
                    next.setImageResource(R.drawable.rook1);
                    next.setTag(Integer.valueOf(R.drawable.rook1));
                    break;

                case (R.drawable.rook3):
                    next.setImageResource(R.drawable.rook3);
                    next.setTag(Integer.valueOf(R.drawable.rook3));
                    break;

                case (R.drawable.bishop1):
                    next.setImageResource(R.drawable.bishop1);
                    next.setTag(Integer.valueOf(R.drawable.bishop1));
                    break;

                case (R.drawable.bishop2):
                    next.setImageResource(R.drawable.bishop2);
                    next.setTag(Integer.valueOf(R.drawable.bishop2));
                    break;
                case (R.drawable.king1):
                    next.setImageResource(R.drawable.king1);
                    next.setTag(Integer.valueOf(R.drawable.king1));
                    break;
                case (R.drawable.king2):
                    next.setImageResource(R.drawable.king2);
                    next.setTag(Integer.valueOf(R.drawable.king2));
                    break;
                case (R.drawable.queen1):
                    next.setImageResource(R.drawable.queen1);
                    next.setTag(Integer.valueOf(R.drawable.queen1));
                    break;
                case (R.drawable.queen2):
                    next.setImageResource(R.drawable.queen2);
                    next.setTag(Integer.valueOf(R.drawable.queen2));
                    break;
                case (R.drawable.night1):
                    next.setImageResource(R.drawable.night1);
                    next.setTag(Integer.valueOf(R.drawable.night1));
                    break;
                case (R.drawable.night2):
                    next.setImageResource(R.drawable.night2);
                    next.setTag(Integer.valueOf(R.drawable.night2));
                    break;
                case (R.drawable.pawn1):
                    next.setImageResource(R.drawable.pawn1);
                    next.setTag(Integer.valueOf(R.drawable.pawn1));
                    break;
                case (R.drawable.pawn2):
                    next.setImageResource(R.drawable.pawn2);
                    next.setTag(Integer.valueOf(R.drawable.pawn2));
                    break;
            }
            selected.setImageDrawable(null);
            selected.setTag(null);
            selected = null;


        }
    }


}