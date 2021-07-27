package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddNewActivity extends AppCompatActivity {

    ImageButton lists;
    Button save, back;
    EditText title,textMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new);

        lists = findViewById(R.id.Lists);
        save = findViewById(R.id.Save);
        back = findViewById(R.id.Back);
        title = findViewById(R.id.PaneTitle);
        textMessage = findViewById(R.id.PaneTextMessage);
        lists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddNewActivity.this, MyListsActivity.class));
                finish();
            }
        });



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String recovered_title_message = sharedPreferences.getString("data", String.valueOf(MODE_PRIVATE));

                String title_message = title.getText().toString() +"`"+ textMessage.getText().toString()+"~"+ recovered_title_message;

                Toast.makeText(AddNewActivity.this,"ToDo List saved", Toast.LENGTH_SHORT).show();
                editor.putString("data",title_message);
                editor.apply();

                startActivity(new Intent(AddNewActivity.this, MyListsActivity.class));
                finish();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddNewActivity.this, MyListsActivity.class));
                finish();
            }
        });


    }
}