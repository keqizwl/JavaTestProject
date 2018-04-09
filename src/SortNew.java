
public class SortNew {

	public static void main(String[] args) {
		int a[] = new int[] {1, 5, 3, 6, 10, 55, 9, 2, 87, 12, 34, 75, 33, 47};
		for (int x : a) {
			System.out.print(x + ",");
		}
		System.out.print('\n');
		shellSort(a);
		for (int x : a) {
			System.out.print(x+ ",");
		}
	}

	public static void shellSort(int[] a) {
		if(a == null) {
			return;
		}
		
		int n = a.length;
		int h = 1;
		
		while(h < n / 3) {
			h = h * 3 + 1;
		}
		
		while(h >= 1) {
			for(int i = 0; i < h; i++) {
				for(int j = i; j < n; j += h) {
					int tmp = a[j];
					int k = j - h;
					for(; k >= 0 && a[k] > tmp; k -= h) {
						a[k + h] = a[k];
					}
					a[k + h] = tmp;
				}
			}
			
			h = h / 3;
		}
	}
}
