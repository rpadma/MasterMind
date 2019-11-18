package com.mandb.rohitpadma.mastermind;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mandb.rohitpadma.mastermind.adapter.MasterMindAdapter;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    MasterMindAdapter masterMindAdapter;
    ImageView btnRed, btnYellow, btnBlack, btnGreen, btnOrange, btnBlue;
    ArrayList<MasterMindModel> masterMindModels=new ArrayList<>();
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
        masterMindModels.set(position,prevModel);
        masterMindModels.set(position+1,currentModel);
        masterMindAdapter.notifyDataSetChanged();
    }
}
