import java.util.Arrays;

public class lc689 {
	private static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int l = nums.length;
		int[] prefix = new int[l];
		prefix[0] = nums[0];
		for (int i=1;i<l;i++)
			prefix[i] = prefix[i-1] + nums[i];
		return dfs(nums, prefix, k, 0, 0, new int[3]);
	}

	private static int[] dfs(int[] nums, int[] prefix, int k, int lvl, int pos, int[] array){
		if (lvl == 3)	return array;
		int l = nums.length;
		int[] ans;
		int sum = 0;
		int tmp;
		int[] finalans= new int[3];
		for (int i =pos, n= l-k-1;i<n;i++){
			int[] copy = Arrays.copyOf(array, 3);
			copy[lvl] = pos;
			ans = dfs(nums, prefix, k, lvl+1, i+k, copy);
			if (ans == null) continue;
			tmp = prefixsum(prefix, ans[0], ans[0]+k-1)
					+ prefixsum(prefix, ans[1], ans[1]+k-1)
					+ prefixsum(prefix, ans[2], ans[2]+k-1);
			if (tmp > sum){
				sum = tmp;
				for (int j =0; j<3;j++)
					finalans[j] = ans[j];
			}
		}
		return finalans;
	}

	private static int prefixsum(int[] prefix, int start, int end){
		if (end >=prefix.length|| start>=prefix.length)
			return -1;
		if (start == 0)
			return prefix[end];
		return prefix[end] - prefix[start-1];
	}

	public static void main(String[] args) {
		int[] nums = {1,2,1,2,6,7,5,1};
		int k = 2;
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(nums, k)));
	}
}
