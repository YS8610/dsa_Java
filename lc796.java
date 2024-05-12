import java.util.Arrays;
import java.util.LinkedList;

public class lc796 {
  private static boolean rotateString(String s, String goal){
    if (s.length() != goal.length()) return false;
    if (s.equals(goal)) return true;
    
    String[] sA = s.split("");
    String[] gA = goal.split("");
    
    LinkedList<String> sL = new LinkedList<>( Arrays.stream(sA).toList() );
    LinkedList<String> gL = new LinkedList<>( Arrays.stream(gA).toList() );
    for (int i= 0, n=sA.length-1;i<n;i++){
      sL.addLast(sL.getFirst());
      sL.removeFirst();
      if (sL.equals(gL)) return true;
    }
    return false;
  }
  public static void main(String[] args) {
    String s = "abcde", goal = "cdeab";
    System.out.println( rotateString(s, goal) );
  }
}
