public class lc1980 {
  public static String findDifferentBinaryString(String[] nums) {
    int l = nums.length;
    int[] number = new int[l];
    for (int i = 0; i < l; i++)
      number[i] = Integer.parseInt(nums[i], 2);
    // number[i] = convert(nums[i]);
    int limit = 1 << l;
    int ans = -1;
    out: for (int i = 0; i <= limit; i++) {
      for (int num : number)
        if (num == i)
          continue out;
      ans = i;
      break;
    }
    String result = Integer.toBinaryString(ans);
    return String.format("%" + l + "s", result).replaceAll(" ", "0");
  }

  private static int convert(String e) {
    int l = e.length();
    int sum = 0;
    for (int i = l - 1, bit = 1; i >= 0; i--, bit <<= 1)
      sum += (e.charAt(i) - '0') * bit;
    return sum;
  }

  public static void main(String[] args) {
    String[] nums = {"01","10"};
    System.out.println(findDifferentBinaryString(nums));
  }
}
