import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class Contest {
	// ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."

	public static void main(String[] args) {
		int[] a = {49,50,14,37,66,89,66,80,17,10,2};
		System.out.println(splitArraySameAverage(a));
	}

	public static boolean splitArraySameAverage(int[] a) {
		if(a.length == 1) {
			return false;
		}
		
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
			a[i] *= a.length;
		}
		return splitArraySameAverage(a, 0, 0, 0, 0, -1, sum);
	}

	/**
	 * 
	 * @param a
	 * @param lastArrayLength
	 * @param lastEndIndex
	 * @param average
	 * @return
	 */
	public static boolean splitArraySameAverage(int[] a, int lastLeftTotal, int lastTotalRight, int lastLeftArrayLength,
			int lastRightArrayLength, int lastEndIndex, int average) {
		if(lastEndIndex == a.length - 1) {
			return false;
		}
		
		if(a[lastEndIndex + 1] == average) {
			return true;
		}
		
		boolean canLeft = lastLeftTotal + a[lastEndIndex + 1] <= (a.length - 1 - lastLeftArrayLength) * average;
		boolean canRight = lastTotalRight + a[lastEndIndex + 1] <= (a.length - 1 - lastRightArrayLength) * average;

		if (canLeft && (a[lastEndIndex + 1] + lastLeftTotal == (lastLeftArrayLength + 1) * average)) {
			return true;
		}

		if (lastEndIndex > -1 && canRight && (a[lastEndIndex + 1] + lastTotalRight == (lastRightArrayLength + 1) * average)) {
			return true;
		}

		if(canLeft) {
			if(splitArraySameAverage(a, lastLeftTotal + a[lastEndIndex + 1], lastTotalRight, lastLeftArrayLength + 1, lastRightArrayLength, lastEndIndex + 1, average)) {
				return true;
			}
		}
		
		if(lastEndIndex > -1 &&canRight) {
			if(splitArraySameAverage(a, lastLeftTotal, lastTotalRight + a[lastEndIndex + 1], lastLeftArrayLength, lastRightArrayLength + 1, lastEndIndex + 1, average)) {
				return true;
			}
		}

		return false;
	}

	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int[] rowMaxes = new int[grid.length];
		int[] columnMaxes = new int[grid.length];

		int maxRow;
		int maxColumn;
		for (int i = 0; i < grid.length; i++) {
			maxRow = -1;
			maxColumn = -1;
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] > maxRow) {
					maxRow = grid[i][j];
				}

				if (grid[j][i] > maxColumn) {
					maxColumn = grid[j][i];
				}
			}
			rowMaxes[i] = maxRow;
			columnMaxes[i] = maxColumn;
		}

		int sum = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				sum += Math.max(0, Math.min(rowMaxes[i], columnMaxes[j]) - grid[i][j]);
			}
		}

		return sum;
	}

	public static int[] numberOfLines(int[] widths, String s) {
		int lines = 1;
		int units = 0;

		int sum = 0;
		int charLength;
		for (int i = 0; i < s.length(); i++) {
			charLength = widths[s.charAt(i) - 'a'];
			if (charLength + sum > 100) {
				sum = 0;
				lines++;
			}
			sum += charLength;
		}
		return new int[] { lines, sum };
	}

	private static final int[] morse = { 1, 8, 10, 4, 0, 2, 6, 0, 0, 7, 5, 4, 3, 2, 7, 6, 13, 2, 0, 1, 1, 1, 3, 9, 11,
			12 };
	private static final int[] morseLength = { 2, 4, 4, 3, 1, 4, 3, 4, 2, 4, 3, 4, 2, 2, 3, 4, 4, 3, 3, 1, 3, 4, 3, 4,
			4, 4 };

	public static int uniqueMorseRepresentations(String[] words) {
		Map<Long, String> maps = new HashMap<>();
		long sum;
		int index;
		for (String word : words) {
			sum = 0;
			for (int i = 0; i < word.length(); i++) {
				index = word.charAt(i) - 'a';
				sum <<= morseLength[index];
				sum |= morse[index];
			}
			maps.put(sum, word);
			System.out.println(sum);
		}

		return maps.size();
	}
}
