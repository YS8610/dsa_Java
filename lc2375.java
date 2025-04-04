import java.util.Arrays;

class lc2375{
  private static String smallestNumber(String pattern) {
    int l = pattern.length();
    boolean[] map = new boolean[10];
    int[] ans = null;
    for (int i =1; i<10;i++){
      int[] tmp = new int[l+1];
      tmp[0] = i;
      map[i] = true;
      ans = smaller(ans, bt(pattern, 0, map, tmp));
      map[i] = false;
    }
    StringBuilder str = new StringBuilder();
    for (int a : ans)
      str.append((char)(a+'0'));
    return str.toString(); 
  }

  private static int[] bt(String pattern, int i, boolean[] map, int[] p){
    int l = pattern.length();
    if (i >= l) return Arrays.copyOf(p, l+1);
    int[] ans = null;
    for (int j=1;j<10;j++){
      if (map[j]) continue;
      if (pattern.charAt(i) == 'I' && p[i] >= j) continue;
      if (pattern.charAt(i) == 'D' && p[i] <= j) continue;
      p[i+1] = j;
      map[j] = true;
      ans = smaller(ans, bt(pattern, i+1, map, p));
      map[j] = false;
    }
    return ans;
  }

  private static int[] smaller(int[] a, int[] b){
    if (a == null) return b;
    if (b == null) return a;
    for (int i=0, n=a.length; i<n;i++){
      if (a[i] == b[i]) continue;
      if (a[i] < b[i])
        return a;
    }
    return b;
  }

  public static void main(String[] args){
    String pattern = "DDD";
    System.out.println(smallestNumber(pattern));
  }
}
