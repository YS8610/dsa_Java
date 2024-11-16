
public class lc3097 {
  private static int count(int[] map, int[] mask){
    int res=0;
    for (int i =0; i<31;i++)
      if (map[i] > 0) res+=mask[i];
    return res;
  }

  private static void addbit(int[]map, int[] mask, int num){
    for (int i=0;i<31;i++)
      if ((mask[i] & num) >0) map[i]++;
  }

  private static void minusbit(int[]map, int[] mask, int num){
    for (int i=0;i<31;i++)
      if ((mask[i] & num) >0) map[i]--;
  }

  private static int minimumSubarrayLength(int[] nums, int k) {
    int lp = 0;
    int rp = 0;
    int l = nums.length;
    for (int n:nums)
      if (n>=k) return 1;
    // bitmask array
    int[] mask = new int[31];
    for (int i =0, bit = 1;i<31;i++){
      mask[i] = bit;
      bit <<=1;
    }
    // map 
    int[] map = new int[31];
    for (int i =0, bit=0; i<l;i++){
      bit |= nums[i];
      addbit(map, mask, nums[i]);
      if (bit >= k){
        rp = i;
        break;
      }
    }
    int ans=l+1;
    while (lp <l){
      if (count(map, mask) >= k){
        ans = Math.min(ans, rp - lp+1);
        if (ans==2) return 2;
        minusbit(map, mask, nums[lp]);
        lp++;
        if (lp > rp) rp = lp;
      }
      else{
        rp++;
        if (rp >= l) {
          rp--;
          if (lp < rp){
            minusbit(map, mask, nums[lp]);
            lp++;
          }
          else break;
          continue;
        }
        addbit(map, mask, nums[rp]);
      }
    }
    return ans==l+1?-1:ans;
  }

  public static void main(String[] args) {
    int[] nums = {36,2,12,1};
    int k = 46;
    System.out.println(minimumSubarrayLength(nums, k));
  }
}
