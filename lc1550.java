public class lc1550 {

  private static boolean threeConsecutiveOdds(int[] arr) {
    int j;
    for (int i = 0, n = arr.length - 3; i <= n; i++) {
      j = 0;
      if ((arr[i] & 1) == 1) {
        while (i + j < (n + 3) && j < 3 && (arr[i + j] & 1) == 1) j++;
        if (j >= 3) return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {1,2,34,3,4,5,7,23,12};
    System.out.println(threeConsecutiveOdds(arr));
  }
}
