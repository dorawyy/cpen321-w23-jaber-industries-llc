package com.beaker.recipeRoulette;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ReviewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView nameView, emailView;
    Button readMoreView;

    public ReviewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.name);
        emailView = itemView.findViewById(R.id.email);
        readMoreView = itemView.findViewById(R.id.readmore_but);
    }
}
