
public class fakeLightControl implements LightControlInterface{
	boolean lightStatus = false;
	
	public fakeLightControl(){
		
	}
	public void toggleLight(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lightStatus = !lightStatus;
		System.out.println("Light toggled");
	}
	
	public boolean getCircuitState(){
		return lightStatus;
	}
	
}
