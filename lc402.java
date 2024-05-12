import java.util.ArrayDeque;
import java.util.Deque;

public class lc402 {
  static private String removeKdigits(String num, int k){
    Deque<Character> stack = new ArrayDeque<>();
    int l = num.length();
    char top;
    if (l == k) return "0";
    for (int i =0;i<l;i++){
      if (stack.isEmpty()) {
        stack.add(num.charAt(i));
        continue;
      }
      top = stack.peekLast();
      if (top < num.charAt(i)) {
        stack.add(num.charAt(i));
        continue;
      }
      while (!stack.isEmpty() && top > num.charAt(i) && k > 0){
        stack.removeLast();
        k--;
        if (!stack.isEmpty()) top = stack.peekLast();
      }
      stack.add(num.charAt(i));
    }
    while (!stack.isEmpty() && k>0){
      stack.removeLast();
      k--;
    }
    if (stack.isEmpty()) return "0";
    top = stack.peekFirst();
    while (!stack.isEmpty() && top == '0'){
      stack.removeFirst();
      if (!stack.isEmpty()) top = stack.peek();
    }
    if (stack.isEmpty()) return "0";
    StringBuilder ans = new StringBuilder( stack.size());
    while (!stack.isEmpty()) ans.append(stack.removeFirst());
    
    return ans.toString();
  }


  public static void main(String[] args) {
    String num = "451278";
    // String num = "548912";
    // String num = "90909650";
    int k = 3;
    System.out.println( removeKdigits(num,k) );
  }
}
