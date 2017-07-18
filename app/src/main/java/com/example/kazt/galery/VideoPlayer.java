package com.example.kazt.galery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    VideoView vvPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        vvPlayer = (VideoView) findViewById(R.id.vv_player);
        String path = getIntent().getStringExtra("video");
        vvPlayer.setVideoPath(path);
        vvPlayer.setMediaController(new MediaController(this));
        vvPlayer.requestFocus();
        vvPlayer.start();
    }
}
