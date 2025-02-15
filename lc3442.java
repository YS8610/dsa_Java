public class lc3442 {
  private static int maxDifference(String s){
    int l = s.length();
    int[] map = new int[26];
    for (int i=0;i<l;i++)
      map[s.charAt(i) - 'a']++;
    int minEven = l+1;
    int maxOdd = 0;
    for (int m : map){
      if (m==0) continue;
      // even
      if (m % 2 == 0)
        minEven = Math.min(minEven, m);
      else
        maxOdd = Math.max(maxOdd, m);
    }
    return maxOdd - minEven;
  }

  public static void main(String[] args) {
    String s = "aaaaabbc";
    System.out.println(maxDifference(s));
  }
}
