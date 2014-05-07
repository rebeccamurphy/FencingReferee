package fencing.referee.data;

import android.app.Application;

public class MatchInfo extends Application {
	public static boolean foilSelect=false, epeeSelect=false, saberSelect = false;
	public static boolean rightFencer=false, leftFencer=false, bothFencer = false;
	public static int numHits =0;
	
	public static void reset(){
		foilSelect=false; epeeSelect=false; saberSelect = false;
		rightFencer=false; leftFencer=false; bothFencer = false;
		numHits =0;
	} 
}
