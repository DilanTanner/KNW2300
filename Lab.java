import rxtxrobot.*;

public class Lab {
	static boolean stop = false;
	
	static RXTXRobot r = new ArduinoUno();
	final private static int PING_PIN = 6;

	static public void main(String[] args){
		r.setPort("COM3");
		r.connect();
		
		r.attachMotor(RXTXRobot.MOTOR1, 9);
		r.attachMotor(RXTXRobot.MOTOR2, 8);//left
		
		// straight
		
		
		//Move(100);
		/*
		while(!stop){
			MoveE();
			float distance = Sense();
			if (distance <= 30){
				stop = true;
			}
		}*/
		/*
		for (int i = 0; i < 4; i++){
			turnRight();
			r.sleep(300);
		}
		*/
		
		Move(500);
		/*
		while (!stop){
			MoveE();
			float distance = Sense();
				if (distance <= 30){
					Avoid();
					MoveE();
				}
				if (distance <= 50){
					Stop();
					stop = true;
				}
			}
				
		*/
		r.close();
		
	}
	
	static void MoveE(){
		r.runMotor(RXTXRobot.MOTOR1, -255, RXTXRobot.MOTOR2, 225, 0);	
	}
	
	static void Move(int a){
		r.runEncodedMotor(RXTXRobot.MOTOR1, -255, a, RXTXRobot.MOTOR2, 225, a);
		//r.runMotor(RXTXRobot.MOTOR1, -255, RXTXRobot.MOTOR2, 225, a);
	}
	
	static void Stop(){
		r.runEncodedMotor(RXTXRobot.MOTOR1, 0, 0, RXTXRobot.MOTOR2, 0, 0);
		//r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);
		
	}
	
	
	
	static void turnLeft(){
		r.runEncodedMotor(RXTXRobot.MOTOR1, -255, 150, RXTXRobot.MOTOR2, -255, 150);
		//r.runMotor(RXTXRobot.MOTOR1, -200, RXTXRobot.MOTOR2, -200, 1395);
		
	}
	
	static void turnRight(){
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 140, RXTXRobot.MOTOR2, 255, 140);
		//r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, 200, 1400);
	}
	
	static float Sense(){
		float ping = 0;
			r.refreshDigitalPins();
			//Read the ping sensor value, which is connected to pin 12 
			ping = r.getPing(PING_PIN);
			System.out.println("Response: " + ping + " cm");  
	return ping;	
	}
	
	static void Avoid(){
		Stop();
		r.sleep(300);
		turnRight();
		r.sleep(300);
		Move(5000);
		r.sleep(300);
		turnLeft();
		r.sleep(300);
		Move(8000);
		r.sleep(300);
		turnLeft();
		r.sleep(300);
		Move(5000);
		r.sleep(300);
		turnRight();
		r.sleep(300);
		
	}
}

/*
static float obst(){
		
		r.refreshDigitalPins();
		//Read the ping sensor value, which is connected to pin 12 
		float ping = r.getPing(PING_PIN);
		System.out.println("Response: " + ping + " cm"); 
		r.sleep(300); 
	
		return ping;
}
}
*/
/*
static void avoid(){
	
}

static float moved(){
	
	
	
}

*/

