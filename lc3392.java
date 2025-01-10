class lc3392{
	private static int countSubarrays(int[] nums) {
		int l = nums.length;
		int sum;
		int ans = 0;
		for (int i = 0, n= l-2; i<n;i++){
			sum = nums[i] + nums[i+2];
			if (sum *2 == nums[i+1])
				ans++;
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,1,4,1};
		System.out.println(countSubarrays(nums));
	}
}