import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc371 {

  private static int getSum(int a, int b) {
    if (a==0) return b;
    if (b==0) return a;
    if (Math.abs(a) == Math.abs(b)) return 0;
    if ((a >= 0 && b >= 0) || (a < 0 && b < 0)) {
      int[] aA = new int[Math.abs(a)];
      int[] aB = new int[Math.abs(b)];
      List<Integer> memo = new ArrayList<>(2000);
      for (int iA : aA) memo.add(iA);
      for (int iB : aB) memo.add(iB);
      return a < 0 ? -1 * memo.size() : memo.size();
    } else {
      int[] memo = new int[0];
      int[] aA = new int[Math.abs(a)];
      int[] aB = new int[Math.abs(b)];
      // a +ve and |a|>|b| = +ve ans
      if ( a>0 && Math.abs(a)> Math.abs(b) ) return Arrays.copyOfRange(aA, Math.abs(b), aA.length).length;
      // a +ve and |a|<|b| = -ve ans
      if ( a>0 && Math.abs(a)< Math.abs(b) ) return Arrays.copyOfRange(aB, Math.abs(a), aB.length).length*-1;
      // b +ve and |a|>|b| = -ve ans
      if ( b>0 && Math.abs(a)> Math.abs(b) ) return Arrays.copyOfRange(aA, Math.abs(b), aA.length).length*-1;
      // b +ve and |a|<|b| = +ve ans
      if ( b>0 && Math.abs(a)< Math.abs(b) ) return Arrays.copyOfRange(aB, Math.abs(a), aB.length).length;
      return memo.length;
    }
  }

  public static void main(String[] args) {
    int a = 5, b = -5;
    System.out.println(getSum(a, b));
  }
}
