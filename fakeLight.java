import java.util.Scanner;

public class fakeLight {
	AlarmHandler alarmHandler;
	fakeLightControl lightControl;
	Scanner in;
	boolean on = true;
	
	public fakeLight(){
		initializeVariables();
		System.out.println(alarmHandler.printAlarms());
		
		alarmHandler.start();
		//lightControl.toggleLight();
	}
	
	private void initializeVariables(){
		lightControl = new fakeLightControl();
		alarmHandler = new AlarmHandler(lightControl);
		in = new Scanner(System.in);
	}
	
	public void loop(){
		String input;
		while(on){
			System.out.print(">");
			input = in.nextLine().toLowerCase();
			if(input.contains("off")||input.contains("exit")||input.contains("quit")){System.exit(0);}
			
			CommandInterpreter.interpret(input, alarmHandler, lightControl, on, in);
		}
		
		System.exit(0);
	}
	



	
}
