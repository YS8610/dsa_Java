import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc22 {
  private static List<String> generateParenthesis(int n) {
    List<String> ans = new ArrayList<>();
    dfs(n*2, "(", ans);
    return ans;
  }

  private static boolean valid(String a){
    int l = a.length();
    Deque<Character> stack = new ArrayDeque<>();
    for (int i =0; i<l;i++){
      if (a.charAt(i)=='(') {
        stack.add(a.charAt(i));
        continue;
      }
      if (a.charAt(i)== ')'){
        if (!stack.isEmpty()) stack.removeLast();
        else return false;
      }
    }
    return stack.isEmpty()?true:false;
  }

  private static boolean pValid(String a){
    int l = a.length();
    Deque<Character> stack = new ArrayDeque<>();
    for (int i =0; i<l;i++){
      if (a.charAt(i)=='(') {
        stack.add(a.charAt(i));
        continue;
      }
      if (a.charAt(i)== ')'){
        if (!stack.isEmpty()) stack.removeLast();
        else return false;
      }
    }
    return (stack.isEmpty() || stack.peekLast()=='(')?true:false;
  }

  private static void dfs(int i, String a ,List<String>ans){
    if (a.length()>=i){
      if (valid(a)) ans.add(a);
      return;
    }
    dfs(i, a+"(", ans);
    if (pValid(a+")")) dfs(i, a+")", ans);
  }

  public static void main(String[] args) {
    int n = 9;
    System.out.println(generateParenthesis(n));
  }
}
