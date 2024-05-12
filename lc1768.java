public class lc1768 {
  private static String mergeAlternately(String word1, String word2){
    int l1 = word1.length();
    int l2 = word2.length();

    String ans = "";
    for (int i=0, n=l1>=l2?l1:l2 ; i<n;i++){
      if (i<l1) ans +=word1.charAt(i);
      if (i<l2) ans +=word2.charAt(i);
    }
    return ans;
  }
  public static void main(String[] args) {
    String word1 = "abcd", word2 = "pq";
    System.out.println( mergeAlternately(word1, word2) );
  }
}
