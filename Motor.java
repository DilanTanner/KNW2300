import rxtxrobot.*;

public class Motor {

	
	public static void main (String[] args){
		
		RXTXRobot r = new ArduinoUno();
		r.setPort("COM3");
		r.connect();
	
		r.attachMotor(RXTXRobot.MOTOR1, 9);
		r.attachMotor(RXTXRobot.MOTOR2, 8);
		
		r.runMotor(RXTXRobot.MOTOR1, -250, RXTXRobot.MOTOR2, 255, 0);
		
		
	
		r.refreshAnalogPins(); // Cache the Analog pin information 
		
		
		int bump = 1200;
		while(bump>=1000) 
		{ 
			r.refreshAnalogPins();
	
			bump = r.getAnalogPin(3).getValue(); 
		
				System.out.println("Bump is " + bump);
			
			if( bump <= 1000){
				r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);	
				r.close();
				return;
			} 	
			}		
	

	
		
		r.close();
	}
}
