import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc227 {

  private static int calculate(String s) {
    Deque<String> stack = new ArrayDeque<>();
    String sProcessed = s.replaceAll(" ", "");
    List<String> sList = new ArrayList<>();
    int signIndex = 0;
    int n = sProcessed.length();
    Set<Character> set = new HashSet<>(List.of('-', '+', '*', '/'));
    for (int i = 0; i < n; i++) {
      if (set.contains(sProcessed.charAt(i))) {
        sList.add(sProcessed.substring(signIndex == 0 ? 0 : signIndex + 1, i));
        sList.add(String.valueOf(sProcessed.charAt(i)));
        signIndex = i;
      }
    }
    sList.add(sProcessed.substring(signIndex == 0 ? 0 : signIndex + 1, n));
    n = sList.size();
    if (n == 1) return Integer.parseInt(sList.get(0));
    // use stack to evaluate / and *
    for (int i = 0; i < n; i++) {
      if (stack.isEmpty()) stack.add(sList.get(i)); 
      else if (
        !stack.peekLast().equals("*") && !stack.peekLast().equals("/")
      ) {
        stack.add(sList.get(i));
      } else {
        // 1st pop is multiply or divide
        String firstPop = stack.pollLast();
        // 2nd pop is the first number
        String secondPop = stack.pollLast();
        int res = 0;
        if (firstPop.equals("*")) {
          res = Integer.parseInt(secondPop) * Integer.parseInt(sList.get(i));
        } else {
          res = Integer.parseInt(secondPop) / Integer.parseInt(sList.get(i));
        }
        String result = String.valueOf(res);
        stack.add(result);
      }
    }
    if (stack.size()==1) return Integer.parseInt(stack.peek());
    int result = 0;
    while(!stack.isEmpty()){
      String top = stack.pollFirst();
      if (!top.equals("+") && !top.equals("-") ){
        result = Integer.parseInt(top);
      }
      else if (top.equals("+")){
        result += Integer.parseInt(stack.pollFirst());
      }
      else {
        result -= Integer.parseInt(stack.pollFirst());
      }
    }
    return result;
  }

  public static void main(String[] args) {
    String s = "36/6/3/2";
    System.out.println(calculate(s));
  }
}
