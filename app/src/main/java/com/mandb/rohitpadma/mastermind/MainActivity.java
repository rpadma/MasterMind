package com.mandb.rohitpadma.mastermind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.mandb.rohitpadma.mastermind.adapter.MasterMindAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MasterMindAdapter masterMindAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        bindData();
    }

    public void bindData(){
        ArrayList<MasterMindModel> masterMindModels=new ArrayList<>();
        for(int i=0;i<8;i++){
            masterMindModels.add(new MasterMindModel());
        }
        masterMindAdapter = new MasterMindAdapter(masterMindModels,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(masterMindAdapter);
        recyclerView.setLayoutFrozen(true);
    }


}
