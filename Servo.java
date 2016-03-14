
import rxtxrobot.*;
public class Servo {
	
	public static void main (String[] args) {
	RXTXRobot r = new ArduinoUno();
	r.setPort("COM3");
	r.setVerbose(true);
	r.connect();
	r.attachServo(RXTXRobot.SERVO1,7);
	r.moveServo(RXTXRobot.SERVO1,130);
	r.sleep(1000);
	//r.moveServo(RXTXRobot.SERVO1,0);	
	r.close();
	}
}
