package com.example.viveknew;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity{

	MediaPlayer ourSong;
	
	@Override
	protected void onCreate(Bundle VivekKumar) {
		// TODO Auto-generated method stub
		super.onCreate(VivekKumar); 
		setContentView(R.layout.splash);
		ourSong= MediaPlayer.create(Splash.this, R.raw.titanic_new_version);
		ourSong.start();
		Thread timer=new Thread(){
			public void run(){
				try{
					sleep(3000);
				} catch(InterruptedException e) {
					e.printStackTrace();
				}finally {
					Intent openMainActivity= new Intent("com.example.viveknew.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
