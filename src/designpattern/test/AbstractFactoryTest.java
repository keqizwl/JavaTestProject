package designpattern.test;

public class AbstractFactoryTest {

	public static void main(String[] args) {
		ICarFactory iCarFactory = new ConcretCarFactory();
		iCarFactory.getWheel(1);
		iCarFactory.getSteeringWheel(1);
	}

	
	public interface ICarFactory{
		Wheel getWheel(int type);
		SteeringWheel getSteeringWheel(int type);
	}
	
	static class Wheel{
		
	}
	
	static class  SteeringWheel{
		
	}
	
	public static class ConcretCarFactory implements ICarFactory{

		@Override
		public Wheel getWheel(int type) {
			return new Wheel();
		}

		@Override
		public SteeringWheel getSteeringWheel(int type) {
			return new SteeringWheel();
		}
		
	}
}
