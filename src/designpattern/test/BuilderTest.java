package designpattern.test;


/**
 * 
 * ������ģʽ��
 * �������������������϶࣬����ߺ��ڻ�����һЩ�����Ϊ�˼����ϵĴ���ĸĶ����ɿ���ʹ��builderģʽ��������
 * ��չ������
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
