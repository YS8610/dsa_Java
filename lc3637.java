public class lc3637 {
  public boolean isTrionic(int[] nums) {
    int i = 1;
    int l = nums.length;
    while (i < l && nums[i] > nums[i - 1])
      i++;
    if (i == 1 || i == l - 1)
      return false;
    int tmp = i;
    while (i < l && nums[i] < nums[i - 1])
      i++;
    if (i == tmp || i == l)
      return false;
    while (i < l && nums[i] > nums[i - 1])
      i++;
    if (i == l)
      return true;
    return false;
  }
}
