import java.util.HashSet;
import java.util.Set;

public class lc202 {
  private static boolean isHappy(int n) {
    if (n==1) return true;
    if (n < 10) return false;
    Set<Integer> set = new HashSet<>();
    String a = String.valueOf(n);
    int temp = 0;
    for (int i=0,len=a.length();i<len;i++){
      temp += (a.charAt(i) - '0') * (a.charAt(i) - '0');
    }
    if (temp == 1) return true;
    set.add(temp);
    while (temp != 1){
      a = String.valueOf(temp);
      temp = 0;
      for (int i=0,len=a.length();i<len;i++){
        temp += (a.charAt(i) - '0') * (a.charAt(i) - '0');
      }
      if (set.contains(temp)) return false;
    }
    return true;
  }


  public static void main(String[] args) {
    System.out.println( isHappy(19));
  }
}
