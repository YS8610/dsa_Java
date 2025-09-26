import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class lc1233 {

  private static List<String> removeSubfolders(String[] folder) {
    int l = folder.length;
    Arrays.sort(folder);
    List<String> ans = new ArrayList<>(l);
    ans.add(folder[0]);
    String prefix;
    for (int i = 1; i < l; i++) {
      prefix = ans.get(ans.size() - 1);
      if (folder[i].startsWith(prefix) &&
          folder[i].length() > prefix.length() &&
          folder[i].charAt(prefix.length()) == '/')
        continue;
      ans.add(folder[i]);
    }
    return ans;
  }

  public List<String> removeSubfolders1(String[] folder) {
    Deque<String> stack = new ArrayDeque<>();
    int l = folder.length;
    String top;
    Arrays.sort(folder);
    stack.add(folder[0]);
    for (int i = 1; i < l; i++) {
      top = stack.peekLast();
      if (folder[i].startsWith(top) && folder[i].charAt(top.length()) == '/')
        continue;
      stack.add(folder[i]);
    }
    List<String> ans = new ArrayList<>(stack.size());
    while (!stack.isEmpty())
      ans.add(stack.poll());
    return ans;
  }

  public static void main(String[] args) {
    String[] folder = { "/a", "/a/b/c", "/a/b/d" };
    System.out.println(removeSubfolders(folder).toString());
  }
}
