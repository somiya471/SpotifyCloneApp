package com.example.practicespotify;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Home_fragment extends Fragment {
    ImageButton btn2,btn1;



    public Home_fragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        btn1 = view.findViewById(R.id.imageButton);
        btn2 = view.findViewById(R.id.imageButton2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getActivity(),RecyclerViewActivity.class);
                intent3.putExtra("btn","btn1");
                startActivity(intent3);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),RecyclerViewActivity.class);
                intent.putExtra("btn","btn2");
                startActivity(intent);
            }
        });



        return view;

    }
}