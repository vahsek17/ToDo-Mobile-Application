package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class TwoOptionsActivity extends AppCompatActivity {

    ImageButton addNew, myLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_options);

        addNew = findViewById(R.id.AddNew);
        myLists = findViewById(R.id.MyLists);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(TwoOptionsActivity.this, AddNewActivity.class));
                finish();
            }
        });

        myLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(TwoOptionsActivity.this, MyListsActivity.class));
                finish();
            }
        });


    }
}