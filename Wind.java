import rxtxrobot.*;
public class Wind {
	static RXTXRobot r = new ArduinoUno();
	
	
	
	public static double getThermistorReading1(){
		int sum = 0;
		int readingCount = 10;
		
		for(int i = 0; i < readingCount; i++){
			r.refreshAnalogPins(); 
			int reading = r. getAnalogPin(4).getValue();
			sum += reading;
		}
		
	return sum/readingCount;
	}
	public static double getThermistorReading2(){
		int sum = 0;
		int readingCount = 10;
		
		for(int i = 0; i < readingCount; i++){
			r.refreshAnalogPins(); 
			int reading = r. getAnalogPin(5).getValue();
			sum += reading;
		}
	return sum/readingCount;
	}
	
	
	public static double translate(double a){
		double slope = -7.609540636;
		double intercept = 735.8162544;

		return (a-intercept)/slope;
		
	}

	public static void main (String[] args){
		
	
		r.setPort("COM3");
		r.connect();
		
		for (int i = 0; i< 50; i ++){
		double thermistorReading1 = getThermistorReading1();
		double thermistorReading2 = getThermistorReading2();
		
		/*
		System.out.println("The probe read the value:" + thermistorReading);
		System.out.println("In volts:" + (thermistorReading * (5/1023)));
		*/
		double difference = translate(thermistorReading1) - translate(thermistorReading2);
		System.out.println("In Temperature1: " + translate(thermistorReading1));
		System.out.println("In Temperature2: " + translate(thermistorReading2)); 
		System.out.println("In Temperature: " + difference+"\n");
		
		
		}
		
		r.close();
	}
}

