import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc844 {

  private static String backsp(String a){
    List<String> sS = new ArrayList<>( Arrays.asList( a.split("") ) );
    while(sS.contains("#")){
      int ind = sS.indexOf("#");
      if (ind == 0) sS.remove(0);
      else{
        sS.remove(ind-1);
        sS.remove(ind-1);
      }
    }
      return String.join("",sS);
  }

  public static void main(String[] args) {
    String s = "ab##c", t = "ad##c";

    System.out.println( backsp(s).equals(backsp(t)) );

  }
}
