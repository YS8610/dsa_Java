import java.util.Arrays;

public class lc58 {
  
  public static void main(String[] args) {
    String s = "   fly me   to   the moon  ";
    String[] processed = s.trim().split(" ");
    processed =  Arrays.stream(processed)
                      .filter(x-> x!="" )
                      .toArray(String[]::new);
    String s1 = processed[processed.length-1];
    System.out.println(Arrays.toString(processed));
    System.out.println(s1.length());
  }
}
