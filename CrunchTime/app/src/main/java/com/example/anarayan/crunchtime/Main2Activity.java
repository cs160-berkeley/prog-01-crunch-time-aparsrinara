package com.example.anarayan.crunchtime;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {
    public TextView caloriesBurned;
    public TextView calories;
    public TextView equivEx;
    public TextView pushup;
    public TextView situp;
    public TextView squats;
    public TextView leg_lift;
    public TextView plank;
    public TextView jumping_jacks;
    public TextView pullup;
    public TextView cycling;
    public TextView walking;
    public TextView jogging;
    public TextView swimming;
    public TextView stair_climbing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        double weight = intent.getExtras().getDouble("com.example.anarayan.crunchtime.weight");
        String typeOfExercise = intent.getExtras().getString("com.example.anarayan.crunchtime.typeExercise");
        double numRepsOrMin = intent.getExtras().getDouble("com.example.anarayan.crunchtime.repsOrMin");
        calories = (TextView) findViewById(R.id.calories);
        caloriesBurned = (TextView) findViewById(R.id.textView2);
        pushup = (TextView) findViewById(R.id.textView4);
        situp = (TextView) findViewById(R.id.textView5);
        squats = (TextView) findViewById(R.id.textView6);
        leg_lift = (TextView) findViewById(R.id.textView7);
        plank = (TextView) findViewById(R.id.textView8);
        jumping_jacks = (TextView) findViewById(R.id.textView10);
        pullup= (TextView) findViewById(R.id.textView11);
        cycling = (TextView) findViewById(R.id.textView12);
        walking = (TextView) findViewById(R.id.textView13);
        jogging = (TextView) findViewById(R.id.textView14);
        swimming = (TextView) findViewById(R.id.textView15);
        stair_climbing = (TextView) findViewById(R.id.textView16);

        double cal = 1;
        double calpermin = 1;
        double calperrep = 1;

        if (typeOfExercise.equals("Pushup")) {
            calperrep = 100.0/350.0/150.0;
            cal = weight * calperrep * numRepsOrMin;
        }
        else if (typeOfExercise.equals("Situp")) {
            calperrep = 100.0/(200.0*150.0);
            cal = weight*calperrep*numRepsOrMin;
        }
        else if (typeOfExercise.equals("Squats")) {
            calperrep = 100.0/(225.0*150.0);
            cal = weight*calperrep*numRepsOrMin;
        }
        else if (typeOfExercise.equals("Leg-lift")) {
            calpermin = 100.0/(25.0*150.0);
            cal = weight*calpermin*numRepsOrMin;
        }
        else if (typeOfExercise.equals("Plank")) {
            calpermin = 100.0/(25.0*150.0);
            cal = weight*calpermin*numRepsOrMin;
        }
        else if (typeOfExercise.equals("Jumping Jacks")) {
            calpermin = 100.0/(10.0*150.0);
            cal = weight*calpermin*numRepsOrMin;
        }
        else if (typeOfExercise.equals("Pullup")) {
            calperrep = 100.0/(100.0*150.0);
            cal = weight*calperrep*numRepsOrMin;
        }
        else if (typeOfExercise.equals("Cycling")) {
            calpermin = 100.0/(12.0*150.0);
            cal = weight*calpermin*numRepsOrMin;
        }
        else if (typeOfExercise.equals("Walking")) {
            calpermin = 100.0/(20.0*150.0);
            cal = weight*calpermin*numRepsOrMin;
        }
        else if (typeOfExercise.equals("Jogging")) {
            calpermin = 100.0/(12.0*150.0);
            cal = weight*calpermin*numRepsOrMin;
        }
        else if (typeOfExercise.equals("Swimming")) {
            calpermin = 100.0/(13.0*150.0);
            cal = weight*calpermin*numRepsOrMin;
        }
        else {
            calpermin = 100.0/(15.0*150.0);
            cal = weight*calpermin*numRepsOrMin;
        }
        if (typeOfExercise.equals("Choose Calories")) {
            caloriesBurned.setText("To burn a total of");
            calories.setText(String.format("%.2f calories", numRepsOrMin));
            cal = numRepsOrMin;
        }
        else {
            calories.setText(String.format("%.2f calories", cal));
        }

        // Equivalent exercises solution
        pushup.setText((int) Math.ceil((cal/weight)*(350.0*150.0/100.0)) + " Pushups" );
        situp.setText((int) Math.ceil((cal/weight)*(200.0*150.0/100.0))+ " Situps");
        squats.setText((int) Math.ceil((cal/weight)*(225.0*150.0/100.0))+ " Squats");
        leg_lift.setText((int) Math.ceil((cal/weight) * (25.0*150.0 / 100.0))+ " min of Leg lifts");
        plank.setText((int) Math.ceil((cal/weight) * (25.0*150.0 / 100.0))+ " Planks");
        jumping_jacks.setText((int) Math.ceil((cal/weight) * (10.0*150.0 / 100.0))+ " min of Jumping Jacks");
        pullup.setText((int) Math.ceil((cal/weight)*(100.0*150.0/100.0))+ " Pullups");
        cycling.setText((int) Math.ceil((cal/weight) * (12.0*150.0 / 100.0))+ " min of Cycling");
        walking.setText((int) Math.ceil((cal/weight)*(20.0*150.0/100.0))+ " min of Walking");
        jogging.setText((int) Math.ceil((cal/weight) * (12.0*150.0 / 100.0))+ " min of Jogging");
        swimming.setText((int) Math.ceil((cal/weight)*(13.0*150.0/100.0))+ " min of Swimming");
        stair_climbing.setText((int) Math.ceil((cal/weight) * (15.0*150.0/ 100.0))+ " min of Stair Climbing");
        Button reset = (Button) findViewById(R.id.resetbutton);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });
    }

    public void sendMessage(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
