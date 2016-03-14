import rxtxrobot.*;
import rxtxrobot.RXTXRobot;

public class test {

	
	public static void main (String[] args){
		
		RXTXRobot r = new ArduinoUno();
		r.setPort("COM3");
		r.connect();
	
		AnalogPin ping = r.getAnalogPin(3);
		r.refreshAnalogPins(); // Cache the Analog pin information 
		 


		for (int x=0; x < 20; ++x) 
		{ 
			r.refreshAnalogPins(); 	
	
			int bump = ping.getValue(); 
		
			System.out.println("Bump is " + bump);
			r.sleep(500);
				
			}
		
		r.close();
		} 
		
		

	}

