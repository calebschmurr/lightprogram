import java.util.Calendar;

public class TrackerToggleEvent {
	static final int turnedOn = 1;
	static final int turnedOff = 0;
	
	Calendar c;
	int stateChange;
	
	public TrackerToggleEvent(int change){
		c = Calendar.getInstance();
		stateChange = change;
	}
	
	public Calendar getTime(){
		return c;
	}
	
	public int getstateChange(){
		return stateChange;
	}
	
	@SuppressWarnings("deprecation")
	public String toString(){
		String output = "";
		output+="Light was ";
		if(stateChange==turnedOn){
			output+="turned on at ";
		}else if(stateChange==turnedOff){
			output+="turned off at ";
		}
		output+=c.getTime().getHours();
		output+=":"+c.getTime().getMinutes()+":"+c.getTime().getSeconds()+" ";
		output+="on "+c.getTime().getMonth()+"-"+c.getTime().getDay()+"-"+c.getTime().getYear()+".";
		return output;
	}
	
	
}
