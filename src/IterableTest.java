import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;

public class IterableTest {

	public static void main(String[] args) {
		
		Thread myThread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				throw new IllegalStateException("uncaught exception");
			}
		});
		Thread myThread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				throw new IllegalStateException("uncaught exception");
			}
		});
		
		myThread1.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("catched by local handler");
				
			}
		});
		
		Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("catched by default handler");
			}
		});
		
		myThread1.start();
		myThread2.start();
		
		
		
		
		
		
		
//		List<Integer> list = new ArrayList<>();
//		list.add(1);
//		list.add(3);
//		list.add(4);
//		list.add(121);
//		list.add(11);
//		list.add(1131456);
//		
//		list.forEach(new Consumer<Integer>() {
//
//			@Override
//			public void accept(Integer t) {
//				System.out.println(t);
//			}
//		});
//		
//		new Thread(new MyTask()).start();
//		
		
//		ArrayList<String> a = new ArrayList<>();
//		a.add("afa");
//		a.add("gag");
//		a.add("r");
//		a.add("h");
//		a.add("gaf");
//		
//		ArrayList<String> b = (ArrayList<String>) a.clone();
//		
//		b.forEach(new Consumer<String>() {
//
//			@Override
//			public void accept(String arg0) {
//				System.out.println(arg0);
//			}
//		});
//		Iterator<String> iterator = b.iterator();
//		if(iterator != null) {
//			while(iterator.hasNext()) {
//				String value = iterator.next();
//				System.out.println(value);
//				iterator.remove();
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		sb.append("b.size = ").append(b.size());
//		System.out.println(sb);
//		SortedSet<String> set = new TreeSet<>();
//		set.addAll(b);
	}
	
	
	public static class MyTask implements Runnable{

		@Override
		public void run() {
			int[] a = new int[] {1,23,1313,1,31,3,13};
			int[] b = a.clone();
			
			for(int x : b) {
				System.out.println(x);
			}
		}
	}
	
	public class Brick{
		int i;
		int j;
		int level;
		
		public Brick(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		public void setLevel(int level) {
			this.level = level;
		}
	}
	
    public static int[] hitBricks(int[][] grid, int[][] hits) {
    	
    	
    	return new int[] {1,2};
    }
}
