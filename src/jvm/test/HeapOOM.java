package jvm.test;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while(true) {
			list.add(new OOMObject());
		}
	}
	
	static class OOMObject{
		
	}

}
