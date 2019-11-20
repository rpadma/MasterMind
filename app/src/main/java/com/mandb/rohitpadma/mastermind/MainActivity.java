package com.mandb.rohitpadma.mastermind;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.mandb.rohitpadma.mastermind.adapter.MasterMindAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    MasterMindAdapter masterMindAdapter;
    ImageView btnRed, btnYellow, btnBlack, btnGreen, btnOrange, btnBlue;
    ArrayList<MasterMindModel> masterMindModels=new ArrayList<>();
    ArrayList<Integer> colorPositions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        btnRed = (ImageView) findViewById(R.id.btnRed);
        btnYellow = (ImageView) findViewById(R.id.btnYellow);
        btnOrange = (ImageView) findViewById(R.id.btnOrange);
        btnGreen = (ImageView) findViewById(R.id.btnGreen);
        btnBlue = (ImageView) findViewById(R.id.btnBlue);
        btnBlack = (ImageView) findViewById(R.id.btnBlack);

        btnBlack.setOnClickListener(this);
        btnRed.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnOrange.setOnClickListener(this);
        bindData();
    }

    public void bindData(){

        for(int i=0;i<8;i++){
            masterMindModels.add(new MasterMindModel(R.drawable.ic_circle_grey,
                    R.drawable.ic_circle_grey,
                    R.drawable.ic_circle_grey,R.drawable.ic_circle_grey));
        }
        masterMindModels.get(0).setEnable(true);
        masterMindAdapter = new MasterMindAdapter(masterMindModels,this);
        masterMindAdapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL, true));
        recyclerView.setAdapter(masterMindAdapter);
    }


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnBlack: {
                masterMindAdapter.setColorBasedOnPosition(R.drawable.ic_circle_black);
            }
            break;
            case R.id.btnBlue: {
                masterMindAdapter.setColorBasedOnPosition(R.drawable.ic_circle_blue);
            }
            break;
            case R.id.btnRed: {
                masterMindAdapter.setColorBasedOnPosition(R.drawable.ic_circle_red);
            }
            break;
            case R.id.btnOrange: {
                masterMindAdapter.setColorBasedOnPosition(R.drawable.ic_circle_orange);
            }
            break;
            case R.id.btnYellow: {
                masterMindAdapter.setColorBasedOnPosition(R.drawable.ic_circle_yellow);
            }
            break;
            case R.id.btnGreen: {
                masterMindAdapter.setColorBasedOnPosition(R.drawable.ic_circle_green);
            }
            break;
        }
    }

    public void updateItemView(int position,
                               MasterMindModel prevModel,
                               MasterMindModel currentModel){
        prevModel = verifyPosition(prevModel);
        if (!prevModel.isWon) {
            masterMindModels.set(position, prevModel);
            masterMindModels.set(position + 1, currentModel);
            masterMindAdapter.notifyDataSetChanged();
        } else {
            Log.d("colorCode", "You WON");
        }
    }

    public int getResourceBasedOnRandomNumber(int number) {
        switch (number) {
            case 0:
                Log.d("colorCode", "black");
                return R.drawable.ic_circle_black;
            case 1:
                Log.d("colorCode", "blue");
                return R.drawable.ic_circle_blue;
            case 2:
                Log.d("colorCode", "red");
                return R.drawable.ic_circle_red;
            case 3:
                Log.d("colorCode", "orange");
                return R.drawable.ic_circle_orange;
            case 4:
                Log.d("colorCode", "yellow");
                return R.drawable.ic_circle_yellow;
            case 5:
                Log.d("colorCode", "green");
                return R.drawable.ic_circle_green;
        }
        return 0;
    }

    public ArrayList<Integer> generateRandomColors() {
        HashSet<Integer> colorPositions = new HashSet<>();
        while (colorPositions.size() < 4) {
            Random rand = new Random();
            int x = rand.nextInt(5);
            colorPositions.add(x);
        }

        ArrayList<Integer> result = new ArrayList<>();
        Iterator it = colorPositions.iterator();
        while (it.hasNext()) {
            result.add(getResourceBasedOnRandomNumber((int) it.next()));
        }
        return result;
    }

    public MasterMindModel verifyPosition(MasterMindModel prevModel) {
        int redFlag = 0;
        int blackFlag = 0;
        ArrayList<Integer> position = new ArrayList<>();
        position.add(prevModel.input_one);
        position.add(prevModel.input_two);
        position.add(prevModel.input_three);
        position.add(prevModel.input_four);

        ArrayList<Integer> clue_colors = new ArrayList<>();

        for (int j = 0; j < position.size(); j++) {
            for (int i = 0; i < colorPositions.size(); i++) {
                if ((colorPositions.get(i) - position.get(j) == 0) && i == j) {
                    clue_colors.add(R.drawable.ic_circle_black);
                    blackFlag++;
                    break;
                }
                if (colorPositions.get(i) - position.get(j) == 0) {
                    clue_colors.add(R.drawable.ic_circle_red);
                    redFlag++;
                    break;
                }
            }
        }
        if (blackFlag == 4) {
            prevModel.setWon(true);
        }
        prevModel.setClue_colors(clue_colors);
        return prevModel;
    }

    public void generateRandom(View v) {
        colorPositions = generateRandomColors();
    }
}
