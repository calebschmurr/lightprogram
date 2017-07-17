
import java.util.Scanner;

public class CommandInterpreter {
	
	public static void interpret(String input, AlarmHandler alarmHandler, LightControlInterface lightControl, boolean on, Scanner in){
		if (input.contains("off"))
			on = false;
		else if(input.contains("alarm")){
			if(input.contains("add")){
				alarmHandler.addAlarmFromCommandPrompt(in);}
			if(input.contains("list")){
				System.out.println(alarmHandler.printAlarms());
			}
			if(input.contains("remove")||input.contains("delete")){
				System.out.print("Which alarm do you want to remove?");
				alarmHandler.removeAlarm(in.nextInt());
			}
			if(input.contains("help")){
				System.out.print("Commands List: \ntoggle light - toggles light. \noff - shuts down program.");
			}
		}
		else if(input.contains("light")){
			if(input.contains("toggle")){
				if(input.contains("-t")){
					int time = 0;
					Scanner in2 = new Scanner(input.substring(input.indexOf("-t")));//Makes a new scanner for the string that now only contains the time parameters
					System.out.println(input.substring(input.indexOf("-t")));
					while(!in2.hasNextInt()){ //Finds the point where the first number is located for time
						in2.next();
					}
					
					while(in2.hasNext()){//Following algorithm is supposed to check for a letter following a number, and then determine if it is minutes, seconds, hours.  Then add that to the time.
						int tempTime = in2.nextInt();
						if(in2.hasNext()){
							char letter = in2.next().toLowerCase().charAt(0);
							if(letter == 'm')
								time+= tempTime*60;
							if(letter == 's'){
								time+= tempTime;
							}
							if(letter == 'h'){
								time+= tempTime*3600;
							}
						}else{
							time += tempTime;
						}
					}
					DelayedLightToggle toggle = new DelayedLightToggle(time, lightControl);
					toggle.initiate();
					in2.close();
				}else{
				lightControl.toggleLight();
				}
			}
		if(input.contains("status")||input.contains("state")){
			if(lightControl.getCircuitState())
				System.out.print("Light state is on.\n");
			else
				System.out.print("Light state is off.\n");
			}
		}
		else if(input.contains("help")||input.contains("listcommands")){
		System.out.print("Commands:\ntoggle light\ntoggle light -t (time)\nadd alarm\nlist alarm\noff\n");
	}
		
	else if(!input.isEmpty()){
		System.out.print("Command not understood.  Type 'help' for command list.\n");
	}
	}	
}