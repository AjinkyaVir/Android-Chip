package com.example.androidchips;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

public class MainActivity extends AppCompatActivity {

    private ChipGroup chipGroupOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chip chipJob = findViewById(R.id.chipJobs);
        chipJob.setBackgroundResource(R.drawable.strock_bg);
    }
}