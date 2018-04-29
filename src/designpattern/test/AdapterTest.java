package designpattern.test;

public class AdapterTest {

	//һ���Ǵ洢�Ľӿ����Ʋ�ͬ��������ͬ
	public static void main(String[] args) {
		LocalFlyAdapter localFlyAdapter = new LocalFlyAdapter();
		localFlyAdapter.fly();
	}
	
	public static class OldClass{
		public void fei() {
			System.out.println("������");
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
