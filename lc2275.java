public class lc2275 {
  private static int largestCombination(int[] candidates) {
    int[] mask = new int[31];
    int tmp = 1;
    int ans = 1;
    for (int i=0;i<31;i++){
      mask[i] = tmp;
      tmp <<=1;
    }
    int[] map = new int[31];
    for (int c : candidates){
      for (int j=0;j<31;j++)
        if ( (mask[j] & c) > 0) map[j]++;
    }
    for (int m : map) ans = Math.max(m,ans);
    return ans;
  }

  public static void main(String[] args) {
    int[] candidates = {16,17,71,62,12,24,14};
    System.out.println(largestCombination(candidates));
  }
}
