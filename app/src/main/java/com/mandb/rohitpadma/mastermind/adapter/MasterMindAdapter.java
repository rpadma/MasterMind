package com.mandb.rohitpadma.mastermind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mandb.rohitpadma.mastermind.MasterMindModel;
import com.mandb.rohitpadma.mastermind.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MasterMindAdapter extends RecyclerView.Adapter<MasterMindViewHolder> {

    ArrayList<MasterMindModel> masterMindModels = new ArrayList<>();
    Context context;
    ImageView selectedView;

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
    public void onBindViewHolder(@NonNull final MasterMindViewHolder holder, int position) {
        if (masterMindModels.get(position).isEnable()) {
            holder.step1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedView != null) {
                        selectedView.setBackground(context.getDrawable(R.drawable.box));
                    }
                    holder.step1.setBackground(context.getDrawable(R.drawable.selectedbox));
                    selectedView = holder.step1;
                }
            });
            holder.step2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedView != null) {
                        selectedView.setBackground(context.getDrawable(R.drawable.box));
                    }
                    holder.step2.setBackground(context.getDrawable(R.drawable.selectedbox));
                    selectedView = holder.step2;
                }
            });
            holder.step3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedView != null) {
                        selectedView.setBackground(context.getDrawable(R.drawable.box));
                    }
                    holder.step3.setBackground(context.getDrawable(R.drawable.selectedbox));
                    selectedView = holder.step3;
                }
            });
            holder.step4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedView != null) {
                        selectedView.setBackground(context.getDrawable(R.drawable.box));
                    }
                    holder.step4.setBackground(context.getDrawable(R.drawable.selectedbox));
                    selectedView = holder.step4;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return masterMindModels.size();
    }

    public void setColorBasedOnPosition(int i) {
        selectedView.setImageResource(i);
    }
}
