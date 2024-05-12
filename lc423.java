import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc423 {

  private static String originalDigits(String s) {
    Map<Character, Integer> map = new HashMap<>();
    int n = s.length();
    for (int i = 0; i < n; i++) {
      if (map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
      } else map.put(s.charAt(i), 1);
    }
    char[] a = new char[n];

    String[] numStrArray = {
      "zero",
      "two",
      "four",
      "six",
      "eight",
      "five",
      "seven",
      "three",
      "one",
      "nine"
    };

    int i = 0;
    char k;
    for (int j=0;j<10;j++){
      while (helper(map, numStrArray[j])) {
        if (j==0) k='0';
        else if (j==1) k='2';
        else if (j==2) k='4';
        else if (j==3) k='6';
        else if (j==4) k='8';
        else if (j==5) k='5';
        else if (j==6) k='7';
        else if (j==7) k='3';
        else if (j==8) k='1';
        else k='9';
        a[i] = k;
        i++;
      }
    }
    Arrays.sort(a,0,i);
    return new String(a,0,i);
  }

  private static boolean helper(Map<Character, Integer> map, String a) {
    int n = a.length();
    for (int i = 0; i < n; i++) {
      if (!map.containsKey(a.charAt(i))) return false;
    }
    for (int i = 0; i < n; i++) {
      if (map.get(a.charAt(i)) == 1) map.remove(a.charAt(i)); else map.put(
        a.charAt(i),
        map.get(a.charAt(i)) - 1
      );
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "owoztneoer";
    System.out.println(originalDigits(s));
  }
}
