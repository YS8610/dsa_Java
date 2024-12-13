import java.util.Arrays;

public class lc2679 {
  public int matrixSum(int[][] nums) {
		int ans = 0;
		int lr = nums.length;
		int lc = nums[0].length;
		for (int[] n : nums)	Arrays.sort(n);
		for (int c =lc -1, tmp; c>=0; c--){
			tmp = 0;
			for (int r=0; r < lr ;r++)
				tmp = Math.max(tmp, nums[r][c]);
			ans +=tmp;
		}
		return ans;
  }
}
