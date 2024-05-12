import java.util.Stack;

public class lc678 {

  private static boolean checkValidString(String s) {
    Stack<Character> a = new Stack<>();
    int l = s.length();
    int count = 0;
    char top;
    // clear ')'
    for (int i = 0; i < l; i++) {
      if (s.charAt(i) == '(' || s.charAt(i) == '*') {
        a.add(s.charAt(i));
        continue;
      }
      if (a.isEmpty()) return false;
      count = 0;
      top = a.peek();
      while (!a.isEmpty() && top == '*') {
        a.pop();
        count++;
        if (!a.isEmpty()) top = a.peek();
      }
      if (!a.isEmpty()) a.pop(); else count--;
      while (--count >= 0) a.add('*');
    }
    if (!a.isEmpty() && a.peek() == '(') return false;
    // clear '('
    count = 0;
    while (!a.isEmpty()) {
      top = a.peek();
      while (!a.isEmpty() && top == '*') {
        a.pop();
        count++;
        if (!a.isEmpty()) top = a.peek();
      }
      // if (a.isEmpty()) return true;
      while (!a.isEmpty() && top == '(') {
        a.pop();
        count--;
        if (!a.isEmpty()) top = a.peek();
        if (count <= 0) break;
      }
      if (!a.isEmpty() && a.peek() == '(') return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "(*))";
    System.out.println(checkValidString(s));
  }
}
