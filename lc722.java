import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class lc722 {
  
  private static List<String> removeComments(String[] source) {
    Deque<Character> stack = new ArrayDeque<>();
    List<String> ans = new ArrayList<>();
    Pattern p1 = Pattern.compile("\\/\\/");
    Pattern p2 = Pattern.compile("\\/\\*|\\*\\/");

    for (int i=0, n=source.length; i<n;i++ ){
      Matcher m1 = p1.matcher(source[i]);
      Matcher m2 = p2.matcher(source[i]);
      if ( m1.find() ){
        int index = m1.start();
        String s = source[i].substring(0, index);
        if (!s.isBlank()) ans.add(s);
      }
      else if ( m2.find() ){
        int index = m2.start();
        String s = source[i].substring(0, index);
        if (!s.isBlank()) ans.add(s);

        String sProcessed = source[i].substring(index);
        char[] charA = sProcessed.toCharArray();
        matchComment(stack, charA);
        while (!stack.isEmpty()){
          i++;
          char[] charB = source[i].toCharArray();
          matchComment(stack, charB);
        }
        // Matcher m22 = p2.matcher(source[i]);
        // index = m22.start();
        // s = source[i].substring(index+1);
        // if (!s.isEmpty()) ans.add(s);
      }
      else ans.add(source[i]);
    }
    return ans;
  }

  private static void matchComment(Deque<Character> stack, char[] charA){
    for (int j=0,m=charA.length;j<m;j++){
      if (charA[j]=='/' && charA[j+1]=='*'){
        stack.push(charA[j]);
        stack.push(charA[j+1]);
        j++;
      }
      if ( !stack.isEmpty() && charA[j]=='*' && charA[j<m-1?j+1:j]=='/' ){
        stack.pop();
        stack.pop();
      }
    }
  }
  public static void main(String[] args) {
    
    String[] source = {"1/*Test program */2", "int main()", "{ ", "  12  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
    System.out.println( removeComments(source) );
  }
}
