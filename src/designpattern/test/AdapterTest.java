package designpattern.test;

public class AdapterTest {

	//一种是存储的接口名称不同，含义相同
	public static void main(String[] args) {
		LocalFlyAdapter localFlyAdapter = new LocalFlyAdapter();
		localFlyAdapter.fly();
	}
	
	public static class OldClass{
		public void fei() {
			System.out.println("飞起来");
		}
	}
	
	public interface IFly{
		void fly();
	}
	
	public static class LocalFlyAdapter implements IFly{
		public OldClass oldClass = new OldClass();
		
		@Override
		public void fly() {
			oldClass.fei();
		}
	}
}
