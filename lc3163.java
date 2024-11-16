public class lc3163 {

  private static String compressedString(String word) {
    StringBuilder ans = new StringBuilder();
    int i = 0;
    int j = 0;
    int l = word.length();
    while (i < l) {
      j = 0;
      while (i + j < l && j < 9) {
        if (word.charAt(i + j) == word.charAt(i)) j++; else break;
      }
      ans.append((char) (j + '0'));
      ans.append(word.charAt(i));
      i += j;
    }
    return ans.toString();
  }

  public static void main(String[] args) {
    String word = "abcde";
    System.out.println(compressedString(word));
  }
}
