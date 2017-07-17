
public class TrackerManager implements Runnable{
	LightControl l;
	boolean on = true;
	
	public TrackerManager(LightControl lightControl){
		l = lightControl;
		
	}
	
	public void turnOff(){
		on = false;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean previousState = l.getCircuitState();
		while(on){
			
		}
	}

}
