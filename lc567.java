import java.util.Arrays;

public class lc567 {
  private static boolean checkInclusion(String s1, String s2) {
    int l1 = s1.length();
    int l2 = s2.length();
    if (l1>l2) return false;
    int[] map1 = new int[26];
    int[] map2 = new int[26];
    for (int i=0;i<l1;i++) map1[(int) s1.charAt(i)-'a']++;
    for (int i=0;i<l1;i++) map2[(int) s2.charAt(i)-'a']++;
    if (Arrays.equals(map1, map2)) return true;
    for (int i=1, n=l2-l1;i<=n;i++){
      map2[(int) s2.charAt(i-1)-'a']--;
      map2[(int) s2.charAt(i+l1-1)-'a']++;
      if (Arrays.equals(map1, map2)) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    String s1 = "ab", s2 = "eidbaooo";
    System.out.println( checkInclusion(s1, s2));
  }
}
