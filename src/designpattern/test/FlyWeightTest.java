package designpattern.test;

import java.util.ArrayList;
import java.util.List;

public class FlyWeightTest {

	public static void main(String[] args) {

	}

	static class FlyWeight {
		int key;

		void operate() {

		}
	}

	static class FlyWeightA extends FlyWeight {

		public FlyWeightA() {
			key = 1;
		}
	}

	static class FlyWeightB extends FlyWeight {
		public FlyWeightB() {
			key = 2;
		}
	}

	static class FlyWeightFactory {
		private static List<FlyWeight> list = new ArrayList<>();

		public static FlyWeight getFlyWeigtByType(int type) {
			for (FlyWeight fly : list) {
				if (fly.key == type) {
					return fly;
				}
			}

			switch (type) {
			case 1:
				return new FlyWeightA();
			case 2:
				return new FlyWeightB();
			}

			return null;
		}
	}
}
