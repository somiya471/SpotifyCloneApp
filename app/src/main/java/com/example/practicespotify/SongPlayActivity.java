package com.example.practicespotify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class SongPlayActivity extends AppCompatActivity {
    TextView title_set,artist_set;
    ImageView image;
    Button playbtn,pausebtn,stopbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_play);


        Intent i = getIntent();
        String title = i.getStringExtra("title");
        String artist = i.getStringExtra("artist");
        int img = i.getIntExtra("image",0);

        title_set = findViewById(R.id.title_set);
        artist_set = findViewById(R.id.artist_set);
        image = findViewById(R.id.albumimage);

        title_set.setText(title);
        artist_set.setText(artist);
        image.setImageResource(img);

        playbtn = findViewById(R.id.play);
        pausebtn = findViewById(R.id.pause);
        stopbtn = findViewById(R.id.songstop);

        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String apath = "android.resource://"+getPackageName()+"/raw/"+title;
        Uri audio = Uri.parse(apath);
        try {
            mediaPlayer.setDataSource(this,audio);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });
        pausebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        stopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
        });



    }
}