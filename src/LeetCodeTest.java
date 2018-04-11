import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LeetCodeTest {
	
	public static void main(String[] args) {
		System.out.println(xorGame(new int[] {0,0,1}));
	}
	
	private static Set<NumFlag> numflags = new HashSet<>();
	private static int finalStage = -1;
	public static boolean xorGame(int[] nums) {
		finalStage = -1;
		int xors = 0;
		for(int num : nums) {
			xors ^= num;
		}
        findOpt(0, xors, new NumFlag(nums.length), nums);
        
        return finalStage % 2 == 0;
    }

	private static boolean findOpt(int stage, int xors, NumFlag numFlag, int[] nums) {
		if(finalStage != -1) {
			return false;
		}
		
		if(stage == nums.length) {
			finalStage = stage;
			return true;
		}
		
		if(xors == 0) {
			finalStage = stage;
			return true;
		}
		
		int erase;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != -1) {
				erase = nums[i];
				nums[i] = -1;
				NumFlag numFlagNew = numFlag.clone();
				numFlagNew.flagPos(i);
				if(!numflags.contains(numFlagNew)) {
					numflags.add(numFlagNew);
					if(!findOpt(stage + 1, xors^erase, numFlagNew, nums)) {
						return true;
					}
				}
			}
		}
		
		finalStage = stage + 1;
		return false;
	}
	
	static class NumFlag implements Cloneable{
		private byte[] flags;
		
		public NumFlag(int lenght) {
			flags = new byte[lenght / 8 + (lenght % 8 == 0 ? 0 : 1)];
		}
		
		public boolean findPosFlag(int pos) {
			int arrIndex = pos / 8;
			int bit = pos % 8;
			
			return ((1 << bit) & flags[arrIndex]) == 1;
		}
		
		public NumFlag flagPos(int pos) {
			int arrIndex = pos / 8;
			int bit = pos % 8;
			
			flags[arrIndex] = (byte) ((1 << bit) | flags[arrIndex]);
			return this;
		}
		
		 @Override
		 protected NumFlag clone(){
		     try {
				return (NumFlag) super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			return null;
		 }
		 
		  @Override
	        public boolean equals(Object o) {
	            if (this == o) return true;
	            if (!(o instanceof NumFlag)) return false;

	            NumFlag numFlag = (NumFlag) o;

	            return Arrays.equals(flags, numFlag.flags);
	        }

	        @Override
	        public int hashCode() {
	            return Arrays.hashCode(flags);
	        }
	}
}
