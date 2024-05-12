import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc168 {

  private static String convertToTitle(int columnNumber) {
    int base = 0;
    int power=0;
    int result = columnNumber;
    while (result>1){
      result = columnNumber;
      base = (int) Math.pow(26, power);
      result /=base;
      power++;
    }
    result = columnNumber;
    int remainder;
    List<Integer> a = new ArrayList<>();
    for (int p=power-1;p>=0;p--){
      remainder = result / (int) Math.pow(26, p);
      a.add( remainder );
      result -= (int) Math.pow(26, p) * remainder;
    }

    return "";

  }

  public static void main(String[] args) {
    int columnNumber = 26;
    System.out.println(convertToTitle(columnNumber));
  }
}
