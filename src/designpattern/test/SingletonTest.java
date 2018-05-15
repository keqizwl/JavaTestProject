package designpattern.test;

public class SingletonTest {

	
	public static void main(String[] args) {
		MySingletonClass.getsInstance().show();
	}
	
	
	static class MySingletonClass{
		private volatile static MySingletonClass sInstance;
		
		public static MySingletonClass getsInstance() {
			if(sInstance == null) {
				synchronized (MySingletonClass.class) {
					if(sInstance == null) {
						sInstance = new MySingletonClass();
					}
				}
			}
			
			return sInstance;
		}
		
		public void show() {
			System.out.println("show");
		}

		private MySingletonClass() {
			
		}
	}
}
