import rxtxrobot.*;

public class draft {
	final private static int PING_PIN = 5;
	static RXTXRobot r = new ArduinoUno();
	public static void getPing() {
		for (int x=0; x < 10; ++x) 
		{ 
			r.refreshDigitalPins();
			//Read the ping sensor value, which is connected to pin 12 
			float ping = r.getPing(PING_PIN);
			System.out.println("Response: " + ping + " cm"); 
			r.sleep(300); 
		} 
	}
public static void getDumper (int Pin){
	AnalogPin ping = r.getAnalogPin(Pin);
	r.refreshAnalogPins(); // Cache the Analog pin information 
	for (int x=0; x < 20; ++x) 
		{ 
			r.refreshAnalogPins(); 	
			int bump = ping.getValue(); 
			System.out.println("Bump is " + bump);
			r.sleep(500);
		}
	} 	
public static double WgetThermistorReading1(){ //Wind
	int sum = 0;
	int readingCount = 10;
	for(int i = 0; i < readingCount; i++)
		{
			r.refreshAnalogPins(); 
			int reading = r. getAnalogPin(4).getValue();
			sum += reading;
		}
		return sum/readingCount;
	}
public static double WgetThermistorReading2(){
	int sum = 0;
	int readingCount = 10;
	for(int i = 0; i < readingCount; i++)
		{
			r.refreshAnalogPins(); 
			int reading = r. getAnalogPin(5).getValue();
			sum += reading;
		}
	return sum/readingCount;
	}
public static double Wtranslate(double a){
	double slope = -7.609540636;
	double intercept = 735.8162544;
	return (a-intercept)/slope;
	}
public static void measureWind (int Pin1, int Pin2){
	for (int i = 0; i< 50; i ++){
		double WthermistorReading1 = WgetThermistorReading1();
		double WthermistorReading2 = WgetThermistorReading2();
		/*
		System.out.println("The probe read the value:" + thermistorReading);
		System.out.println("In volts:" + (thermistorReading * (5/1023)));
		*/
		double difference = Wtranslate(WthermistorReading1) - Wtranslate(WthermistorReading2);
		System.out.println("In Temperature1: " + Wtranslate(WthermistorReading1));
		System.out.println("In Temperature2: " + Wtranslate(WthermistorReading2)); 
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
public static double translate(int a)
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
public static void main (String[] args) 
{
	r.setPort("COM3");
	r.connect();
	r.close();
}
}
