package me.oneyoung.wheelplayer;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.media.MediaPlayer;

public class MusicPlayerService extends Service {
    private MediaPlayer mPlayer;

    public MusicPlayerService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mPlayer = new MediaPlayer();
    }

    @Override
    public void onDestroy() {
        mPlayer.release();
        mPlayer = null;
        super.onDestroy();
    }

    public class ServiceBinder extends Binder {
        public MediaPlayer getPlayer() {
            return MusicPlayerService.this.mPlayer;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }
}