public class lc1347 {
  private static int minSteps(String s, String t) {
    int len = s.length();
    int[] sArray = new int[26];
    int[] tArray = new int[26];
    for (int i =0; i<len;i++){
      sArray[(int) s.charAt(i) - 'a']++;
      tArray[(int) t.charAt(i) - 'a']++;
    }
    int ans=0;
    int diff=0;
    for (int i =0; i<26;i++){
      diff = sArray[i]-tArray[i];
      if (diff<0) ans+=Math.abs(diff);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "leetcode", t = "practice";
    System.out.println(minSteps(s, t));
  }
}
