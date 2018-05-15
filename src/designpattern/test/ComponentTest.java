package designpattern.test;

import java.util.ArrayList;
import java.util.List;

public class ComponentTest {

	public static void main(String[] args) {
		Compontent com = new Leaf();
		Composite comsite = new Composite();
		comsite.addCompontent(com);
		Compontent coms = comsite;
		
		coms.operate();
	}
	
	interface Compontent{
		void operate();
	}
	
	static class Leaf implements Compontent{

		@Override
		public void operate() {
			System.out.println("leaf operate");
		}
		
	}
	
	static class Composite implements Compontent{
		private List<Compontent> coms;

		@Override
		public void operate() {
			System.out.println("Composite operate");
			for(Compontent com : coms) {
				com.operate();
			}
		}
		
		void addCompontent(Compontent com){
			if(coms == null) {
				coms = new ArrayList<>();
			}
			
			coms.add(com);
		}
		
		Compontent childAt(int index) {
			if(coms == null || coms.size() <= index || index < 0) {
				return null;
			}
			
			return coms.get(index);
		}
	}
}
