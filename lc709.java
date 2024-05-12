public class lc709 {
  private static String toLowerCase(String s) {
    char[] cStr = s.toCharArray();
    for (int i =0, n=cStr.length;i<n;i++ ){
      cStr[i] = Character.toLowerCase(cStr[i]);
    }
    return new String(cStr);
  }

  private static String toLowerCase1(String s) {
    return s.toLowerCase();
  }

  public static void main(String[] args) {
    String s = "Hello";
    System.out.println( toLowerCase(s) );
    System.out.println( toLowerCase1(s) );
  }

}
