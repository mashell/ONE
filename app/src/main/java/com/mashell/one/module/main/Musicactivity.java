package com.mashell.one.module.main;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.mashell.one.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by mashell on 16/12/14.
 * Email: mashell624@163.com
 * GitHub: https://github.com/mashell
 */

public class MusicActivity extends Activity {
    @BindView(R.id.start)
    ImageView startButton;
    @BindView(R.id.pause)
    ImageView pauseButton;
    @BindView(R.id.stop)
    ImageView stopButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_activity);
        ButterKnife.bind(this);
        mediaPlayer = MediaPlayer.create(this,R.raw.test);

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {//播出完毕事件
            @Override
            public void onCompletion(MediaPlayer arg0) {
                mediaPlayer.release();
            }
        });

        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                mediaPlayer.release();
                return false;
            }
        });
    }

    @OnClick({R.id.start,R.id.pause,R.id.stop})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.start:
                mediaPlayer.start();//开始或恢复播放
                break;

            case R.id.pause:
                mediaPlayer.pause();//暂停播放
                break;

            case R.id.stop:
                mediaPlayer.reset();     //重置MediaPlayer
                mediaPlayer.release();
                break;
        }
    }
}
