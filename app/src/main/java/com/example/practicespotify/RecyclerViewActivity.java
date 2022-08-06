package com.example.practicespotify;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DbMyHelper db;
    RecyclerAdapter adapter;
    ArrayList<String> title,artist;
    ArrayList<Integer> img;
    Button btn3;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        db = new DbMyHelper(this);
        db.insertuserdata("drivers_license","Olivia Rodrigo",R.drawable.drivers_license,"drivers_license");
        db.insertuserdata("jealousy","Olivia Rodrigo",R.drawable.jealousy,"jealousy");
        db.insertuserdata("good_for_u","Olivia Rodrigo",R.drawable.good_for_u,"good_for_u");
        db.insertuserdata("happier","Olivia Rodrigo",R.drawable.drivers_license,"happier");
        /*db.insertuserdata("enna_sona","Ok Jaanu",R.drawable.enna_sona,"enna_sona");
        db.insertuserdata("sun_sathiya","ABCD 2",R.drawable.sun_sathiya,"sun_sathiya");
        db.insertuserdata("willow","Taylor Swift",R.drawable.willow,"willow");*/
        recyclerView = findViewById(R.id.recyclerview);


        Intent i = getIntent();
        code = i.getStringExtra("btn");
        if(code.equals("btn1")){
            updatelist();
        }
        else{
            updatelist2();
        }




    }

    public void updatelist(){

        /*title.clear();
        artist.clear();
        img.clear();*/

        ArrayList<String> title2 = new ArrayList<>();
        ArrayList<String> artist2 = new ArrayList<>();
        ArrayList<Integer> img2 = new ArrayList<>();
        title2.add("sun_sathiya");
        title2.add("enna_sona");
        title2.add("willow");
        artist2.add("ABCD 2");
        artist2.add("Ok Jaanu");
        artist2.add("Taylor Swift");
        img2.add(R.drawable.sun_sathiya);
        img2.add(R.drawable.enna_sona);
        img2.add(R.drawable.willow);
        /*title.addAll(title2);
        artist.addAll(artist2);
        img.addAll(img2);*/
        adapter = new RecyclerAdapter(RecyclerViewActivity.this,title2,artist2,img2);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
    public void updatelist2(){
        title = new ArrayList<>();
        artist = new ArrayList<>();
        img = new ArrayList<>();
        adapter = new RecyclerAdapter(this,title,artist,img);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        displayData();

    }


    private void displayData() {
        Cursor c = db.getdata();
        if(c.getCount()==0){
            Toast.makeText(this,"No Entry exist",Toast.LENGTH_LONG).show();
            return;
        }
        else {
            while (c.moveToNext()){
                title.add(c.getString(0));
                artist.add(c.getString(1));
                img.add(c.getInt(2));
            }
        }
    }
}