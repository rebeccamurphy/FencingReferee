package fencingreferee.activity;

import fencing.referee.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

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
		
		addListenerOnButton();
		 if (fencing.referee.data.MatchInfo.rightFencer)
			 Toast.makeText(getApplicationContext(), "Enter where Right Hit", Toast.LENGTH_SHORT).show();
		  else if (fencing.referee.data.MatchInfo.leftFencer)
			  Toast.makeText(getApplicationContext(), "Enter where Left Hit", Toast.LENGTH_SHORT).show();
		  else if (fencing.referee.data.MatchInfo.bothFencer && fencing.referee.data.MatchInfo.numHits >0)
			  Toast.makeText(getApplicationContext(), "Enter where Right Hit", Toast.LENGTH_SHORT).show();
		  else if (fencing.referee.data.MatchInfo.bothFencer && fencing.referee.data.MatchInfo.numHits <=0){
			  //alert "Judging Next Hit"
			  Toast.makeText(getApplicationContext(), "Now Enter Left Hit", Toast.LENGTH_SHORT).show();
		  }
	}
	
	public void addListenerOnButton(){
		bodyPartSelecter = (Spinner) findViewById(R.id.BodyPartSpinner);
		btnSubmit = (Button) findViewById(R.id.submit_btn);
		
		btnSubmit.setOnClickListener(new OnClickListener() {

			  @Override
			  public void onClick(View v) {
				  if (fencing.referee.data.MatchInfo.rightFencer)
					  judgement("Right");
				  else if (fencing.referee.data.MatchInfo.leftFencer)
					  judgement("Left");
				  else if (fencing.referee.data.MatchInfo.bothFencer && fencing.referee.data.MatchInfo.numHits >0)
					  judgement("Both"); 
				  else if (fencing.referee.data.MatchInfo.bothFencer && fencing.referee.data.MatchInfo.numHits <0){
					  fencing.referee.data.MatchInfo.numHits++;
					  //alert "Judging Next Hit"
					  //Toast.makeText(getApplicationContext(), "Now enter Left Hit", Toast.LENGTH_SHORT).show();
					  selectNext();
				  }
					  
				  
			  }

			});
		  }
	
	public void reset(){
		finish();
		Intent createIntent = new Intent(getApplicationContext(), TitleActivity.class);
		startActivity(createIntent);
	}
	public void selectNext(){
		finish();
		Intent createIntent = new Intent(getApplicationContext(), BodyPartSelect.class);
		startActivity(createIntent);
	}
	
	public void judgement(String fencerAttacking)
	{
		if (fencing.referee.data.MatchInfo.epeeSelect)
			epeeJudgeDialog(fencerAttacking);
		else {
				
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
			else if(String.valueOf(bodyPartSelecter.getSelectedItem()).equals("Hand")){
				
			}
			else if(String.valueOf(bodyPartSelecter.getSelectedItem()).equals("Leg")){
				
			}
			else if (String.valueOf(bodyPartSelecter.getSelectedItem()).equals("Foot")){
				
			}
		 
		}
	}
	public void epeeJudgeDialog(String fencerAttacking){
		AlertDialog.Builder judgement = new AlertDialog.Builder(BodyPartSelect.this);
		judgement.setTitle("Who won?");
		if (fencing.referee.data.MatchInfo.leftFencer || fencing.referee.data.MatchInfo.rightFencer )
			judgement.setMessage(fencerAttacking + " gets a point because everywhere is a legal hit in Epee!");
		else if (fencing.referee.data.MatchInfo.bothFencer)
			judgement.setMessage(fencerAttacking + " get a point because everywhere is a legal hit in Epee, and when both fencers hit at the same time they both get a point.");
		
		judgement.setPositiveButton("Judge again?", new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int whichButton) {
		    	reset();
		    }
	    });
		judgement.setNegativeButton("Quit App?", new DialogInterface.OnClickListener() {
			   public void onClick(DialogInterface dialog, int whichButton) {
				   finish();
			   }
		   });
		judgement.create().show();	


	}
}

