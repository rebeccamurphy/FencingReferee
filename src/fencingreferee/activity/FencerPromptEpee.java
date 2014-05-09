package fencingreferee.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import fencing.referee.R;

public class FencerPromptEpee extends Activity{
	private Spinner fencerSelecter;
	private Button btnSubmit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.fencer_prompt_epee);
		
		addListenerOnButton();
	}
	public void addListenerOnButton(){
		fencerSelecter = (Spinner) findViewById(R.id.FencerSpinner);
		btnSubmit = (Button) findViewById(R.id.submit_btn);
		
		btnSubmit.setOnClickListener(new OnClickListener() {

			  @Override
			  public void onClick(View v) {
				if (String.valueOf(fencerSelecter.getSelectedItem()).equals("Right Fencer") ){
					fencing.referee.data.MatchInfo.rightFencer = true;
					
				}
				else if (String.valueOf(fencerSelecter.getSelectedItem()).equals("Left Fencer")){
					fencing.referee.data.MatchInfo.leftFencer = true;
				}
				else if (String.valueOf(fencerSelecter.getSelectedItem()).equals("Both hit at same time")){
					fencing.referee.data.MatchInfo.bothFencer = true;
				}
				Intent createIntent = new Intent(getApplicationContext(), BodyPartSelect.class);
				startActivity(createIntent);
		
			  }

			});
		  }
}

