package com.mandb.rohitpadma.mastermind.adapter;

import android.view.View;
import android.widget.ImageView;

import com.mandb.rohitpadma.mastermind.MasterMindModel;
import com.mandb.rohitpadma.mastermind.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MasterMindViewHolder extends RecyclerView.ViewHolder {

    ImageView step1;
    ImageView step2;
    ImageView step3;
    ImageView step4;
    ImageView clue1;
    ImageView clue2;
    ImageView clue3;
    ImageView clue4;
    ImageView control;
    ConstraintLayout stepLayout;
    ArrayList<ImageView> imageViews = new ArrayList<>();

    public MasterMindViewHolder(@NonNull View itemView) {
        super(itemView);
        step1 = itemView.findViewById(R.id.btnStep1);
        step2 = itemView.findViewById(R.id.btnStep2);
        step3 = itemView.findViewById(R.id.btnStep3);
        step4 = itemView.findViewById(R.id.btnStep4);
        clue1 = itemView.findViewById(R.id.clue1);
        clue2 = itemView.findViewById(R.id.clue2);
        clue3 = itemView.findViewById(R.id.clue3);
        clue4 = itemView.findViewById(R.id.clue4);
        control = itemView.findViewById(R.id.control);
        stepLayout = itemView.findViewById(R.id.stepLayout);
        imageViews.add(clue1);
        imageViews.add(clue2);
        imageViews.add(clue3);
        imageViews.add(clue4);
    }

    public void bindClueColors(MasterMindModel masterMindModel){
        if(masterMindModel.getClue_colors()!=null && masterMindModel.getClue_colors().size()>0){
            for(int i=0;i<masterMindModel.getClue_colors().size();i++){
                imageViews.get(i).setImageResource(masterMindModel.getClue_colors().get(i));
            }
        }
    }
}
