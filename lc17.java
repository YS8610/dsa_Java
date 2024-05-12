import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc17 {
  private static List<String> letterCombinations(String digits){
    List<String> ans = new ArrayList<>();
    if (digits.equals("")) return new ArrayList<>();
    if (digits.equals("2")) return new ArrayList<>( Arrays.asList("a","b","c") );
    if (digits.equals("3")) return new ArrayList<>( Arrays.asList("d","e","f") );
    if (digits.equals("4")) return new ArrayList<>( Arrays.asList("g","h","i") );
    if (digits.equals("5")) return new ArrayList<>( Arrays.asList("j","k","l") );
    if (digits.equals("6")) return new ArrayList<>( Arrays.asList("m","n","o") );
    if (digits.equals("7")) return new ArrayList<>( Arrays.asList("p","q","r","s") );
    if (digits.equals("8")) return new ArrayList<>( Arrays.asList("t","u","v") );
    if (digits.equals("9")) return new ArrayList<>( Arrays.asList("w","x","y","z") );
    
    String result = digits.substring(0, digits.length()-1);
    for (String a : letterCombinations(result)){
      for (String b : letterCombinations( String.valueOf( digits.charAt(digits.length()-1) ) ) )
      ans.add( a + b );
    }

    return ans;
  }

  public static void main(String[] args) {
    String digits = "";
    System.out.println( letterCombinations(digits).toString() );
  }
}
