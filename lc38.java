import java.util.ArrayList;
import java.util.List;

public class lc38 {
  private static String countAndSay(int n) {
    if (n==1) return "1";
    String a = countAndSay(n-1);
    int l = a.length();
    int i = 0;
    int j;
    List<String> list = new ArrayList<>(); 
    while (i<l){
      j=0;
      while( i+j<l && a.charAt(i+j)==a.charAt(i)){
        j++;
      }
      list.add(String.join("", List.of(String.valueOf(j),String.valueOf(a.charAt(i)))) );
      i += j;
    }
    return String.join("", list);
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println(countAndSay(n));
  }
}
