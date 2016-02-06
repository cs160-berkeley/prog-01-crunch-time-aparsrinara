package com.example.anarayan.crunchtime;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.graphics.Color;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public Spinner typeExercise;
    public EditText weight;
    public EditText repsOrMin;
    public Button go;

    class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView parent, View view, int position, long id) {
            // On selecting a spinner item
            String typeOfExercise = typeExercise.getSelectedItem().toString();
            if (typeOfExercise.equals("-----None chosen-----"))
                repsOrMin.setHint("Enter #Reps/Min/Calories");
            else if (typeOfExercise.equals("Choose Calories"))
                repsOrMin.setHint("Enter #Calories");
            else if (typeOfExercise.equals("Pushup") || typeOfExercise.equals("Situp") || typeOfExercise.equals("Squats") || typeOfExercise.equals("Pullup"))
                repsOrMin.setHint("Enter #Reps");
            else
                repsOrMin.setHint("Enter #Min");
        }

        @Override
        public void onNothingSelected(AdapterView arg0) {
            // TODO Auto-generated method stub
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weight = (EditText) findViewById(R.id.weight);
        repsOrMin = (EditText) findViewById(R.id.repsOrMin);
        typeExercise = (Spinner) findViewById(R.id.spinner);
        typeExercise.setOnItemSelectedListener(new MyOnItemSelectedListener());

        go = (Button) findViewById(R.id.button);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean b = false;
                if (typeExercise.getSelectedItem().toString().equals("-----None chosen-----")) {
                    TextView errorText = (TextView) typeExercise.getSelectedView();
                    errorText.setTextColor(Color.RED);//just to highlight that this is an error
                    errorText.setText("Oops! Field is Empty!");//changes the selected item text to this
                    b = true;
                }
                if (weight.getText().toString().length() == 0 && repsOrMin.getText().toString().length() == 0) {
                    weight.setError("Oops! Field is Empty!");
                    repsOrMin.setError("Oops! Field is Empty!");
                    b = true;
                }
                else if (weight.getText().toString().length() == 0) {
                    weight.setError("Oops! Field is Empty!");
                    b = true;
                }
                else if (repsOrMin.getText().toString().length() == 0) {
                    repsOrMin.setError("Oops! Field is Empty!");
                    b = true;
                }
                else {
                    if (!b)
                        sendMessage(v);
                }
            }
        });
    }

    /** Called when the user clicks the Go button */
    public void sendMessage(View view) {
        // Do something in response to button
        Intent intent = new Intent(this, Main2Activity.class);
        double personWeight = Double.valueOf(weight.getText().toString());
        double numRepsOrMin = Double.valueOf(repsOrMin.getText().toString());
        String typeOfExercise = typeExercise.getSelectedItem().toString();
        intent.putExtra("com.example.anarayan.crunchtime.weight", personWeight);
        intent.putExtra("com.example.anarayan.crunchtime.repsOrMin", numRepsOrMin);
        intent.putExtra("com.example.anarayan.crunchtime.typeExercise", typeOfExercise);
        startActivity(intent);
    }
}
