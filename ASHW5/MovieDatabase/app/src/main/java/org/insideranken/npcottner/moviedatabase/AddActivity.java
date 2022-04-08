package org.insideranken.npcottner.moviedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText movie_title;
    EditText movie_director;
    EditText movie_length;
    Button btnAddMovie;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        movie_title = findViewById(R.id.add_movie_title);
        movie_director = findViewById(R.id.add_movie_director);
        movie_length = findViewById(R.id.add_movie_length);
        btnAddMovie = findViewById(R.id.btnAddMovie);

        btnAddMovie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(AddActivity.this);
                myDB.AddMovie(movie_title.getText().toString().trim(),
                        movie_director.getText().toString().trim(),
                        movie_length.getText().toString().trim());
            }
        });
    }
}