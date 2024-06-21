public class lc344 {
  private static void reverseString(char[] s) {
    int lp = 0;
    int rp = s.length-1;
    char tmp;
    while (lp < rp){
      tmp = s[lp];
      s[lp] = s[rp];
      s[rp] = tmp;
      lp++;
      rp--;
    }
  }

  public static void main(String[] args) {
    char[] s = {'h','e','l','l','o'};
    reverseString(s);
    System.out.println(s);
  }
}
