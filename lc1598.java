import java.util.ArrayDeque;
import java.util.Deque;

public class lc1598 {
  private static int minOperations(String[] logs) {
    Deque<String> stack = new ArrayDeque<>();
    for (String l:logs){
      if (l.charAt(0) >= 'a' && l.charAt(0) <='z') stack.add(l);
      else if (l.charAt(0) >= '0' && l.charAt(0) <='9') stack.add(l);
      else if (l.equals("../") && !stack.isEmpty()) stack.removeLast(); 
    }
    return stack.size();
  }

  public static void main(String[] args) {
    String[] logs = {"d1/","d2/","./","d3/","../","d31/"};
    System.out.println(minOperations(logs));
  }
}
