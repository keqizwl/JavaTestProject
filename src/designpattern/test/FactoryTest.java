package designpattern.test;

public class FactoryTest {
	public static void main(String[] args) {
		
	}
	
	interface Shape{
		void draw();
	}
	
	static class Circle implements Shape{

		@Override
		public void draw() {
			System.out.println("draw circle");
		}
		
	}
	
	static class Line implements Shape{
		
		@Override
		public void draw() {
			System.out.println("draw Line");
		}
		
	}
	
	public static class ShapeFactory{
		public static Shape createShare(int type) {
			switch (type) {
			case 0:
				return new Circle();

			default:
				return new Line();
			}
		}
	}
}
