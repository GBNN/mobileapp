package com.dl.dralayout;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {
	private static final long tiempo = 5500;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		
	TimerTask splash= new TimerTask() {
			
			@Override
			public void run() {
				Intent action = new Intent(getApplication(),Main.class);
				startActivity(action);
				finish();
			}
		};
		
		Timer timer = new Timer();
        timer.schedule(splash, tiempo);
		
		
		
	}
}
