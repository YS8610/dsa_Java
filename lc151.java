import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lc151 {

  private static String reverseWords(String s) {
    String pStr = s.trim();
    String[] arrayStr = pStr.split(" ");
    String[] tempArray = new String[arrayStr.length];
    int counter = 0;
    for (int i = arrayStr.length - 1; i >= 0; i--) {
      tempArray[counter] = arrayStr[i];
      counter++;
    }
    List<String> temp = Arrays.stream(tempArray)
                              .filter(a -> !a.isBlank())
                              .collect(Collectors.toList());
    return String.join(" ", temp);
  }

  public static void main(String[] args) {
    String s = "example   good a";
    System.out.println(reverseWords(s));
  }
}
