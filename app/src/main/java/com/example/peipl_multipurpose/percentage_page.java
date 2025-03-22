package com.example.peipl_multipurpose;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class percentage_page extends AppCompatActivity {
//    All the Public Variables
    public Integer percentage_val;
    public TextView amount_display;
    public EditText percent_textbox;
    public EditText amount_textbox;
    public Button submit_percent;
    public Button submit_amount;
    public String string_amount;
    public float percent_amount;
    public float total_amount;
    public String total_amount_string;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_percentage_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
//        Defining all the views
        submit_percent = findViewById(R.id.submit_percent);
        submit_amount = findViewById(R.id.submit_amount);
        percent_textbox = findViewById(R.id.percent_textbox);
        amount_textbox = findViewById(R.id.amount_textbox);
        amount_display = findViewById(R.id.amount_display);
    }

    public void percent_value(View v) {
        string_amount = percent_textbox.getText().toString();
        if (!string_amount.isEmpty()) {
            percentage_val = Integer.parseInt(string_amount);
            percent_textbox.setVisibility(View.INVISIBLE);
            submit_percent.setVisibility(View.INVISIBLE);
            amount_textbox.setVisibility(View.VISIBLE);
            submit_amount.setVisibility(View.VISIBLE);
            Toast.makeText(this, "The percentage is:" + string_amount + "%", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Enter the Percentage First", Toast.LENGTH_SHORT).show();
        }
    }
    public void find_percent(View v){
        percent_amount = Float.parseFloat(String.valueOf(amount_textbox.getText()));
        total_amount = percent_amount*percentage_val/100 + percent_amount;
        total_amount_string = Float.toString(total_amount);
//        System.out.println(total_amount);
        amount_display.setText(" The amount after \n multiplying the \n  amount by "+string_amount +"%" +" \n is: "+total_amount_string);
    }
    public void back_to_main(View v){
        Intent main_intent = new Intent(this,com.example.peipl_multipurpose.MainActivity.class);
        startActivity(main_intent);
    }
}