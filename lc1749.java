class lc1749 {
    static public int maxAbsoluteSum(int[] nums) {
        int l = nums.length;
        int min = 0;
        int max = nums[0];
        int sum = 0;
        int ans = 0;
        int tmp;
        for (int i=0; i<l;i++){
            sum+=nums[i];
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            tmp = Math.max(Math.abs(sum-min), Math.abs(sum -max));
            ans = Math.max(ans, tmp);
            ans = Math.max(ans, Math.abs(sum));
        }
        return ans;
    }
	
	public static void main(String[] args){
		int[] nums = {2,-5,1,-4,3,-2};
		System.out.println(maxAbsoluteSum(nums));
	}
}
