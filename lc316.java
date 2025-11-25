import java.util.ArrayDeque;
import java.util.Deque;

public class lc316 {
  private static String removeDuplicateLetters(String s){
		int[] map = new int[26];
		int l = s.length();
		for(int i=0; i<l;i++)
			map[s.charAt(i)-'a'] = i;
		Deque<Character> stack = new ArrayDeque<>();
		boolean[] visit = new boolean[26];
		for (int i =0; i<l;i++){
			if (stack.isEmpty()){
				stack.add(s.charAt(i));
				visit[s.charAt(i)-'a'] = true;
				continue;
			}
			if (visit[s.charAt(i)-'a']) continue;
			while (!stack.isEmpty() && stack.peekLast() > s.charAt(i) && map[stack.peekLast()-'a'] > i){
				visit[stack.pollLast()-'a']= false;
			}
			stack.add(s.charAt(i));
			visit[s.charAt(i)-'a'] = true;
		}
		StringBuilder ans = new StringBuilder();
		while (!stack.isEmpty())
			ans.append(stack.pollFirst());
		return ans.toString();
  }

public static void main(String[] args) {
    String s = "abacb";
    System.out.println(removeDuplicateLetters(s));
  }
}
