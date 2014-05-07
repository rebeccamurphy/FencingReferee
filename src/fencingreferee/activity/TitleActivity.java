package fencingreferee.activity;


import fencing.referee.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;


public class TitleActivity extends Activity {
	
	private Button btnFoil, btnEpee, btnSaber, btnQuit;
	private OnClickListener notAvail = new OnClickListener(){
		@Override
		public void onClick(View v){
			Toast.makeText(TitleActivity.this, "Feature not yet implmented", Toast.LENGTH_SHORT).show();
		}
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_title);
		fencing.referee.data.MatchInfo.reset();
		addListenerOnButtons();
	}
	
	public void addListenerOnButtons(){
		btnFoil = (Button) findViewById(R.id.foil_btn);
		btnEpee = (Button) findViewById(R.id.epee_btn);
		btnSaber = (Button) findViewById(R.id.saber_btn);
		btnQuit = (Button) findViewById(R.id.quit_btn);
		
		btnFoil.setOnClickListener(notAvail);
		btnSaber.setOnClickListener(notAvail);
		

		btnEpee.setOnClickListener(new OnClickListener(){
			 @Override
			  public void onClick(View v) {
				 fencing.referee.data.MatchInfo.epeeSelect = true;
						Intent createIntent = new Intent(getApplicationContext(), FencerPromptEpee.class);
						startActivity(createIntent);

			  }
		});
		
		btnQuit.setOnClickListener(new OnClickListener(){
			 @Override
			  public void onClick(View v) {
				finish();
			  }
		});
	}



}
