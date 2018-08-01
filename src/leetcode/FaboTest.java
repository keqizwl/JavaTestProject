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
		// i��ʾ����ĳ���
		for (int i = a.length; i > currentMaxFibLength; --i) {
			// j��ʾ�ӽ�����������һ��fb����ԭ�����λ��
			for (int j = a.length - 1; j >= i - 1; j--) {
				// ���ҵ�ǰλ�ú�iλ��-2����ֵ��ɵ����fbi����
				int x = a[j];
				int y = a[i - 2];
				// �����ǰ��jλ�ò���fbi�����һ�����֣������Ѱ����һ��
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
