package designpattern.test;

import java.util.ArrayList;

public class ProtoTypeTest {

	public static void main(String[] args) {
		ArrayList<String> arr = new ArrayList<>();
		arr.add("hello");
		arr.add("hello");
		arr.add("hello");
		arr.add("hello");
		arr.add("hello");
		arr.add("hello");

		System.out.println(arr.clone());
	}
}
