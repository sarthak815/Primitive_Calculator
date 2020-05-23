package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstnumber, secondnumber;
    Button add, sub, mult, div;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstnumber = findViewById(R.id.first_number);
        secondnumber = findViewById(R.id.second_number);
        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mult = findViewById(R.id.mult);
        div = findViewById(R.id.div);
        answer = findViewById(R.id.answer);

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
            calculation("+");

            }
        });
        sub.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculation("-");

            }
        });
        mult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculation("*");

            }
        });
        div.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculation("/");

            }
        });

    }

    private void calculation(String operation){
        String first = firstnumber.getText().toString().trim();
        String second = secondnumber.getText().toString().trim();

        if(first.isEmpty() || second.isEmpty()){
            showToast("Invalid Input");

        }else{
            int ans = 0;
            try{
                int firstnumber = Integer.parseInt(first);
                int secondnumber = Integer.parseInt(second);

                switch(operation){
                    case "+":{
                        ans = firstnumber + secondnumber;
                        break;
                    }
                    case "-":{
                        ans = firstnumber-secondnumber;
                        break;

                    }
                    case  "*":{
                        ans = firstnumber*secondnumber;
                        break;
                    }
                    default:{
                        ans = firstnumber/secondnumber;
                        break;
                    }
                }
                    String Answer = String.valueOf(ans);
                answer.setText(Answer);
            } catch (Exception e){
                showToast("Invalid Input");
                Log.e("Conversion error", e.getMessage());
            }
        }
        }
    }

    private void showToast(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
