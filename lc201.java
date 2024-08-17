public class lc201 {
  private static int rangeBitwiseAnd(int left, int right) {
    int[] maskMap = new int[31];
    int mask = 1;
    for (int i=0; i<31;i++){
      maskMap[i] = mask;
      mask <<=1;
    }
    mask = 1;
    int diff = right - left;
    int[] ansArr = new int[31];
    int[] leftMap = new int[31];

    leftMap[0] = left & 1;
    mask <<= 1;
    out:
    for (int i = 1; i<31;i++){
      if (mask > left) break out;
      leftMap[i] = leftMap[i-1] + (mask & left);
      mask <<=1;
    }
    mask = 1;
    for (int i=0;i<30;i++){
      if ((mask & left) == 0) {
        mask <<=1;
        continue;
      }
      if (maskMap[i+1] - leftMap[i] > diff) ansArr[i] = 1; 
      mask <<=1;
    }
    if (left >= mask ) ansArr[30] = 1;
    int ans = 0;
    for (int i =0;i<31;i++) ans += ansArr[i] * maskMap[i];
    return ans;
  }

  public static void main(String[] args) {
    int left = 2, right = 2147483647;
    System.out.println(rangeBitwiseAnd(left, right));
  }
}
