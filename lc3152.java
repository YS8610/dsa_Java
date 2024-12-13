public class lc3152 {
  public boolean[] isArraySpecial(int[] nums, int[][] queries) {
		int len = queries.length;
		int lnum = nums.length;
		boolean[] ans = new boolean[len];
		int[] map = new int[lnum];
		int lp = 0; 
		int rp = 0;
		map[0] = lp;
		map[lnum-1] = lnum-1;
		// sliding window to build the prefix array
		while (lp < lnum && rp < lnum-1){
			if ((nums[rp] & 1) + (nums[rp+1] & 1) == 1){
				map[rp] = lp;
				map[rp+1] = lp;
				rp++;
				continue;
			}
			lp = rp+1;
			rp = lp;
			map[lp] = lp;
		}
		// return the query using the prefix array
		for (int i =0; i <len;i++)
			if (queries[i][0] >= map[queries[i][1]])
				ans[i] = true;
		return ans;
  }
}
