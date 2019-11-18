package com.mandb.rohitpadma.mastermind.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mandb.rohitpadma.mastermind.MainActivity;
import com.mandb.rohitpadma.mastermind.MasterMindModel;
import com.mandb.rohitpadma.mastermind.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MasterMindAdapter extends RecyclerView.Adapter<MasterMindViewHolder> {

    ArrayList<MasterMindModel> masterMindModels = new ArrayList<>();
    Context context;
    ImageView selectedView;
    int selectedPosition=0;
    int flag=0;

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
    public void onBindViewHolder(@NonNull final MasterMindViewHolder holder, final int position) {
        MasterMindModel masterMindModel=masterMindModels.get(position);
        holder.step1.setImageResource(masterMindModel.getInput_one());
        holder.step2.setImageResource(masterMindModel.getInput_two());
        holder.step3.setImageResource(masterMindModel.getInput_three());
        holder.step4.setImageResource(masterMindModel.getInput_four());
        if (masterMindModel.isEnable()) {
            holder.control.setVisibility(View.VISIBLE);
            holder.stepLayout.setClickable(true);


            holder.step1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedView != null) {
                        selectedView.setBackground(context.getDrawable(R.drawable.box));
                    }
                    holder.step1.setBackground(context.getDrawable(R.drawable.selectedbox));
                    selectedView = holder.step1;
                    flag=1;
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
                    flag=2;
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
                    flag=3;
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
                    flag=4;
                }
            });


        }
        holder.control.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedView != null) {
                    selectedView.setBackground(context.getDrawable(R.drawable.box));
                }
                if(position+1<8){
                    MasterMindModel prevModel = masterMindModels.get(position);
                    MasterMindModel currModel = masterMindModels.get(position+1);
                    prevModel.setEnable(false);
                    currModel.setEnable(true);
                    ((MainActivity)context).updateItemView(position,prevModel,currModel);
                    selectedPosition=selectedPosition+1;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return masterMindModels.size();
    }

    public void setColorBasedOnPosition(int i) {
        selectedView.setImageResource(i);
        setStepValueByFlag(i);
    }

    public void setStepValueByFlag(int i){
       MasterMindModel masterMindModel= masterMindModels.get(selectedPosition);
        switch (flag){
            case 1: {
                masterMindModel.setInput_one(i);
            } break;
            case 2: {
                masterMindModel.setInput_two(i);
            }break;
            case 3: {
                masterMindModel.setInput_three(i);
            }break;
            case 4: {
                masterMindModel.setInput_four(i);
            }break;
        }
        masterMindModels.set(selectedPosition,masterMindModel);
    }
}
