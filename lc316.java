import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class lc316 {
  private static String removeDuplicateLetters(String s){
    int l = s.length();
    char top;
    int[] memo = new int[26];
    for (int i =0;i<l;i++)
      memo[s.charAt(i)-'a'] +=1;
    boolean[] visited = new boolean[26];
    Arrays.fill(visited, false);
    Deque<Character> stack = new ArrayDeque<>();
    for (int i =0;i<l;i++){
      if (stack.isEmpty() ) {
        stack.add(s.charAt(i));
        visited[s.charAt(i)-'a'] = true;
        continue;
      }
      if (visited[s.charAt(i)-'a']) continue;
      top = stack.peekLast();
      while (!stack.isEmpty() && top > s.charAt(i) && memo[top-'a'] >1){
        stack.removeLast();
        memo[top-'a']--;
        if (!stack.isEmpty()) top = stack.peekLast();
      }
      visited[s.charAt(i)-'a'] = true;
      stack.add(s.charAt(i));
    }

    StringBuilder ans = new StringBuilder(stack.size());
    while (!stack.isEmpty()){
      ans.append(stack.remove());
    }
    return ans.toString();
  }

  public static void main(String[] args) {
    String s = "abacb";
    System.out.println( removeDuplicateLetters(s) );
  }
}
