package jvm.test;

import jvm.test.HeapOOM.OOMObject;

public class JavaVMStackSOF {

	public static void main(String[] args) {
		JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
		try {
			javaVMStackSOF.stackLeak();
		}catch (Exception e) {
			System.out.println("stack length:" + javaVMStackSOF.stackLength);
			throw e;
		}
	}
	
	private int stackLength = -1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
}
