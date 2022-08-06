package com.example.practicespotify;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Library_fragment extends Fragment {


    public Library_fragment() {
        // Required empty public constructor
    }
    ImageButton btn3,btn4,btn2;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_library_fragment, container, false);
        btn3 = view.findViewById(R.id.imageButton14);
        btn4 = view.findViewById(R.id.imageButton15);
        btn2 = view.findViewById(R.id.imageButton13);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(),RecyclerViewActivity.class);
                intent3.putExtra("btn","btn1");
                startActivity(intent3);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RecyclerViewActivity.class);
                intent.putExtra("btn","btn2");
                startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getActivity(),SongPlayActivity.class);
                intent2.putExtra("title","enna_sona");
                intent2.putExtra("artist","Ok Jaanu");
                intent2.putExtra("image",R.drawable.enna_sona);
                startActivity(intent2);
            }
        });





        return view;
    }
}