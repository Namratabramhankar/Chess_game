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


    public ImageButton[][] buttons = new ImageButton[8][8];
    public ImageButton selected = null;
    int src_row;
    int src_col;
    int target_row;
    int target_col;
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
                    buttons[i][j].setBackgroundColor(Color.GRAY);
                } else {
                    buttons[i][j].setBackgroundColor(Color.WHITE);
                }
                //selected = null;
            }
        }


        buttons[0][0].setImageResource(R.drawable.rookw);
        buttons[0][0].setTag(Integer.valueOf(R.drawable.rookw));
        buttons[0][7].setImageResource(R.drawable.rookw);
        buttons[0][7].setTag(Integer.valueOf(R.drawable.rookw));
        buttons[0][1].setImageResource(R.drawable.nightw);
        buttons[0][1].setTag(Integer.valueOf(R.drawable.nightw));
        buttons[0][6].setImageResource(R.drawable.nightw);
        buttons[0][6].setTag(Integer.valueOf(R.drawable.nightw));
        buttons[0][2].setImageResource(R.drawable.bishopw);
        buttons[0][2].setTag(Integer.valueOf(R.drawable.bishopw));
        buttons[0][5].setImageResource(R.drawable.bishopw);
        buttons[0][5].setTag(Integer.valueOf(R.drawable.bishopw));
        buttons[0][3].setImageResource(R.drawable.queenw);
        buttons[0][3].setTag(Integer.valueOf(R.drawable.queenw));
        buttons[0][4].setImageResource(R.drawable.kingw);
        buttons[0][4].setTag(Integer.valueOf(R.drawable.kingw));
        buttons[7][0].setImageResource(R.drawable.rookb);
        buttons[7][0].setTag(Integer.valueOf(R.drawable.rookb));
        buttons[7][7].setImageResource(R.drawable.rookb);
        buttons[7][7].setTag(Integer.valueOf(R.drawable.rookb));
        buttons[7][1].setImageResource(R.drawable.nightb);
        buttons[7][1].setTag(Integer.valueOf(R.drawable.nightb));
        buttons[7][6].setImageResource(R.drawable.nightb);
        buttons[7][6].setTag(Integer.valueOf(R.drawable.nightb));
        buttons[7][2].setImageResource(R.drawable.bishopb);
        buttons[7][2].setTag(Integer.valueOf(R.drawable.bishopb));
        buttons[7][5].setImageResource(R.drawable.bishopb);
        buttons[7][5].setTag(Integer.valueOf(R.drawable.bishopb));
        buttons[7][3].setImageResource(R.drawable.queenb);
        buttons[7][3].setTag(Integer.valueOf(R.drawable.queenb));
        buttons[7][4].setImageResource(R.drawable.kingb);
        buttons[7][4].setTag(Integer.valueOf(R.drawable.kingb));

        for (int i = 0; i < 8; ++i) {
            buttons[1][i].setImageResource(R.drawable.pawnw);
            buttons[1][i].setTag(Integer.valueOf(R.drawable.pawnw));
            buttons[6][i].setImageResource(R.drawable.pawnb);
            buttons[6][i].setTag(Integer.valueOf(R.drawable.pawnb));
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
                        if (selected == buttons[i][j]){
                            src_row = i;
                            src_col = j;
                            Log.v("source","exp");
                        }else {
                            break;
                        }

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
                        if (next == buttons[i][j]){
                            target_row = i;
                            target_col = j;
                            Log.v("target","exp");
                        } else{
                            break;
                        }
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
                case (R.drawable.rookw):
                    //next.setImageResource(R.drawable.rookw);
                    // next.setTag(Integer.valueOf(R.drawable.rookw));
                    if (src_row == target_row || src_col == target_col) {
                        next.setImageResource(R.drawable.rookw);
                        next.setTag(Integer.valueOf(R.drawable.rookw));
                    } else {
                        System.out.println("Select correct tile");
                    }
                    break;

                case (R.drawable.rookb):
                    //next.setImageResource(R.drawable.rookb);
                    //next.setTag(Integer.valueOf(R.drawable.rookb));
                    if (src_row == target_row || src_col == target_col) {
                        next.setImageResource(R.drawable.rookb);
                        next.setTag(Integer.valueOf(R.drawable.rookb));
                    } else {
                        System.out.println("Select correct tile");
                    }
                    break;

                case (R.drawable.bishopw):
                    //next.setImageResource(R.drawable.bishopw);
                    //next.setTag(Integer.valueOf(R.drawable.bishopw));
                    if (Math.abs(src_row - target_row) == Math.abs(src_col - target_col)) {
                        next.setImageResource(R.drawable.bishopw);
                        next.setTag(Integer.valueOf(R.drawable.bishopw));
                    } else {
                        System.out.println("Select correct tile");
                    }
                    break;

                case (R.drawable.bishopb):
                    //next.setImageResource(R.drawable.bishopb);
                    //next.setTag(Integer.valueOf(R.drawable.bishopb));
                    if (Math.abs(src_row - target_row) == Math.abs(src_col - target_col)) {
                        next.setImageResource(R.drawable.bishopb);
                        next.setTag(Integer.valueOf(R.drawable.bishopb));
                    } else {
                        System.out.println("Select correct tile");
                    }

                    break;
                case (R.drawable.queenw):
                    //next.setImageResource(R.drawable.kingw);
                    //next.setTag(Integer.valueOf(R.drawable.kingw));

                    if ((Math.abs(src_row - target_row) == Math.abs(src_col - target_col)) || ((src_col == target_col) || (src_row == target_row))) {
                        next.setImageResource(R.drawable.queenw);
                        next.setTag(Integer.valueOf(R.drawable.queenw));
                    } else {
                        System.out.println("Select correct tile");
                    }

                    break;

                case (R.drawable.queenb):
                    //next.setImageResource(R.drawable.kingb);
                    //next.setTag(Integer.valueOf(R.drawable.kingb));

                    if ((Math.abs(src_row - target_row) == Math.abs(src_col - target_col)) || ((src_col == target_col) || (src_row == target_row))) {
                        next.setImageResource(R.drawable.queenb);
                        next.setTag(Integer.valueOf(R.drawable.queenb));
                    } else {
                        System.out.println("Select correct tile");
                    }

                    break;
                case (R.drawable.kingb):
                    //next.setImageResource(R.drawable.kingb);
                    //next.setTag(Integer.valueOf(R.drawable.kingb));
                    //If ( (|x1-x2| =1 && |y1-y2|=1) || ( |x1-x2|=1 && y1=y2 ) || ( |y1-y2|=1 && x1=x2) )

                    if ((Math.abs(src_row - target_row) ==1 && Math.abs(src_col - target_col)==1) ||
                            (Math.abs(src_col - target_col)==1 && (src_row==target_row))||
                            (Math.abs(src_row - target_row)  == 1 && (src_col==target_col))) {
                        next.setImageResource(R.drawable.kingb);
                        next.setTag(Integer.valueOf(R.drawable.kingb));
                    } else {
                        System.out.println("Select correct tile");
                    }

                    break;
                case (R.drawable.kingw):
                    //next.setImageResource(R.drawable.kingb);
                    //next.setTag(Integer.valueOf(R.drawable.kingb));
                    //If ( (|x1-x2| =1 && |y1-y2|=1) || ( |x1-x2|=1 && y1=y2 ) || ( |y1-y2|=1 && x1=x2) )

                    if ((Math.abs(src_row - target_row) ==1 && Math.abs(src_col - target_col)==1) ||
                            (Math.abs(src_col - target_col)==1 && (src_row==target_row))||
                            (Math.abs(src_row - target_row)  == 1 && (src_col==target_col))) {
                        next.setImageResource(R.drawable.kingw);
                        next.setTag(Integer.valueOf(R.drawable.kingw));
                    } else {
                        System.out.println("Select correct tile");
                    }

                    break;

                case (R.drawable.nightw):
                    //next.setImageResource(R.drawable.nightw);
                    //next.setTag(Integer.valueOf(R.drawable.nightw));
                    //If (|x1-x2|* |y1-y2|=2)
                    if (Math.abs(src_row - target_row) * Math.abs(src_col - target_col) == 2) {
                        next.setImageResource(R.drawable.nightw);
                        next.setTag(Integer.valueOf(R.drawable.nightw));
                    } else {
                        System.out.println("Select correct tile");
                    }
                    break;
                case (R.drawable.nightb):

                    //next.setImageResource(R.drawable.nightb);
                   // next.setTag(Integer.valueOf(R.drawable.nightb));
                    if (Math.abs(src_row - target_row) * Math.abs(src_col - target_col) == 2) {
                    next.setImageResource(R.drawable.nightb);
                    next.setTag(Integer.valueOf(R.drawable.nightb));
                } else {
                    System.out.println("Select correct tile");
                }
                break;
                case (R.drawable.pawnw):
                    next.setImageResource(R.drawable.pawnw);
                    next.setTag(Integer.valueOf(R.drawable.pawnw));
                    break;
                case (R.drawable.pawnb):
                    next.setImageResource(R.drawable.pawnb);
                    next.setTag(Integer.valueOf(R.drawable.pawnb));
                    break;
            }

            selected.setImageDrawable(null);
            selected.setTag(null);
            selected = null;
        }
    }
}