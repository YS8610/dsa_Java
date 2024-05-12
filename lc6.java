import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lc6 {

  private static String convert(String s, int numRows) {
    int n = s.length();
    if (n <= numRows || numRows == 1) return s;
    List<LinkedList<String>> memo = new ArrayList<>(numRows);
    for (int i = 0; i < numRows; i++) {
      memo.add(new LinkedList<>(Arrays.asList(String.valueOf(s.charAt(i)))));
    }
    int dp = numRows - 1;
    boolean increase = false;
    for (int i = numRows; i < n; i++) {
      if (increase) {
        dp++;
        LinkedList<String> temp = memo.get(dp);
        temp.add(String.valueOf(s.charAt(i)));
        if (dp == numRows - 1) increase = false;
      } else {
        dp--;
        LinkedList<String> temp = memo.get(dp);
        temp.add(String.valueOf(s.charAt(i)));
        if (dp == 0) increase = true;
      }
    }
    // for (LinkedList<String> a : memo) System.out.println(a.toString());
    for (int i = 1; i < numRows; i++) memo.get(0).addAll(memo.get(i));
    // System.out.println(memo.get(0).toString());
    return String.join("", memo.get(0));
  }

  public static void main(String[] args) {
    String s = "PAYPALISHIRING";
    int numRows = 3;
    System.out.println(convert(s, numRows));
  }
}
