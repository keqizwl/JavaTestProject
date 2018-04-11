import java.util.Arrays;
import java.util.Iterator;

public class CloneComprableTest {

	public static class MyClass implements Comparable<MyClass>{
		int a;
		String b;
		
		public MyClass(int a, String b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(MyClass o) {
			if(o == null) {
				throw new NullPointerException();
			}
			
			return a > o.a ? 1 : (a == o.a ? 0 : -1);
		}
	}
	
	public static void main(String[] args) {
		MyClass[] arr = new MyClass[] {new MyClass(1, ""),
				new MyClass(3, ""),
				new MyClass(2, ""),
				new MyClass(4, ""),
				new MyClass(-2, "")};
		
		MyClass[] arr2 = arr.clone();
		Arrays.sort(arr2);
		
		for(MyClass myClass : arr) {
			System.out.println(myClass.a);
		}
		System.out.println("------------------------------------");
		for(MyClass myClass : arr2) {
			System.out.println(myClass.a);
		}
	}
	
	

}
