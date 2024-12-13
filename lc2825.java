public class lc2825 {
  private static boolean match(char a, char b){
    if (a == b) return true;
    if ((a-'a'+1)%26 == b -'a') return true;
    return false;
  }
  
  private static boolean canMakeSubsequence(String str1, String str2) {
    int l1 = str1.length();
    int l2 = str2.length();
    if (l1 < l2) return false;
    int j=0;
    int n=0;
    for (int i =0;i<l2;i++){
      while (j < l1){
        if (match(str1.charAt(j), str2.charAt(i))){
          j++;
          n++;
          break;
        }
        j++;
      }
    }
    if (n == l2) return true;
    return false;
  }

  public static void main(String[] args) {
    String str1 = "abc", str2 = "ad";
    System.out.println(canMakeSubsequence(str1, str2));
  }
}
