package designpattern.test;

public class BridgeTest {

	
	//ICar�ӿڿ��Զ����ݱ�
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
	//car����ϵ���Զ����ݱ�
	static class SpecailCar extends Car{
		IWheelMaker wheelMaker;
		
		public void sing() {
			
		}
		
		
	}
	
	//������ʵ�ֲ���Ҳ���Զ����ݱ�
	interface IWheelMaker{
		void makeWheel();
	}
}
