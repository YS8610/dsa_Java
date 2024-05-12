public class lc2000 {
  private static String reversePrefix(String word, char ch) {
    int len = word.length();
    char[] ans = new char[len];
    int rp = -1;
    for (int i = 0; i < len; i++) {
      if (word.charAt(i) == ch) {
        rp = i;
        break;
      }
    }
    if (rp == -1) return word;
    for (int i = rp + 1; i < len; i++)
      ans[i] = word.charAt(i);
    for (int i=0; i<=rp;i++){
      ans[i] = word.charAt(rp-i);
    }
    return String.valueOf(ans);
    }

    public static void main(String[] args) {
      String word = "xyxzxe";
      char ch = 'z';
      System.out.println(reversePrefix(word, ch));
    }
}
