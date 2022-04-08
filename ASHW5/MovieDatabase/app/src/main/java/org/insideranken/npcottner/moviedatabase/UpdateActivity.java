package org.insideranken.npcottner.moviedatabase;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;

public class UpdateActivity extends AppCompatActivity {

    EditText update_title, update_director, update_length;
    Button btnUpdateMovie, btnDeleteMovie;
    String id, title, director, length;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        update_title = findViewById(R.id.update_movie_title);
        update_director = findViewById(R.id.update_movie_director);
        update_length = findViewById(R.id.update_movie_length);
        btnUpdateMovie = findViewById(R.id.btnUpdateMovie);
        btnDeleteMovie = findViewById(R.id.btnDeleteMovie);

        getAndSetIntentData();
        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle(title);
        }

        btnUpdateMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.updateData(id, title, director, length);
            }
        });
        btnDeleteMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });



    }
    void getAndSetIntentData()
    {
        if(getIntent().hasExtra("id") && getIntent().hasExtra("title") &&
            getIntent().hasExtra("director") && getIntent().hasExtra("length"))
        {
            //Getting Data From Intent
            id = getIntent().getStringExtra("id");
            title = getIntent().getStringExtra("title");
            director = getIntent().getStringExtra("director");
            length = getIntent().getStringExtra("length");

            //Setting Intent Data
            update_title.setText(title);
            update_director.setText(director);
            update_length.setText(length);
        }
        else
        {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }
    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + title + " ?");
        builder.setMessage("Are you sure you want to delete " + title + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}