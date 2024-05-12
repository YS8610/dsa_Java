public class lc387 {
  private static int firstUniqChar(String s) {
    int[] memo = new int[26];
    int len = s.length();
    for (int i=0;i<len;i++){
      memo[(int) s.charAt(i)-'a']++;
    }
    for (int i=0;i<len;i++){
      if (memo[(int) s.charAt(i) -'a']==1) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    String s = "leetcode";
    System.out.println(firstUniqChar(s));
  }
}
