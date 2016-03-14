
import rxtxrobot.*;
public class Demo {
	final private static int PING_PIN = 5;

	public static void main(String[] args) {
		RXTXRobot r = new ArduinoUno(); // Create RXTXRobot object 
		r.setPort("COM3"); // Set port to COM2 
		r.connect(); 
	
	
		for (int x=0; x < 10; ++x) 
		{ 
			r.refreshDigitalPins();
			//Read the ping sensor value, which is connected to pin 12 
			float ping = r.getPing(PING_PIN);
			System.out.println("Response: " + ping + " cm"); 
			r.sleep(300); 
		} 
		r.close(); 
	}

}
