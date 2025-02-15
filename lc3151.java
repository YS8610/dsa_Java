class lc3151{
  
  private static boolean isArraySpecial(int[] nums) {
    int l = nums.length;
    if (l ==1)
       return true;
    boolean ans = true;
    boolean tmp = (nums[0] & 1) == 1;
    boolean isOdd;
    for (int i=1; i<l;i++){
      if ((nums[i] & 1) == 1)
        isOdd = true;
      else
         isOdd = false;
      if (tmp == isOdd)
        return false;
      tmp = isOdd;  
    }
    return ans;
  }


  public static void main(String[] args){
    int[] nums = {4,3,1,6};
    System.out.println(isArraySpecial(nums));
  }
}
