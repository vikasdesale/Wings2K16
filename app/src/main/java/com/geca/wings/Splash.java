package com.geca.wings;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;


public class Splash extends Activity {


	
	@Override
	protected void onCreate(Bundle vrockskbh) {
		// TODO Auto-generated method stub
		super.onCreate(vrockskbh);

		setContentView(R.layout.splash);
		ImageView iv= (ImageView) findViewById(R.id.content);

		Thread timer = new Thread() {

			@Override
			public void run() {
				try {

					sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {

					Intent openMain= new Intent(Splash.this,com.geca.wings.MainActivity.class);

					startActivity(openMain);
					finish();
				}
			}

		};
		timer.start();
	}


}
