import java.util.ArrayDeque;
import java.util.Deque;

public class lc2390 {
  private static String removeStars(String s) {
    Deque<String> stack = new ArrayDeque<>();
    String[] a = s.split("");
    for(String c : a){
      if (!c.equals("*")) stack.push(c);
      else if (c.equals("*") && !stack.isEmpty()) stack.pop();
    }
    String ans = "";
    while(!stack.isEmpty()){
      ans = stack.pop() + ans;  
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "erase******";
    System.out.println( removeStars(s) );
  }
}
