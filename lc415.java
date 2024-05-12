import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class lc415 {

  private static String addStrings(String num1, String num2) {
    Map<String, Integer> memo = new HashMap<>();
    for (int i = 0; i <= 9; i++) memo.put(String.valueOf(i), i);
    for (int i = 0; i <= 9; i++) memo.put("0" + String.valueOf(i), i);
    for (int i = 10; i <= 99; i++) memo.put(String.valueOf(i), i / 10 + i % 10);
    int l1 = num1.length();
    int l2 = num2.length();
    char[] c1 = num1.toCharArray();
    char[] c2 = num2.toCharArray();
    char[] longer, shorter;
    if (l1 >= l2) {
      longer = c1;
      shorter = c2;
    } else {
      longer = c2;
      shorter = c1;
    }
    int counter = 0;
    LinkedList<String> temp = new LinkedList<>();
    while (counter < shorter.length) {
      temp.addFirst(
        String.valueOf(c1[l1 - counter - 1]) +
        String.valueOf(c2[l2 - counter - 1])
      );
      counter++;
    }
    for (int i = counter; i < longer.length; i++) {
      temp.addFirst(String.valueOf(longer[longer.length - i - 1]));
    }
    int lengthCombined = temp.size();
    int[] pAns = new int[lengthCombined + 1];
    for (int i = lengthCombined; i > 0; i--) {
      int sum = memo.get(temp.pollLast()) + pAns[i];
      if (sum >= 10) {
        pAns[i] = sum - 10;
        pAns[i - 1] += 1;
      } else pAns[i] = sum;
    }
    String[] sAns;
    int lpAns = pAns.length;
    if (pAns[0] == 0) {
      sAns = new String[lpAns - 1];
      for (int i = 1; i < lpAns; i++) sAns[i - 1] = String.valueOf(pAns[i]);
    } 
    else{
      sAns = new String[lpAns];
      for (int i = 0; i < lpAns; i++) sAns[i] = String.valueOf(pAns[i]);
    } 
    return String.join("",sAns);
  }

  public static void main(String[] args) {
    String num1 = "9999", num2 = "111";
    System.out.println(addStrings(num1, num2));
  }
}
