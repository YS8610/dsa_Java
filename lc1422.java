public class lc1422 {

  private static int maxScore(String s) {
    int len = s.length();
    int[] preSum = new int[len];
    preSum[0] = s.charAt(0) == '1' ? 1 : 0;
    int max = 0;
    int sum = 0;
    for (int i = 1; i < len; i++) {
      if (s.charAt(i) == '1') preSum[i] = preSum[i - 1] + 1; else preSum[i] =
        preSum[i - 1];
    }
    for (int i = 0; i < len-1; i++) {
      sum = (i + 1) - preSum[i] + preSum[len - 1] - preSum[i];
      max = Math.max(max, sum);
    }
    return max;
  }

  public static void main(String[] args) {
    String s = "011101";
    System.out.println(maxScore(s));
  }
}
