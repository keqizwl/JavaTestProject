package leetcode;
import java.util.HashMap;

public class FaboTest {

	public static void main(String[] args) {
		int[] a = {1,3,7,11,12,14,18};
		System.out.println(lenLongestFibSubseq(a));
	}

	public static int lenLongestFibSubseq(int[] a) {
		HashMap<Integer, Integer> valueAndIndex = new HashMap<>();
		int index = 0;
		for (int value : a) {
			valueAndIndex.put(value, index++);
		}

		int currentMaxFibLength = 2;
		// i表示从最长的长度
		for (int i = a.length; i > currentMaxFibLength; --i) {
			// j表示从结果队列中最后一个fb数在原数组的位置
			for (int j = a.length - 1; j >= i - 1; j--) {
				// 查找当前位置和i位置-2的数值组成的最长的fbi序列
				int x = a[j];
				int y = a[i - 2];
				// 如果当前的j位置不是fbi的最后一个数字，则继续寻找下一个
				if (valueAndIndex.containsKey(x + y)) {
					continue;
				}

				int max = 2;
				int tmp;
				while (x < 2 * y && valueAndIndex.containsKey(x - y)) {
					max++;

					tmp = y;
					y = x - y;
					x = tmp;
				}
				currentMaxFibLength = Math.max(max, currentMaxFibLength);
			}
		}

		return currentMaxFibLength < 3 ? 0 : currentMaxFibLength;
	}
}
