package com.example.todo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MyListsActivity extends AppCompatActivity {

    FloatingActionButton newList, delete;
    ListView toDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_lists);

        SharedPreferences sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        String title_message = sharedPreferences.getString("data", String.valueOf(MODE_PRIVATE))+"";

        toDoList = findViewById(R.id.ToDoList);
        newList = findViewById(R.id.floatingActionButton);
        delete = findViewById(R.id.floatingActionButton2);

        int n=0;
        for (int i=0; i<title_message.length(); i++)    {if(title_message.charAt(i)=='~') n+=1;}

        n=0;
        final String[] dataArray= title_message.split("~");


        String[]  splitted = new String[2];

        for(int i=0; i<dataArray.length; i++)
        {splitted = dataArray[i].split("`");
        dataArray[i] = splitted[0];}


        newList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(MyListsActivity.this, AddNewActivity.class));
                finish();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("data",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(v.getContext());
                passwordResetDialog.setTitle("CLEAR ALL ?");
                passwordResetDialog.setMessage("Once cleared, it can't be undone");
                passwordResetDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {   editor.putString("data","");
                        editor.apply();
                        startActivity(new Intent(MyListsActivity.this, MyListsActivity.class));
                        finish();
                    }});

                passwordResetDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {@Override   public void onClick(DialogInterface dialog, int which){}});
                passwordResetDialog.create().show();
            }
        });

        toDoList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MyListsActivity.this, ViewPaneActivity.class);
                intent.putExtra("index", position);
                startActivity(intent);
                //finish();
            }
        });



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MyListsActivity.this, android.R.layout.simple_dropdown_item_1line,dataArray);
        toDoList.setAdapter(adapter);
    }
}