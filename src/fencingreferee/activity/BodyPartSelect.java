package fencingreferee.activity;

import fencing.referee.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;

public class BodyPartSelect extends Activity{
	
	private Spinner bodyPartSelecter;
	private Button btnSubmit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.body_part_select);

		
	}
	
	public void addListenerOnButton(){
		bodyPartSelecter = (Spinner) findViewById(R.id.BodyPartSpinner);
		btnSubmit = (Button) findViewById(R.id.submit_btn);
		
		btnSubmit.setOnClickListener(new OnClickListener() {

			  @Override
			  public void onClick(View v) {
				if (String.valueOf(bodyPartSelecter.getSelectedItem()).equals("Head") ){
					//Intent createIntent = new Intent(getApplicationContext(), );
					//startActivity(createIntent);
				}
				else if (String.valueOf(bodyPartSelecter.getSelectedItem()).equals("Torso")){
					
				}
				else if (String.valueOf(bodyPartSelecter.getSelectedItem()).equals("Waist")){
					
				}
				else if(String.valueOf(bodyPartSelecter.getSelectedItem()).equals("Arm")){
					
				}
				else if(String.valueOf(bodyPartSelecter.getSelectedItem()).equals("Leg")){
					
				}
				else if (String.valueOf(bodyPartSelecter.getSelectedItem()).equals("Foot")){
					
				}
		
			  }

			});
		  }
		
}

