package designpattern.test;

import java.util.ArrayList;
import java.util.List;

//操作尝试者
public class VisitorTest {

	public static void main(String[] args) {
		//元素
		List<MyElement> elements = new ArrayList<>();
		elements.add(new ElementOne());
		elements.add(new ElementTwo());
		//操作
		Operate operate = new OperateAdd();
		//尝试操作
		for(MyElement element : elements) {
			element.accept(operate);
		}
	}
	
	interface Operate{
		
	}
	
	final static class OperateAdd implements Operate{
		int add(int a, int b) {
			return a + b;
		}
	}
	
	interface MyElement{
		void accept(Operate operate);
	}
	
	static class ElementOne implements MyElement{
		int a;
		int b;
		
		@Override
		public void accept(Operate operate) {
			System.out.println("ElementOne accept");
			if(operate instanceof OperateAdd) {
				((OperateAdd) operate).add(a, b);
			}
		}
	}
	
	static class ElementTwo implements MyElement{
		String a;
		String b;
		
		@Override
		public void accept(Operate operate) {
			System.out.println("ElementTwo not accept");
		}
	}
}
