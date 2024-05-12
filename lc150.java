import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class lc150 {

  private static int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    for (String a : tokens) {
      Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "/", "*"));
      if (!operators.contains(a)) stack.add(Integer.valueOf(a)); 
      else {
        if (a.equals("+")){
          int a1 = stack.pollLast();
          int a2 = stack.pollLast();
          stack.add(a2+a1);
        }
        else if ( a.equals("-")){
          int a1 = stack.pollLast();
          int a2 = stack.pollLast();
          stack.add(a2-a1);
        }
        else if ( a.equals("*")){
          int a1 = stack.pollLast();
          int a2 = stack.pollLast();
          stack.add(a2*a1);
        }
        else {
          int a1 = stack.pollLast();
          int a2 = stack.pollLast();
          stack.add(a2/a1);
        }
      }
    }
    return stack.peekLast();
  }

  public static void main(String[] args) {
    String[] tokens = {"10" };
    System.out.println(evalRPN(tokens));
  }
}
