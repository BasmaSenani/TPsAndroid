package com.example.testcalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     String selectedOperator ;
     String[] operators = {"+","-","x","/"};
     double result ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  widget extraction
        Spinner spinner = findViewById(R.id.spinner);
        EditText nbr1 = findViewById(R.id.nbr1);
        EditText nbr2 = findViewById(R.id.nbr2);
        Button button = findViewById(R.id.button);
        TextView textView = findViewById(R.id.textView);

        // spinner configuration
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedOperator=operators[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selectedOperator = "" ;
            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, operators);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        // button configuration

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(selectedOperator){
                    case "+":
                        result = Double.parseDouble(nbr1.getText().toString()) +  Double.parseDouble(nbr2.getText().toString());
                        break ;
                    case "-" :
                        result = Double.parseDouble(nbr1.getText().toString()) -  Double.parseDouble(nbr2.getText().toString());
                        break ;
                    case "x" :
                        result = Double.parseDouble(nbr1.getText().toString()) *  Double.parseDouble(nbr2.getText().toString());
                        break ;
                    case "/" :
                        result = Double.parseDouble(nbr1.getText().toString()) /  Double.parseDouble(nbr2.getText().toString());
                        break ;
                }

                textView.setText(" "+result);
                Toast.makeText(v.getContext()," "+ result,Toast.LENGTH_LONG).show();
            }
        });





    }
}