package com.temicanada.swisschalet;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.robotemi.sdk.Robot;
import com.robotemi.sdk.listeners.OnRobotReadyListener;

public class MainActivity extends AppCompatActivity implements OnRobotReadyListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView simpleVideoView = (VideoView) findViewById(R.id.videoView); // initiate a video view
        simpleVideoView.setVideoURI(Uri.parse("android.resource://com.temicanada.swisschalet/" + R.raw.swiss_chalet));

        MyMediaController mediaController = new MyMediaController(this);
        mediaController.setAnchorView(simpleVideoView);
        mediaController.setMediaPlayer(simpleVideoView);
        simpleVideoView.setMediaController(mediaController);

        simpleVideoView.canPause();
        simpleVideoView.canSeekForward();
        simpleVideoView.canSeekBackward();
        simpleVideoView.getDuration();
        simpleVideoView.isPlaying();

        // perform set on prepared listener event on video view
        simpleVideoView.setOnPreparedListener(mp -> {
            simpleVideoView.start();
// do something when video is ready to play

        });
    }

    @Override
    public void onRobotReady(boolean b) {
            Robot.getInstance().hideTopBar();
    }
}