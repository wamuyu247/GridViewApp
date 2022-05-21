package com.example.gridviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gvGallery;
    private GridBaseAdapter gridBaseAdapter;
    private ArrayList<ImageModel> imageModelArrayList;

    private int[] myImageList = new int[]{
         R.drawable.benz,
         R.drawable.bike,
         R.drawable.car,
         R.drawable.carrera,
         R.drawable.ferrari,
         R.drawable.harly,
         R.drawable.lamborghini,
         R.drawable.silver
    };

    private  String[] myImageNameList = new String[]{
         "Benz",
         "Bike",
         "Car",
         "Carrera",
         "Ferrari",
         "Harly",
         "Lamborghini",
         "Silver"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gvGallery = findViewById(R.id.gv);
        imageModelArrayList = populateList();

        gridBaseAdapter = new GridBaseAdapter(getApplicationContext(),imageModelArrayList);
        gvGallery.setAdapter(gridBaseAdapter);

        gvGallery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, myImageNameList[position] + "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private ArrayList<ImageModel> populateList(){

        ArrayList<ImageModel> list = new ArrayList<>();
        for (int i = 0;i < 8;i ++){
            ImageModel imageModel = new ImageModel();
            imageModel.setName(myImageNameList[i]);
            imageModel.setImage_drawable(myImageList[i]);
            list.add(imageModel);
        }

        return list;
    }
}