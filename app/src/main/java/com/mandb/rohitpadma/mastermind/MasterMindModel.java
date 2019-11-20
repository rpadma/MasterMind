package com.mandb.rohitpadma.mastermind;

import java.util.ArrayList;

public class MasterMindModel {

    int input_one;
    int input_two;
    int input_three;
    int input_four;
    ArrayList<Integer> clue_colors;
    boolean isEnable = false;
    boolean isWon = false;

    public MasterMindModel() {
    }

    public MasterMindModel(int input_one, int input_two, int input_three, int input_four) {
        this.input_one = input_one;
        this.input_two = input_two;
        this.input_three = input_three;
        this.input_four = input_four;
    }

    public boolean isEnable() {
        return isEnable;
    }

    public void setEnable(boolean enable) {
        isEnable = enable;
    }

    public int getInput_one() {
        return input_one;
    }

    public void setInput_one(int input_one) {
        this.input_one = input_one;
    }

    public int getInput_two() {
        return input_two;
    }

    public void setInput_two(int input_two) {
        this.input_two = input_two;
    }

    public int getInput_three() {
        return input_three;
    }

    public void setInput_three(int input_three) {
        this.input_three = input_three;
    }

    public int getInput_four() {
        return input_four;
    }

    public void setInput_four(int input_four) {
        this.input_four = input_four;
    }

    public ArrayList<Integer> getClue_colors() {
        return clue_colors;
    }

    public void setClue_colors(ArrayList<Integer> clue_colors) {
        this.clue_colors = clue_colors;
    }

    public boolean isWon() {
        return isWon;
    }

    public void setWon(boolean won) {
        isWon = won;
    }
}
