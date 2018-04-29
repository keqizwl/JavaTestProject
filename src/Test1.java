import java.io.IOException;

public class Test1 {

	public static void main(String[] args) {
		try {
			Runtime.getRuntime().exec("cd");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		
		
		
		Thread thread  = new Thread(new Runnable() {
			ThreadLocal<MyClass> myLocal = new ThreadLocal<MyClass>() {
				@Override
				protected MyClass initialValue() {
					return new MyClass(11);
				}
			};
			InheritableThreadLocal<MyClass> myLocal1 = new InheritableThreadLocal<MyClass>() {
				@Override
				protected MyClass initialValue() {
					return new MyClass(22);
				}
			};
			
			@Override
			public void run() {
				System.out.println(myLocal.get().toString());
				System.out.println(myLocal1.get().toString());
				myLocal.get().a = 1;
				myLocal1.get().a = 11;
				Thread thread1 = new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println(myLocal.get().toString());
						System.out.println(myLocal1.get().a);
					}
				});
				thread1.start();
			}
		});
		thread.start();
	}
	
	public static class MyClass{
		int a;
		
		public MyClass(int a) {
			this.a = a;
		}
	}
}
