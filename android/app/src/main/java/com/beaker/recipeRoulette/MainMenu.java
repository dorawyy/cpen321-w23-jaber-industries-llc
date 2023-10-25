package com.beaker.recipeRoulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    private Button recipeReviewButton;

    private Button takePhotoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        recipeReviewButton = findViewById(R.id.menu5);
        takePhotoButton = findViewById(R.id.menu6);

        takePhotoButton.setOnClickListener(view -> {
            Intent takePhotoIntent = new Intent(MainMenu.this, com.beaker.recipeRoulette.TakePhoto.class);
            startActivity(takePhotoIntent);
        });

        recipeReviewButton.setOnClickListener(view -> {
            Intent mainMenuIntent = new Intent(MainMenu.this, com.beaker.recipeRoulette.RecipeFacebook.class);
            startActivity(mainMenuIntent);
        });
    }
}