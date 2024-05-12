import java.util.ArrayDeque;
import java.util.Deque;

public class lc20 {
  private static boolean isValid(String s){

    Deque<String> stack = new ArrayDeque<String>();
    for (int i=0,n=s.length();i<n;i++){
      if (n==1) return false;
      char c = s.charAt(i);
      if ( c == '}' || c == ')' || c == ']' ){
        if (stack.isEmpty()) return false;
        String cS = String.valueOf(c);
        String stackTop = stack.peek();
        if ( cS.equals("}") && !stackTop.equals("{")) return false;
        else if ( cS.equals(")") && !stackTop.equals("(")) return false;
        else if ( cS.equals("]") && !stackTop.equals("[")) return false;
        else stack.pop();
      }
      else{
        stack.push( String.valueOf(c) );
      }
    }
    return stack.isEmpty()?true:false;
  }

  public static void main(String[] args) {
    String s = "{[]}";
    System.out.println( isValid(s));
  }
}
