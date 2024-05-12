import java.util.Arrays;

public class lc2523 {
  private static int[] closestPrimes(int left, int right) {
    int p = -1;
    int diff = Integer.MAX_VALUE;
    boolean[] map = new boolean[right+1];
    Arrays.fill(map, true);
    map[0] = false;
    map[1] = false;
    for(int i=2,n=(int)Math.sqrt(right);i<=n;i++){
      if (map[i]){
        for(int j = i+i; j<=right;j+=i) map[j] = false;
      }
    }
    for (int i=left; i<=right;i++){
      if (map[i]){
        if (p<0) p = i;
        else {
          diff = Math.min(diff, i - p);
          if (diff == 1) return new int[]{p,i};
          p = i;
        }
      }
    }
    if (diff == Integer.MAX_VALUE) return new int[]{-1,-1};
    p = -1;
    for (int i=left; i<=right;i++){
      if (map[i]){
        if (p<0) p = i;
        else {
          if (i - p == diff){
            while (i>= left){
              if (map[i]) return new int[]{p,i};
              i--;
            }
          }
          p=i;
        }
      }
    }
    return new int[]{-1,-1};
  }

  public static void main(String[] args) {
    int left = 19, right = 31;
    System.out.println(Arrays.toString(closestPrimes(left, right)));
  }
}
