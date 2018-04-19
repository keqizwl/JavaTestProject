import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopTest {

	public static void main(String[] args) {
		TestClass testclass= new TestClass();
		
		InvocationHandler invocationHandler = new InvocationHandler() {
			
			TestClass testclass = new TestClass();
			
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("before method");
				return method.invoke(testclass, args);
			}
		};
		Object obj = Proxy.newProxyInstance(AopTest.class.getClassLoader(), TestClass.class.getInterfaces(), invocationHandler);
		((TestInterface)obj).show("hello");
	}
	
	static interface TestInterface{
		void show(String arg);
	}
	
	static class TestClass implements TestInterface{

		@Override
		public void show(String arg) {
			System.out.println(arg);
		}
		
	}
}
