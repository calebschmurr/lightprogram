import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.platform.Platform;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.platform.PlatformManager;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.Console;
import com.pi4j.util.ConsoleColor;

public class LightControl implements LightControlInterface{
	
	private final GpioPinDigitalOutput outPin;
	private final GpioPinDigitalInput inPin;
	
	public LightControl(){
	
	//final Console console = new Console();
	//console.title(arg0)
	
	final GpioController gpio = GpioFactory.getInstance();
	
	outPin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, PinState.LOW);
	inPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_03, PinPullResistance.OFF);
	
	outPin.setShutdownOptions(true, PinState.LOW);
	
	}
	
	public void toggleLight(){
		outPin.high();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		outPin.low();
		System.out.println("Light toggled");
	}
	
	public GpioPinDigitalInput getInPin(){
		return inPin;
	}
	public boolean getCircuitState(){
		return inPin.getState().isHigh();
	}
	
}
