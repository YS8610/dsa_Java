public class lc28 {
  private static int strStr(String haystack, String needle){
    return haystack.indexOf(needle);
  }

  public static void main(String[] args) {
    String  haystack = "leetcode", needle = "leeto";
    System.out.println( strStr(haystack,needle) );
  }
}
