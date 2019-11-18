package com.mandb.rohitpadma.mastermind.adapter;

import android.view.View;
import android.widget.ImageView;

import com.mandb.rohitpadma.mastermind.R;

import androidx.annotation.NonNull;
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
    }
}
