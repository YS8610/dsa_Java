public class lc3201 {
    static public int maximumLength(int[] nums) {
        int l = nums.length;
        int even = 0;
        int odd = 0;
        int evenOdd = 0;
        int oddEven = 0;
        for (int n : nums){
            if ((n & 1) == 1)
                odd++;
            else
                even++;
        }
        boolean isEven = true;
        for (int i=0;i<l;i++){
            if (nums[i] % 2 == 0 && isEven){
                evenOdd++;
                isEven = !isEven;
            }
            else if (nums[i] % 2 == 1 && !isEven){
                evenOdd++;
                isEven = !isEven;
            }
        }
        isEven = false;
        for (int i=0;i<l;i++){
            if (nums[i] % 2 == 0 && isEven){
                oddEven++;
                isEven = !isEven;
            }
            else if (nums[i] % 2 == 1 && !isEven){
                oddEven++;
                isEven = !isEven;
            }
        }
        int ans = even;
        ans = Math.max(ans, odd);
        ans = Math.max(ans, evenOdd);
        ans = Math.max(ans, oddEven);
        return ans;
    }

  public static void main(String[] args) {
	int[] nums = {1,2,1,1,2,1,2};
    System.out.println(maximumLength(nums));
  }
}
