import java.util.Arrays;

public class lc179 {

  private static String largestNumber(int[] nums) {
    String[] temp = new String[2];
    int len = nums.length;

    int[] pNums = Arrays
      .stream(nums)
      .boxed()
      .sorted((m1, m2) -> {
        temp[0] = String.valueOf(m1);
        temp[1] = String.valueOf(m2);
        // Long s1 = Long.parseLong(String.join("", temp));
        // String s1 = String.join("", temp);
        // temp[0] = String.valueOf(m2);
        // temp[1] = String.valueOf(m1);
        // Long s2 = Long.parseLong(String.join("", temp));
        // String s2 = String.join("", temp);
        // if (s1 < s2) return 1; else if (s1 == s2) return 0; else return -1;
        // return new BigInteger(s2).compareTo(new BigInteger(s1));
        return (temp[1]+temp[0]).compareTo(temp[0]+temp[1]);
      })
      .mapToInt(i -> i)
      .toArray();

    String[] sTemp = new String[len];
    for (int i = 0; i < len; i++) sTemp[i] = String.valueOf(pNums[i]);
    String ans = String.join("", sTemp);
    if (ans.charAt(0)=='0') return "0";
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 0,0 };
    System.out.println(largestNumber(nums));
  }
}
