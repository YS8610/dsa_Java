import java.util.Arrays;

public class lc2657 {

  private static int[] findThePrefixCommonArray(int[] A, int[] B) {
    int l = A.length;
    boolean[] seta = new boolean[51];
    boolean[] setb = new boolean[51];
    int[] ans = new int[l];
    for (int i = 0; i < l; i++) {
      seta[A[i]] = true;
      setb[B[i]] = true;
      for (int j = 0; j < 51; j++) if (seta[j] && setb[j]) ans[i]++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] A = { 1, 3, 2, 4 };
    int[] B = { 3, 1, 2, 4 };
    System.out.println(Arrays.toString(findThePrefixCommonArray(A, B)));
  }
}
