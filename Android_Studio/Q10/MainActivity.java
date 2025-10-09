package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView l;
    ImageView v;

    // List of image names
    String[] img = {"Image 1", "Image 2", "Image 3", "Image 4"};

    // Corresponding drawable resources
    int[] image = {
            R.drawable.fp1,
            R.drawable.fp2,
            R.drawable.fp3,
            R.drawable.fp4,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l = findViewById(R.id.list);
        v = findViewById(R.id.iv);

        // Create adapter for list items
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                img
        );

        // Set adapter to ListView
        l.setAdapter(adapter);

        // Handle click events
        l.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        // Set the selected image in the ImageView
        v.setImageResource(image[i]);
    }
}
