package py.com.misgruposv01.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import py.com.misgruposv01.R;

public class SplashActivity extends Activity {

	private final int DURACION_SPLASH = 3000;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.activity_splash);

		new Handler().postDelayed(new Runnable(){
			public void run(){
				Intent intent = new Intent(py.com.misgruposv01.activities.SplashActivity.this, BitacorasListView.class);
				startActivity(intent);
				desplegarMensaje();
				finish();
			};
		}, DURACION_SPLASH);
	}


	public void desplegarMensaje() {
		Toast toast = Toast.makeText( this, "Inicio exitoso", Toast.LENGTH_SHORT);
		toast.show();
	}

}