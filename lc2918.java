class lc2918{
    public static long minSum(int[] nums1, int[] nums2) {
        long ans = 0;
        int z1 = 0, z2 = 0;
        long s1 = 0, s2 = 0;
        for (int n : nums1){
            s1 += n;
            z1 += n==0?1:0;
        }
        for (int n : nums2){
            s2 += n;
            z2 += n==0?1:0;
        }
        if (z1 == 0 && z2 == 0)
            return s1==s2?s1:-1;
        if (z1 > 0 && z2 > 0)
            return Math.max(s1+z1, s2+z2);
        if (z1 == 0)
            return s1 >=(s2+z2) ? s1 : -1;
        else 
            return s2 >= (s1+z1) ? s2 : -1;
    }
	
	public static void main(String av[]){
		int[] nums1 = {3,2,0,1,0}, nums2 = {6,5,0};
		System.out.println(minSum(nums1, nums2));
	}
}