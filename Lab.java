import rxtxrobot.*;

public class Lab {
	static boolean stop = false;
	
	static RXTXRobot r = new ArduinoUno();
	final private static int PING_PIN = 7;
	
	/*
	final private static int Con_PIN1 = 12;
	final private static int Con_PIN2 = 13;
	*/
	static public void main(String[] args){
		r.setPort("COM3");
		r.connect();
		
		r.attachMotor(RXTXRobot.MOTOR1,5);//L
		r.attachMotor(RXTXRobot.MOTOR2,6);//Right
		r.attachServo(RXTXRobot.SERVO1,11);//Hand
		r.attachServo(RXTXRobot.SERVO2,10);//conductor
		
		

		
		
	
		/*
		
		MoveE();
		int bump = 1200;
		while(bump>=1000) 
		{ 
			r.refreshAnalogPins();
	
			bump = r.getAnalogPin(3).getValue(); 
		
				System.out.println("Bump is " + bump);
			
			if( bump <= 1000){
				Stop();	
				r.close();
				return;
			} 	
		}
		
		r.sleep(3000);
		
		stop = false;
		turnA();
		MoveE();
		while(!stop){
			float distance = Sense();
			if (distance <= 80){
				Stop();
				stop = true;
				
			}
		}
		
		r.sleep(3000);
		turnRight();
		r.sleep(3000);
		

		stop = false;
		MoveE();
		while(!stop){
			float distance = Sense();
			if (distance <= 20){
				Stop();
				stop = true;
				
			}
		}
		
		r.sleep(3000);
		turnLeft();
		r.sleep(3000);
		
		MoveE();
		int bump2 = 1200;
		while(bump2>=1000) 
		{ 
			r.refreshAnalogPins();
	
			bump2 = r.getAnalogPin(3).getValue(); 
		
				System.out.println("Bump is " + bump);
			
			if( bump2 <= 1000){
				Stop();	
				r.close();
				return;
			} 	
		}
		
		
		*/
		
		
		//Move(2000);
		//turnLeft();
		//r.runMotor(RXTXRobot.MOTOR1, 100, 1500);
		 
		
		
		/*
		Move(4500);
		r.sleep(4000);
		turnRight();
		r.sleep(4000);
		
		Move(0);
		while(!stop){
			float distance = Sense();
			if (distance <= 50){
				Stop();
				stop = true;
			}
		}
		*/
		/*
		Climb(2500);
		r.sleep(4000);
		up();
		r.sleep(4000);
		Temp();
		r.sleep(4000);
		Wind();
		r.sleep(4000);
		down();
		r.sleep(4000);
		Move(2500);
		
		*/
	
		while(!stop){
			float distance = Sense();
			if (distance <= 10){
				stop = true;
				
			}
			r.sleep(100);
		}
		
		/*
		while(!stop){
			float distance = Sense();
			if (distance <= 50){
				stop = true;
				Stop();
				
			}
		}
		*/
		
		
		
		r.close();
		
		 }
	
			
			
		
	

	
	static void MoveE(){
		r.runMotor(RXTXRobot.MOTOR1, 140, RXTXRobot.MOTOR2, -110, 0);
	}
	
	
	static void Move(int a){
		//r.runEncodedMotor(RXTXRobot.MOTOR1, 149, a, RXTXRobot.MOTOR2, -130, a);
		r.runMotor(RXTXRobot.MOTOR1, 150, RXTXRobot.MOTOR2, -105, a);
	}
	
	static void BackE(){
		//r.runEncodedMotor(RXTXRobot.MOTOR1, -149, a, RXTXRobot.MOTOR2, 130, a);
		r.runMotor(RXTXRobot.MOTOR1, -155, RXTXRobot.MOTOR2, 138, 0);
	}
	
	static void Climb(int a){
		r.runMotor(RXTXRobot.MOTOR1, 255, RXTXRobot.MOTOR2, -210, a);
		
	}
	
	static void Stop(){
		//r.runEncodedMotor(RXTXRobot.MOTOR1, 0, 0, RXTXRobot.MOTOR2, 0, 1);
		r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);
		
	}
	
	static void turnLeft(){
		//r.runEncodedMotor(RXTXRobot.MOTOR1, 155, 1, RXTXRobot.MOTOR2, -155, 120);
		//r.runMotor(RXTXRobot.MOTOR1, 1, );
		r.runMotor(RXTXRobot.MOTOR2, -155, 1200);
	}
	
	static void turnRight(){
		//r.runEncodedMotor(RXTXRobot.MOTOR1, 155, 100, RXTXRobot.MOTOR2, 155, 1 );
		//r.runMotor(RXTXRobot.MOTOR1, -200, 0);
		r.runMotor(RXTXRobot.MOTOR1, 155, 1300);
	}
	
	static void turnA(){
		turnRight();
		r.sleep(300);
		turnRight();
	}

	static void Nav(){
		while (!stop){
			MoveE();
			
			float distance = Sense();
			System.out.println("Bump is " + distance);
			if(distance <= 150){
				Move(10);
				if (distance <= 80){
					Stop();
					stop = true;
				}
			}
				
			
		
		
		 }
}
	
	static float Sense(){
		float ping = 0;
			//r.refreshDigitalPins();
			//Read the ping sensor value, which is connected to pin 12 
			ping = r.getPing(PING_PIN);
			System.out.println("Response: " + ping + " cm");  
	return ping;	
	}
	
	
	static void Cond(){
		boolean in = true;
		for(int i = 0;i< 10;i++){
		double adc = r.getConductivity();
		double con = (-0.0701*adc) + 21.169;
		System.out.println("Response: " + con + " %H2O");
		}
		
	}
	
	
	static void Avoid(){
	
		
		Stop();
		r.sleep(300);
		turnRight();
		r.sleep(300);
		Move(1000);
		r.sleep(300);
		turnLeft();
		r.sleep(300);
		Move(2079);
		r.sleep(300);
		turnLeft();
		r.sleep(300);
		Move(1000);
		r.sleep(300);
		turnRight();
		r.sleep(300);
		Move(1000);
		
	}
	
	static void For(){
		r.moveServo(RXTXRobot.SERVO2,15);
	}
	
	
	static void up(){
		for(int i = 0; i< 105; i++){
			r.moveServo(RXTXRobot.SERVO1,179);
			}
	}
	static void down(){
		for(int i = 0; i< 85; i++){
			r.moveServo(RXTXRobot.SERVO1,1);
			}
	}
	
	static void Temp(){
		for(int i = 0; i < 10; i++){
			double thermistorReading = getThermistorReading1();
			System.out.println("In Temperature: " + translate(thermistorReading));
			}
	}
	
	
	static double translate(double a){
		double slope = -7.609540636;
		double intercept = 735.8162544;

		return ((a-intercept)/slope)+2;
		
	}
	
	static double getThermistorReading1(){
		int sum = 0;
		int readingCount = 10;
		
		for(int i = 0; i < readingCount; i++){
			r.refreshAnalogPins(); 
			int reading = r. getAnalogPin(1).getValue();
			sum += reading;
		}
		return sum/readingCount;
	}
	
	static double getThermistorReading2(){
		int sum = 0;
		int readingCount = 10;
		
		for(int i = 0; i < readingCount; i++){
			r.refreshAnalogPins(); 
			int reading = r. getAnalogPin(0).getValue();
			sum += reading;
		}
	return sum/readingCount;
	}
	
	static void Wind(){
		for (int i = 0; i< 10; i ++){
			double thermistorReading1 = getThermistorReading1();
			double thermistorReading2 = getThermistorReading2();
			/*
			System.out.println("The probe read the value:" + thermistorReading);
			System.out.println("In volts:" + (thermistorReading * (5/1023)));
			*/
			double difference = translate(thermistorReading2) - translate(thermistorReading1);
			System.out.println("In Temperature1: " + translate(thermistorReading1));
			System.out.println("In Temperature2: " + translate(thermistorReading2)); 
			System.out.println("In Temperature: " + difference+"\n");		
			}
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

