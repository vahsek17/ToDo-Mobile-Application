package com.example.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class ViewPaneActivity extends AppCompatActivity {

    TextView paneTitle, paneTextMessage;
    ImageButton imageButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pane);
        paneTitle = findViewById(R.id.PaneTitle);
        paneTextMessage = findViewById(R.id.PaneTextMessage);
        imageButton= findViewById(R.id.Lists);
        paneTitle.setEnabled(false);
        paneTextMessage.setEnabled(false);
        String title ="", message ="";

        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        String title_message = sharedPreferences.getString("data", String.valueOf(MODE_PRIVATE))+"";


        Intent intent = getIntent();
        int index = intent.getIntExtra("index",0);

        String[] Title_Message_Array =  title_message.split("~");
        String[] thisMessage = Title_Message_Array[index].split("`");

        title = thisMessage[0];
        message = thisMessage[1];

        paneTitle.setText(title);
        paneTextMessage.setText(message);
    }
}