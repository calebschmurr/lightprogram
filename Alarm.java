import java.util.Calendar;

public class Alarm {

	public static final int stateOn = 1;
	public static final int stateOff = 0;
	public static final int stateSnooze1 = 2;
	public static final int stateWentOff = 3;
	
	public static final int typeWakeUp = 1;
	public static final int typeDefault = 0;
	
	private int state;
	private int type;
	
	private int hour;
	private int minute;
	private String message;
	
	
	public Alarm(){
		state = Alarm.stateOn;
	}
	
	public Alarm(int hour, int minute, int type, int state){
		this.hour = hour;
		this.minute = minute;
		this.type = type;
		this.state = state;
	}
	
	public Alarm(int hour, int minute, int type, String message){
		this.hour = hour;
		this.minute = minute;
		this.type = type;
		this.state = Alarm.stateOn;
		this.message = message;
	}
	public Alarm(int hour, int minute, int type){
		this.hour = hour;
		this.minute = minute;
		this.type = type;
		this.state = Alarm.stateOn;
		this.message = "";
	}
	
	public void setAlarm(){
		
	}
	
	public boolean shouldActivate(){
		Calendar c = Calendar.getInstance();
		if(c.get(Calendar.HOUR_OF_DAY)==hour){
			if(c.get(Calendar.MINUTE)==minute){
				return true;
			}
		}
		return false;
	}
	
	public void turnOn(){
		state = Alarm.stateOn;
	}
	public void turnOff(){
		state = Alarm.stateOff;
	}
	
	public void setState(int state){
		this.state = state;
	}
	
	public String getMessage(){
		return message;
	}
	public int getState(){
		return state;
	}

	public int getType(){return type;}
	
	//Prints the alarm in a format for AlarmHandler class
	public String print(){
		String output = "";
		output+= hour+":"+minute+" ";
		if(state == Alarm.stateOn)
			output+="on, ";
		else
			output+="off, ";
		output+=message;
		
		return output;
	}
}
