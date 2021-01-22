package com.example.androidchips;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipDrawable;
import com.google.android.material.chip.ChipGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ChipGroup chipGroupOption;
    Chip chip;
    Chip chipJob;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chipGroupOption = findViewById(R.id.chipOption);
        getInterest();
    }

    private void getInterest() {

        ApiServices services = RetrofitClientInstance.getRetrofitInstance(this).create(ApiServices.class);
        Call<InterestResponse> call = services.getActiveInterest();
        Log.i("@ajinkya", "success === >>> " + call.request().url());
        call.enqueue(new Callback<InterestResponse>() {
            @Override
            public void onResponse(final Call<InterestResponse> call, Response<InterestResponse> response) {
                Log.i("@ajinkya", "response =>> " + response.body());
                if (response.body().isStatus()) {

                    Log.i("@ajinkya", "response =>> " + response.body().getInterests().get(0).getName());

                    for (int i = 0; i < response.body().getInterests().size(); i++) {
                        final String name = response.body().getInterests().get(i).getName();
                        View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.item_filter_chip, chipGroupOption, false);
                        Chip chip = view.findViewById(R.id.chipJobs);
                        chip.setText(name);
                        chip.setClickable(true);
                        chip.setCheckable(true);


                        chipGroupOption.addView(chip);
                        chip.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this, "Clicked Call API For ==>>> " + name, Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }

            }

            @Override
            public void onFailure(Call<InterestResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}

