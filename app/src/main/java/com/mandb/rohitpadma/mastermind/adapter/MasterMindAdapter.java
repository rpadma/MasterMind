package com.mandb.rohitpadma.mastermind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.mandb.rohitpadma.mastermind.MasterMindModel;
import com.mandb.rohitpadma.mastermind.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MasterMindAdapter extends RecyclerView.Adapter<MasterMindViewHolder> {

    ArrayList<MasterMindModel> masterMindModels = new ArrayList<>();
    Context context;

    public MasterMindAdapter(ArrayList<MasterMindModel> masterMindModels, Context context) {
        this.masterMindModels = masterMindModels;
        this.context = context;
    }

    @NonNull
    @Override
    public MasterMindViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.step_layout, parent, false);
        return new MasterMindViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MasterMindViewHolder holder, int position) {
            holder.bind(masterMindModels.get(position));
    }

    @Override
    public int getItemCount() {
        return masterMindModels.size();
    }
}
