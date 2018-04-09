import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Sort {

	public static void main(String[] args) {
		int a[] = new int[] { 1, 5, 3, 6, 10, 55, 9, 2, 87, 12, 34, 75, 33, 47 };
		for (int x : a) {
			System.out.print(x + ",");
		}
		System.out.print('\n');
		quickSort2(a);
		for (int x : a) {
			System.out.print(x + ",");
		}

		// System.out.println(isSub("abc", "aafgtwqrqwbfafafwec"));

//		Node head = new Node(0);
//		Node next = head;
//		for(int i = 1; i < 10; i++) {
//			next.next = new Node(i);
//			next = next.next;
//		}
//		
//		Node head2 = nixuNode(head);
//		
//		while(head2 != null) {
//			System.out.println(head2.value);
//			head2 = head2.next;
//		}
		
//		System.out.println(isSubStr("abdfababcabaabfabcbdf", "abdfabc"));
	}
	
	public static void quickSort2(int[] a) {
		quickSort2(a, 0, a.length);
		
	}
	
	public static void quickSort2(int[] a, int start, int end) {
		if(start >= end) {
			return;
		}
		
		int i = start;
		int j = end - 1;
		boolean findRight = true;
		
		while(i != j) {
			if(findRight) {
				if(a[i] > a[j]) {
					exch(a, i, j);
				}else {
					j--;
				}
			}else {
				if(a[i] > a[j]) {
					exch(a, i, j);
				}else {
					i++;
				}
			}
		}
		
		quickSort2(a, start, i);
		quickSort2(a, i + 1, end);
	}
	
	public static int isSubStr(String source, String sub) {
		int start = 0;
		int same = 0;//一次对比中，相同的头尾最大穿长度
		int n = source.length();
		int n2 = sub.length();
		while(true) {
			int i = same;
			while(i < n2 && i + start < n && sub.charAt(i) == source.charAt(i + start)){
				i++;
			}
			
			if(i == n2) {
				return start;
			}else {
				if(i + start >= n) {
					return -1;
				}else {
					same = 0;
					for(int j = 0; j < i - 1 && sub.charAt(j) == sub.charAt(i - 1 - j); j++) {
						same ++;
					}
					if(same == 0) {
						start ++;
					}else {
						start += i - same;
					}
				}
			}
		}
	}
	
	private static Node nixuNode(Node head) {
		Node tmp = null;
		Node newLink = null;
		while(head != null) {
			tmp = head.next;
			head.next = newLink;
			newLink = head;
			head = tmp;
		}
		
		return newLink;
	}
	 
	private static class Node{
		int value;
		Node next;
		
		public Node(int value) {
			this.value = value;
		}
	}
	

	/**
	 * 利用shell排序方法给数组a排序
	 * 
	 * @param a 待排序的数组
	 *            
	 */
	public static void shellSort2(int[] a) {
		if (a == null) {
			return;
		}

		int n = a.length;
		int h = 1;

		while (h < n / 3) {
			h = h * 3 + 1;
		}

		while (h >= 1) {

			for (int i = h; i < n; i++) {
				for (int j = i - h; j >= 0 && a[j] > a[j + h]; j -= h) {
					exch(a, j, j + h);
				}
			}

			h /= 3;
		}
	}

	public static void mergeSort(int[] a) {
		if (a == null) {
			return;
		}

		int n = a.length;
		int middle = a.length / 2;

		charuSort(a, 0, middle);
		charuSort(a, middle + 1, n);

		while (true) {
			break;
		}

		for (int x : a) {
			System.out.print(x + ",");
		}
		System.out.print('\n');
	}

	public static void shellSort(int[] a) {
		if (a == null) {
			return;
		}

		// 1求解shell的次数
		int N = a.length;
		int maxJiange = 1;
		while (maxJiange < N / 3) {
			maxJiange = maxJiange * 3 + 1;
		}

		while (maxJiange >= 1) {
			System.out.println("maxJiange = " + maxJiange);
			int currentNum;
			for (int i = 0; i < maxJiange; i++) {
				for (int j = i; j < N; j += maxJiange) {
					currentNum = a[j];
					for (int k = j - maxJiange; k >= 0; k -= maxJiange) {
						if (a[k] > currentNum) {
							a[k + maxJiange] = a[k];
							a[k] = currentNum;
						} else {
							a[k + maxJiange] = currentNum;
							break;
						}
					}
				}
			}

			for (int x : a) {
				System.out.print(x + ",");
			}
			System.out.print('\n');
			maxJiange = maxJiange / 3;
		}
	}

	public static boolean isSub(String s, String t) {
		if (s == null || t == null || s.length() > t.length()) {
			return false;
		}

		int startCount = 0;
		boolean found;
		for (int i = 0; i < s.length(); i++) {
			found = false;

			for (int j = startCount; j < t.length(); j++) {
				if (t.charAt(j) == s.charAt(i)) {
					startCount = ++j;
					found = true;
					break;
				}
			}

			if (!found) {
				return false;
			}
		}

		return true;
	}

	public static void maopaopaixu(int[] a) {
		if (a == null) {
			return;
		}

		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < a.length - i; j++) {
				if (a[j] > a[j + 1]) {
					exch(a, j, j + 1);
				}
			}
		}
	}

	public static void xuanzepaixu(int[] a) {
		if (a == null) {
			return;
		}

		int maxNumIndex = 0;

		for (int i = 0; i < a.length; i++) {
			maxNumIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[maxNumIndex]) {
					maxNumIndex = j;
				}
			}
			exch(a, maxNumIndex, i);
		}
	}

	// 从小到大
	public static void charuSort(int[] a, int start, int end) {
		if (a == null || start < 0 || end > a.length) {
			return;
		}

		// 定义一个数组用来放已经排好的数字
		int[] x = a;
		int xCount = start;// 排好序的x的长度
		int unSortPos;// 未排序的数字的位置
		// 将a中的每一个拿出来插入排好序的x
		for (int i = start; i < end; i++) {
			unSortPos = i;
			// 从后往前比较，如果未排序的比当前比较的数小，则交换位置
			for (int j = xCount - 1; j >= start; j--) {
				if (!less(x[j], x[unSortPos])) {
					exch(x, j, unSortPos);
					unSortPos = j;
				} else {
					break;
				}
			}
			xCount++;
		}
	}

	private static void exch(int[] a, int i, int j) {
		if (i == j) {
			return;
		}

		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	private static boolean less(int i, int j) {
		return i < j;
	}
	
	private static void quickSort(int[] a) {
		partOneSort(a, 0, a.length);
	}
	
	private static void partOneSort(int[] a, int start, int end) {
		if(start >= end) {
			return;
		}
		
		int i = start,j = end - 1;
		boolean findRight= true;
		while(i != j) {
			if(findRight) {
				if(a[j] < a[i]) {
					exch(a, i, j);
					findRight = false;
				}else {
					j--;
				}
			}else {
				if(a[j] < a[i]) {
					exch(a, i, j);
					findRight = true;
				}else {
					i++;
				}
			}
		}
		
		partOneSort(a, start, i);
		partOneSort(a, i + 1, end);
	}
}
