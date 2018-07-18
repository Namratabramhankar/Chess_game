package com.coc.chessgame;

public class Rook extends MainActivity {


    public void validateRook() {


        if (src_row == target_row || src_col == target_col) {
            buttons[target_row][target_col].setImageResource(R.drawable.rookb);
        } else {
            System.out.println("Select correct tile");
        }

    }




}
