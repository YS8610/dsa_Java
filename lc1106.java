import java.util.ArrayDeque;
import java.util.Deque;

public class lc1106 {
  private static boolean isOperator(char a){
    if (a=='&' || a=='|' || a=='!') return true;
    return false;
  }

  private static boolean parseBoolExpr(String expression) {
    int t = 0;
    int f = 0;
    char top;
    if (expression.length() == 1 && expression.charAt(0)=='t')
      return true;
    if (expression.length() == 1 && expression.charAt(0)=='f')
      return false;
    Deque<Character> stack = new ArrayDeque<>();
    for (int i=0, n=expression.length();i<n;i++){
      if (stack.isEmpty() || expression.charAt(i)!=')') {
        stack.add(expression.charAt(i));
        continue;
      }
      t=0;
      f=0;
      while (!stack.isEmpty() && !isOperator(stack.peekLast())){
        top = stack.pollLast();
        if (top=='t') t++;
        if (top=='f') f++;
      }
      top = stack.pollLast();
      if (top == '|'){
        if (t > 0) stack.add('t');
        else stack.add('f');
      }
      else if (top == '&'){
        if (f > 0) stack.add('f');
        else stack.add('t'); 
      }
      else{
        if (t==0) stack.add('t');
        else stack.add('f');
      }
    }
    return stack.peekLast()=='t'?true:false;
  }

  public static void main(String[] args) {
    String expression = "|(f,f,f,t)";
    System.out.println(parseBoolExpr(expression));
  }
}
