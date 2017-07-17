

public class DelayedLightToggle implements Runnable{
	int time;
	LightControlInterface lightController;
	
	private Thread t;
	
	public DelayedLightToggle(int seconds, LightControlInterface lightControl){
		time = seconds;
		lightController = lightControl;
		System.out.println("Light set to toggle in "+ Tools.secondsToTime(time)+ "("+time+" seconds).");
	}
	public void initiate(){
		t = new Thread(this, "delayedLightX");
		t.start();
		
	}
	
	public void run(){
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lightController.toggleLight();
		System.out.println("Light Toggled.\n");
	}
}
