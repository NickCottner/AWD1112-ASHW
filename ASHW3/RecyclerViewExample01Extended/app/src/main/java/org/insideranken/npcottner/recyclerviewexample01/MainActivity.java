package org.insideranken.npcottner.recyclerviewexample01;

/*
        An Android RecyclerView is an advanced version of
        an Android ListView.
        A RecyclerView is used to show data in the form of
        a scrollable list. It is therefore a ViewGroup used
        to display a large set of data.
        For each item in a dataset, it displays a View.
        A RecyclerView is an efficient way to implement a
        scrollable list in a Vertical, Horizontal, Grid,
        staggered, or customized layout.
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IndLanguageInterface {
    ArrayList<languageModel> languageModel = new ArrayList<>();
    languageRecyclerAdapter adapter;
    int[] languageImages =
            {
                    R.drawable.android,
                    R.drawable.bootstrap,
                    R.drawable.csharp,
                    R.drawable.css3,
                    R.drawable.git,
                    R.drawable.github,
                    R.drawable.html5,
                    R.drawable.java,
                    R.drawable.javascript,
                    R.drawable.jquery,
                    R.drawable.json,
                    R.drawable.kotlin,
                    R.drawable.mongodb,
                    R.drawable.mysql,
                    R.drawable.nodejs,
                    R.drawable.react
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView languageRv = findViewById(R.id.rvProgramming);
        setLanguageModel();

        adapter = new languageRecyclerAdapter(this, languageModel, this);
        languageRv.setAdapter(adapter);
        languageRv.setLayoutManager(new LinearLayoutManager(this));
    }
    public void setLanguageModel()
    {
        String[] languageName = getResources().getStringArray(R.array.language_name);
        String[] languageYear = getResources().getStringArray(R.array.language_year);
        String[] languageDescription = getResources().getStringArray(R.array.language_description);

        for(int lcv = 0; lcv < languageName.length;++lcv)
        {
            languageModel.add(new languageModel(
                    languageName[lcv],
                    languageYear[lcv],
                    languageDescription[lcv],
                    languageImages[lcv]));
        }
    }
    @Override
    public void onItemClick(int position) {
        Intent indIntent = new Intent(this, IndividualLanguage.class);

        indIntent.putExtra("NAME", languageModel.get(position).getName());
        indIntent.putExtra("YEAR", languageModel.get(position).getYear());
        indIntent.putExtra("DESCRIPTION", languageModel.get(position).getDescription());
        indIntent.putExtra("IMAGE", languageModel.get(position).getImageId());

        startActivity(indIntent);
    }
}