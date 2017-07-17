import java.util.Scanner;
import java.lang.System;

public class Light {

	AlarmHandler alarmHandler;
	LightControl lightControl;
	Scanner in;
	boolean on = true;
	
	public Light(){
		initializeVariables();
		System.out.println(alarmHandler.printAlarms());
		
		alarmHandler.start();
		//lightControl.toggleLight();
	}
	
	private void initializeVariables(){
		lightControl = new LightControl();
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
