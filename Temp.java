import rxtxrobot.*;
public class Temp {
	static RXTXRobot r = new ArduinoUno();
	
		public static int getThermistorReading(){
			int sum = 0;
			int readingCount = 10;
			
			for(int i = 0; i < readingCount; i++){
				r.refreshAnalogPins(); 
				int reading = r. getAnalogPin(5).getValue();
				sum += reading;
			}
		return sum/readingCount;
		}
		
		public static double translate(int a){
			double slope = -7.609540636;
			double intercept = 735.8162544;

			return (a-intercept)/slope;
			
		}
	
		public static void main (String[] args){
			
		
			r.setPort("COM3");
			r.connect();
			
			for(int i = 0; i < 50; i++){
			int thermistorReading = getThermistorReading();
			System.out.println("In Temperature: " + translate(thermistorReading));
			r.sleep(100);
			}
			
			
			r.close();
		}
	}

