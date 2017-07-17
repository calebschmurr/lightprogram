import java.util.ArrayList;
import java.util.Scanner;

public class AlarmHandler implements Runnable{

	private ArrayList<Alarm> list;
	private LightControlInterface controller;
	private Thread t;
	
	public AlarmHandler(LightControlInterface lightController){
		list = new ArrayList<Alarm>();
		controller = lightController;
	}
	
	public void addAlarmFromCommandPrompt(Scanner in){
		System.out.print("What alarm time :: ");
		String timeString = in.nextLine();
		int hour = Integer.parseInt(timeString.substring(0, timeString.lastIndexOf(':')));
		int minute = Integer.parseInt(timeString.substring(timeString.lastIndexOf(':')+1));
		
		System.out.print("Message :: ");
		String message = in.nextLine();
		System.out.print("Is this the wake-up alarm? (Y/N)::");
		char yn = in.next().toLowerCase().charAt(0);
		int type = Alarm.typeDefault;
		if(yn == 'y'){
			type=Alarm.typeWakeUp;
		}
		addAlarm(hour,minute,type,message);
		
	}
	
	public void addAlarm(int hour, int minute, int type, String message){
		list.add(new Alarm(hour, minute, type, message));
	}
	public void removeAlarm(int alarmNumber){
		list.remove(alarmNumber-1);
	}
	
	public Alarm checkAlarms(){
		for(Alarm a : list){
			if (a.shouldActivate()){
				return a;
			}
		}
		//System.out.println("alarms checked");
		return null;
	}
	
	public String printAlarms(){
		String output = "";
		for (int x = 1; x<= list.size(); x++){
			output+=x+". ";
			output+=list.get(x-1).print();
			output+="\n";
		}
		
		return output;
	}
	
	public ArrayList<Alarm> getAlarmList(){
		return list;
	}

	@Override
	public void run() {
		
		while(true){
		Alarm al = checkAlarms();
		if(al!=null){
			if(al.getState()==Alarm.stateOn){
			System.out.println("Alarm off - " + al.getMessage());
			if(al.getType()==Alarm.typeWakeUp)
				controller.toggleLight();
			al.setState(Alarm.stateWentOff);
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	}
	
	public void start(){
		if(t==null){
			t = new Thread(this, "alarmHandler");
			t.start();
			//System.out.println("Thread started");
		}
	}
	
}
