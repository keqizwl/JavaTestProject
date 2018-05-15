package designpattern.test;

public class DecoratorTest {
	
	public static void main(String[] args) {
		Decorator decorator = new DecoratorA(new ConcreteCompontent(), 2);
		decorator.operate();
	}
	
	interface Compontent{
		void operate();
	}

	static class ConcreteCompontent implements Compontent{

		@Override
		public void operate() {
			System.out.println("ConcreteCompontent operate");
		}
		
	}
	
	
	static class Decorator implements Compontent{
		protected Compontent com;
		
		public Decorator(Compontent com) {
			this.com = com;
		}
		
		public void operate() {
			com.operate();
		}
	}
	
	static class DecoratorA extends Decorator{
		int state;
		
		public DecoratorA(Compontent com,int state) {
			super(com);
			this.state = state;
		}

		public void operate() {
			System.out.println("DecoratorA operate before state = " + state);
			super.operate();
			System.out.println("DecoratorA operate state = " + state);
		}
		
		public int getState() {
			return state;
		}
	}
}
