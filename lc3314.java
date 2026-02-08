import java.util.List;

public class lc3314 {
  public int[] minBitwiseArray(List<Integer> nums) {
    int l = nums.size();
    int[] ans = new int[l];
    out: for (int i = 0; i < l; i++) {
      if ((nums.get(i) & 1) == 0) {
        ans[i] = -1;
        continue;
      }
      for (int j = 0; j <= nums.get(i); j++) {
        if ((j | (j + 1)) != nums.get(i))
          continue;
        ans[i] = j;
        continue out;
      }
      ans[i] = -1;
    }
    return ans;
  }


  public static void main(String[] args) {

  }
}
