import rxtxrobot.*;
public class kind {
	public static void main (String[] args){
		RXTXRobot r = new ArduinoUno();
		r.setPort("COM3");
		r.setVerbose(true);
		r.connect();
		r.attachServo(RXTXRobot.SERVO1,9);
		r.sleep(1000);
		r.moveServo(RXTXRobot.SERVO1,160);
		r.sleep(1000);
		r.moveServo(RXTXRobot.SERVO1,10);
		r.sleep(1000);
		r.moveServo(RXTXRobot.SERVO1,150);
		r.sleep(1000);
		r.moveServo(RXTXRobot.SERVO1,10);
		r.sleep(1000);
		r.moveServo(RXTXRobot.SERVO1,180);
		r.sleep(1000);
		r.moveServo(RXTXRobot.SERVO1,0);
		r.sleep(1000);
		r.moveServo(RXTXRobot.SERVO1,90);
		
		
		r.close();
		
	}
}
