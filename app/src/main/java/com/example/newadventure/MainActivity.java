package com.example.newadventure;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    GridAdapter gridAdapter;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gameGrid_GV_Id);
        reset = findViewById(R.id.resetGame_B_Id);

        //I hope it recoganizes the changes

        int[] lightId = {R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off
                , R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off
                , R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off
                , R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off
                , R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off, R.drawable.lights_off};

        for (int j=0;j<lightId.length;j++){
            if (Math.random() > 0.7){
                lightId[j] = R.drawable.lights_on;
            }
        }

        int[] originalGame = new int[lightId.length];
        for (int i=0;i<lightId.length;i++){
            originalGame[i] = lightId[i];
        }

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<lightId.length;i++){
                    lightId[i] = originalGame[i];
                }

                gridView.setAdapter(new GridAdapter(MainActivity.this, lightId));
            }
        });

        gridAdapter = new GridAdapter(MainActivity.this, lightId);

        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long Id) {
                int originalPosition = position;
                if (lightId[position] == R.drawable.lights_on){
                    lightId[position] = R.drawable.lights_off;
                    try {
                        if (originalPosition==4 || originalPosition==9 || originalPosition==14 || originalPosition==19 || originalPosition==24){}
                        else {
                            position = originalPosition+1;
                            if (lightId[position]==R.drawable.lights_off){
                                lightId[position] = R.drawable.lights_on;
                            } else {
                                lightId[position] = R.drawable.lights_off;
                            }
                        }
                    } catch (Exception e){}
                    try {
                        if (originalPosition==0 || originalPosition==5 || originalPosition==10 || originalPosition==15 || originalPosition==20){}
                        else {
                            position = originalPosition-1;
                            if (lightId[position]==R.drawable.lights_off){
                                lightId[position] = R.drawable.lights_on;
                            } else {
                                lightId[position] = R.drawable.lights_off;
                            }
                        }
                    } catch (Exception e){}
                    try {
                        position = originalPosition+5;
                        if (lightId[position]==R.drawable.lights_off){
                            lightId[position] = R.drawable.lights_on;
                        } else {
                            lightId[position] = R.drawable.lights_off;
                        }
                    } catch (Exception e){}
                    try {
                        position = originalPosition-5;
                        if (lightId[position]==R.drawable.lights_off){
                            lightId[position] = R.drawable.lights_on;
                        } else {
                            lightId[position] = R.drawable.lights_off;
                        }
                    } catch (Exception e){}
                    position = originalPosition;
                    gridView.setAdapter(gridAdapter);
                } else if (lightId[position] == R.drawable.lights_off){
                    lightId[position] = R.drawable.lights_on;
                    try {
                        if (originalPosition==4 || originalPosition==9 || originalPosition==14 || originalPosition==19 || originalPosition==24){}
                        else {
                            position = originalPosition+1;
                            if (lightId[position]==R.drawable.lights_off){
                                lightId[position] = R.drawable.lights_on;
                            } else {
                                lightId[position] = R.drawable.lights_off;
                            }
                        }
                    } catch (Exception e){}
                    try {
                        if (originalPosition==0 || originalPosition==5 || originalPosition==10 || originalPosition==15 || originalPosition==20){}
                        else {
                            position = originalPosition-1;
                            if (lightId[position]==R.drawable.lights_off){
                                lightId[position] = R.drawable.lights_on;
                            } else {
                                lightId[position] = R.drawable.lights_off;
                            }
                        }
                    } catch (Exception e){}
                    try {
                        position = originalPosition+5;
                        if (lightId[position]==R.drawable.lights_off){
                            lightId[position] = R.drawable.lights_on;
                        } else {
                            lightId[position] = R.drawable.lights_off;
                        }
                    } catch (Exception e){}
                    try {
                        position = originalPosition-5;
                        if (lightId[position]==R.drawable.lights_off){
                            lightId[position] = R.drawable.lights_on;
                        } else {
                            lightId[position] = R.drawable.lights_off;
                        }
                    } catch (Exception e){}
                    position = originalPosition;
                    gridView.setAdapter(gridAdapter);
                }
                checkWin(lightId);
            }
        });

    }

    public void checkWin(int[] lightId){
        int count=0;
        for (int i=0;i<lightId.length;i++){
            if (lightId[i]==R.drawable.lights_off){
                count++;
            }
            else {
                break;
            }
        }

        if (count==lightId.length){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Congratulations");
            builder.setMessage("You have completed the Game");
            builder.setCancelable(false);
        }
    }

}