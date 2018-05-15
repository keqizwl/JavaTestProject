package designpattern.test;

public class BridgeTest {

	
	//ICar接口可以独立演变
	interface ICar{
		void run();
		void fly();
		void swim();
	}
	
	static class Car implements ICar{
		IWheelMaker wheelMaker;

		@Override
		public void run() {
			
		}

		@Override
		public void fly() {
			
		}

		@Override
		public void swim() {
			
		}
	}
	//car类体系可以独立演变
	static class SpecailCar extends Car{
		IWheelMaker wheelMaker;
		
		public void sing() {
			
		}
		
		
	}
	
	//真正的实现部分也可以独立演变
	interface IWheelMaker{
		void makeWheel();
	}
}
