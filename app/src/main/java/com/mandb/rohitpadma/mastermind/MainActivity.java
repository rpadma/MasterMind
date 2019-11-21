package com.mandb.rohitpadma.mastermind;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mandb.rohitpadma.mastermind.adapter.MasterMindAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    MasterMindAdapter masterMindAdapter;
    ImageView btnPink, btnYellow, btnPurple, btnGreen, btnOrange, btnBlue;
    ArrayList<MasterMindModel> masterMindModels=new ArrayList<>();
    ArrayList<Integer> colorPositions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        btnPink = (ImageView) findViewById(R.id.btnPink);
        btnYellow = (ImageView) findViewById(R.id.btnYellow);
        btnOrange = (ImageView) findViewById(R.id.btnOrange);
        btnGreen = (ImageView) findViewById(R.id.btnGreen);
        btnBlue = (ImageView) findViewById(R.id.btnBlue);
        btnPurple = (ImageView) findViewById(R.id.btnPurple);

        btnPurple.setOnClickListener(this);
        btnPink.setOnClickListener(this);
        btnYellow.setOnClickListener(this);
        btnGreen.setOnClickListener(this);
        btnBlue.setOnClickListener(this);
        btnOrange.setOnClickListener(this);
        bindData();
        colorPositions = generateRandomColors();
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
            case R.id.btnPurple: {
                masterMindAdapter.setColorBasedOnPosition(R.drawable.ic_circle_purple);
            }
            break;
            case R.id.btnBlue: {
                masterMindAdapter.setColorBasedOnPosition(R.drawable.ic_circle_blue);
            }
            break;
            case R.id.btnPink: {
                masterMindAdapter.setColorBasedOnPosition(R.drawable.ic_circle_pink);
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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("You Won!");
            builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    clearListView();
                    bindData();
                    colorPositions = generateRandomColors();
                    dialog.dismiss();
                }
            });

            builder.create().show();
            Log.d("colorCode", "You WON");
        }
    }

    public int getResourceBasedOnRandomNumber(int number) {
        switch (number) {
            case 0:
                Log.d("colorCode", "purple");
                return R.drawable.ic_circle_purple;
            case 1:
                Log.d("colorCode", "blue");
                return R.drawable.ic_circle_blue;
            case 2:
                Log.d("colorCode", "Pink");
                return R.drawable.ic_circle_pink;
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

    public void clearListView(){
        masterMindModels.clear();
        colorPositions.clear();
        masterMindAdapter.notifyDataSetChanged();
    }

    public void showTheColors(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("You Lost - The Sequence is:");
        builder.setView(setColors());
        builder.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearListView();
                bindData();
                colorPositions = generateRandomColors();
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                clearListView();
                bindData();
                colorPositions = generateRandomColors();
              dialog.dismiss();
            }
        });




        AlertDialog dialog= builder.create();
        dialog.show();
    }

    public View setColors(){
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(
                WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout2.setGravity( Gravity.CENTER);

        if(colorPositions.size()>0){
            for(int i=0;i<colorPositions.size();i++){
                ImageView imageView=new ImageView(this);
                imageView.setImageResource(colorPositions.get(i));
                imageView.setBackground(getDrawable(R.drawable.box));
                imageView.setLayoutParams(new LinearLayout.LayoutParams(100,100));
                linearLayout2.addView(imageView);
            }
        }
        return linearLayout2.getRootView();
    }

    public void showWarningMessage(){
        Toast.makeText(this,"Select all four color",Toast.LENGTH_SHORT).show();
    }
}
