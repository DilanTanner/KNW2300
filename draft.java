import rxtxrobot.*;

public class draft {
	final private static int PING_PIN = 6;
	static RXTXRobot r = new ArduinoUno();
	static boolean stop = false;
	public static float getPing() {
		for (int x=0; x < 10; ++x) 
		{ 
			r.refreshDigitalPins();
			//Read the ping sensor value, which is connected to pin 12 
			float ping = r.getPing(PING_PIN);
			r.sleep(300); 
		} 
	return ping;
	}
public static int getBumper (int Pin){  
	AnalogPin ping = r.getAnalogPin(Pin);
	r.refreshAnalogPins(); // Cache the Analog pin information 
	// for (int x=0; x < 20; ++x) 
		// { 
			r.refreshAnalogPins(); 	
			int bump = ping.getValue(); 
			r.sleep(500);
			return bump;
		// }
	} 	
public static double getThermistorReading2(int pin){
	int sum = 0;
	int readingCount = 10;
	for(int i = 0; i < readingCount; i++)
		{
			r.refreshAnalogPins(); 
			int reading = r. getAnalogPin(pin).getValue();
			sum += reading;
		}
	return sum/readingCount;
	}
public static void measureWind (int Pin1, int Pin2){
	for (int i = 0; i< 50; i ++){
		double WthermistorReading1 = getThermistorReading(5);
		double WthermistorReading2 = getThermistorReading2(6);
		/*
		System.out.println("The probe read the value:" + thermistorReading);
		System.out.println("In volts:" + (thermistorReading * (5/1023)));
		*/
		double difference = translate(WthermistorReading1) - translate(WthermistorReading2);
		System.out.println("In Temperature1: " + translate(WthermistorReading1));
		System.out.println("In Temperature2: " + translate(WthermistorReading2)); 
		System.out.println("In Temperature: " + difference+"\n");
		}
	}
		// Temperature
public static int getThermistorReading(int Pin){
	int sum = 0;
	int readingCount = 10;
	for(int i = 0; i < readingCount; i++)
		{
			r.refreshAnalogPins(); 
			int reading = r. getAnalogPin(Pin).getValue();
			sum += reading;
		}
	return sum/readingCount;
	}
public static double translate(double a)
	{
		double slope = -7.609540636; //to be modified
		double intercept = 735.8162544; //to be modified
		return (a-intercept)/slope;
	}
public static void measureTemp (int Pin)
	{
	for(int i = 0; i < 50; i++)	
	{
		int thermistorReading = getThermistorReading(Pin);
		System.out.println("In Temperature: " + translate(thermistorReading));
		r.sleep(100);
	}
}
		//motor
public static void runMotor (int Pin1, int Pin2, int speed1, int speed2, int time)
{
	r.attachMotor(RXTXRobot.MOTOR1, Pin1);
	r.attachMotor(RXTXRobot.MOTOR2, Pin2);
	r.runMotor(RXTXRobot.MOTOR1, speed1, RXTXRobot.MOTOR2, speed2, time);
	r.refreshAnalogPins(); // Cache the Analog pin information 
		/*
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
		*/
}
public static void runServo (int Pin, int rate) 
{
	r.setVerbose(true);
	r.attachServo(RXTXRobot.SERVO1,Pin);
	r.moveServo(RXTXRobot.SERVO1,rate);
	r.sleep(1000);
	//r.moveServo(RXTXRobot.SERVO1,0);	
}
static void turnRight(){
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 140, RXTXRobot.MOTOR2, 255, 140);
		//r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, 200, 1400);
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
static void turnRight(){
		r.runEncodedMotor(RXTXRobot.MOTOR1, 255, 140, RXTXRobot.MOTOR2, 255, 140);
		//r.runMotor(RXTXRobot.MOTOR1, 200, RXTXRobot.MOTOR2, 200, 1400);
	}
static void turnLeft(){
		r.runEncodedMotor(RXTXRobot.MOTOR1, -255, 150, RXTXRobot.MOTOR2, -255, 150);
		//r.runMotor(RXTXRobot.MOTOR1, -200, RXTXRobot.MOTOR2, -200, 1395);
		
	}
static void Stop(){
		r.runEncodedMotor(RXTXRobot.MOTOR1, 0, 0, RXTXRobot.MOTOR2, 0, 0);
		//r.runMotor(RXTXRobot.MOTOR1, 0, RXTXRobot.MOTOR2, 0, 0);
		
	}
static void Move(int a){
		r.runEncodedMotor(RXTXRobot.MOTOR1, -255, a, RXTXRobot.MOTOR2, 225, a);
		//r.runMotor(RXTXRobot.MOTOR1, -255, RXTXRobot.MOTOR2, 225, a);
	}
static void MoveE(){
		r.runMotor(RXTXRobot.MOTOR1, -255, RXTXRobot.MOTOR2, 225, 0);	
	}
public static void main (String[] args) 
{
	r.setPort("COM3");
	r.connect();
	r.attachMotor(RXTXRobot.MOTOR1, 9);
	r.attachMotor(RXTXRobot.MOTOR2, 8);
	r.close();
}
}
