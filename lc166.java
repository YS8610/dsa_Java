import java.util.HashSet;
import java.util.Set;

public class lc166 {
  static public String fractionToDecimal(int numerator, int denominator) {
    int n1 = Math.abs(numerator);
    int d1 = Math.abs(denominator);
    int whole = n1 / d1;
    int remainder = n1 % d1;
    Set<Integer> visited = new HashSet<>();
    boolean positive = true;
    if ((numerator < 0 || denominator < 0) && !(numerator < 0 && denominator < 0))
      positive = false;
    if (remainder == 0)
      return String.valueOf((positive ? 1 : -1) * whole);
    StringBuilder str = new StringBuilder();
    if (!positive)
      str.append('-');
    str.append(String.valueOf(whole));
    str.append('.');
    StringBuilder str1 = new StringBuilder();
    while (!visited.contains(remainder) || remainder == 0) {
      visited.add(remainder);
      while (n1 < d1) {
        n1 *= 10;
        if (n1 < d1)
          str1.append('0');
      }
      whole = n1 / d1;
      str1.append(String.valueOf(whole));
      remainder = n1 % d1;
      n1 = remainder;
      if (n1 == 0){
        str.append(str1);
        return str.toString();
      }
    }

    str1.append(')');
    return str.toString();
  }

  public static void main(String[] args){
    int numerator = -1, denominator = 3;
    System.out.println(fractionToDecimal(numerator, denominator));
  }
}
