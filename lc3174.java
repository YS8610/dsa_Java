import java.util.Deque;
import java.util.ArrayDeque;

class lc3174{

  private static String clearDigits(String s) {
    Deque<Character> stack = new ArrayDeque<>();
    int l = s.length();
    StringBuilder ans = new StringBuilder();
    char tmp;
    for (int i =0;i<l;i++){
      tmp = s.charAt(i);
      if (stack.isEmpty() || Character.isLetter(tmp)){
        stack.add(tmp);
        continue;
      }
      stack.pollLast();
    }
    while (!stack.isEmpty())
      ans.append(stack.pollFirst());
    return ans.toString();
  }

  public static void main(String[] args){
    String s = "abc";
    System.out.println(clearDigits(s));
  }
}
