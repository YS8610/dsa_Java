import java.util.Arrays;

public class lc2785 {
  private static String sortVowels(String s){
    int len = s.length();
    int n = 0;
    int[] map = new int['z' - 'A' + 1];
    char[] vowels = new char[]{'A','E','I','O','U'};
    for (char v:vowels){
      map[v - 'A'] = 1;
      map[v- 'A' + ('a' - 'A')] = 1;
    }
    for (int i =0; i<len;i++) {
      if (map[s.charAt(i) - 'A'] == 1) n++;
    }
    if (n==0) return s;
    char[] needSort = new char[n];
    char[] sArray = s.toCharArray();
    n=-1;
    for (int i =0; i<len;i++) {
      if (map[s.charAt(i) - 'A'] == 1) {
        sArray[i] = '0';
        needSort[++n] = s.charAt(i);
      }
    }
    Arrays.sort(needSort);
    n=-1;
    for (int i =0; i<len;i++) {
      if (sArray[i]=='0') sArray[i] = needSort[++n];
    }
    return String.valueOf(sArray);
  }

  public static void main(String[] args) {
    String s = "lEetcOde";
    System.out.println(sortVowels(s));
  }
}
