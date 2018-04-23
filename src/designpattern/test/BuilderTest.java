package designpattern.test;


/**
 * 
 * 构建者模式，
 * 构建对象可自由配置项较多，亦或者后期会新增一些配置项，为了减少老的代码的改动，可考虑使用builder模式构建对象
 * 扩展兼容性
 * @author Administrator
 *
 */
public class BuilderTest {
	
	public static void main(String[] args) {
		MyClass.Builder builder = new MyClass.Builder(1,2,3)
				.ab(1, 2);
		MyClass myclass = builder.build();
	}
	
	static class MyClass{
		int x,y,z,a,b;
		
		static class Builder{
			private int a,b;
			
			Builder(int x, int y, int z){
				
			}
			
			Builder ab(int a, int b) {
				this.a = a;
				this.b = b;
				return this;
			}
			
			MyClass build(){
				MyClass myClass = new MyClass();
				myClass.a = a;
				myClass.b = b;
				return myClass;
			}
		}
	}

}
