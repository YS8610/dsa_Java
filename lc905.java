import java.util.Arrays;

public class lc905 {

  private static int[] sortArrayByParity(int[] nums) {
    return Arrays
      .stream(nums)
      .boxed()
      .sorted((m1, m2) -> {
        if (m1 % 2 == 0 && m2 % 2 == 0) return Integer.compare(
          m1,
          m2
        ); else if (m1 == m2) return 0; else if (
          m1 % 2 == 0
        ) return -1; else return 1;
      })
      .mapToInt(i -> i)
      .toArray();
  }

  private static int[] sortArrayByParity1(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    int lp =0, rp=n-1;
    for (int a : nums){
      if (a%2==0){ 
        ans[lp] = a;
        lp++;
      }
      else{
        ans[rp] = a;
        rp--;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {
      3363,
      4833,
      290,
      3381,
      4227,
      1711,
      1253,
      2984,
      2212,
      874,
      2358,
      2049,
      2846,
      2543,
      1557,
      1786,
      4189,
      1254,
      2803,
      62,
      3708,
      1679,
      228,
      1404,
      1200,
      4766,
      1761,
      1439,
      1796,
      4735,
      3169,
      3106,
      3578,
      1940,
      2072,
      3254,
      7,
      961,
      1672,
      1197,
      3187,
      1893,
      4377,
      2841,
      2072,
      2011,
      3509,
      2091,
      3311,
      233,
    };

    System.out.println(Arrays.toString(sortArrayByParity(nums)));
    System.out.println(Arrays.toString(sortArrayByParity1(nums)));
  }
}
