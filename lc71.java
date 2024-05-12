import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc71 {
  
  private static String simplifyPath(String path) {
    String[] pathArray = path.split("/");
    Deque<String> stack = new ArrayDeque<>();
    for(String str : pathArray){
      if (str.equals("")||str.equals("."))continue;
      if (str.equals("..")) {
        if (!stack.isEmpty()) stack.removeLast();
      }
      else stack.add(str);
    }
    if (stack.isEmpty()) return "/";
    List<String> ansArray = new ArrayList<>();
    while(!stack.isEmpty()){
      ansArray.add("/");
      ansArray.add(stack.pollFirst());
    }
    return String.join("", ansArray);
  }

  public static void main(String[] args) {
    String path = "/home/../fd/./rer";
    System.out.println( simplifyPath(path) );
  }
}
