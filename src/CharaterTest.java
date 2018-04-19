
public class CharaterTest {

	public static void main(String[] args) {
		Character character = new Character(' ');
		
		long currentTime = System.nanoTime();
		System.out.println(currentTime);
		for(int i = 0; i< 10000000;i++) {
			toCodePoint('1','2');
		}
		System.out.println(System.nanoTime()-currentTime);
		currentTime =  System.nanoTime();
		for(int i = 0; i< 10000000;i++) {
			toCodePoint2('1','2');
		}
		System.out.println(System.nanoTime()-currentTime);
	}

	public static int toCodePoint(char high, char low) {
		// Optimized form of:
		// return ((high - Character.MIN_HIGH_SURROGATE) << 10)
		// + (low - Character.MIN_LOW_SURROGATE)
		// + Character.MIN_SUPPLEMENTARY_CODE_POINT;
		return ((high << 10) + low) + (Character.MIN_SUPPLEMENTARY_CODE_POINT - (Character.MIN_HIGH_SURROGATE << 10)
				- Character.MIN_LOW_SURROGATE);
	}
	
	public static int toCodePoint2(char high, char low) {
		// Optimized form of:
		 return ((high - Character.MIN_HIGH_SURROGATE) << 10)
		 + (low - Character.MIN_LOW_SURROGATE)
		 + Character.MIN_SUPPLEMENTARY_CODE_POINT;
//		return ((high << 10) + low) + (Character.MIN_SUPPLEMENTARY_CODE_POINT - (Character.MIN_HIGH_SURROGATE << 10)
//				- Character.MIN_LOW_SURROGATE);
	}
}
