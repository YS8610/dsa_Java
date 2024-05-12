import java.util.ArrayList;
import java.util.List;

public class lc682 {
  
  public static void main(String[] args) {
    String[] ops = {"-60","D","-36","30","13","C","C","-33","53","79"};

    List<Integer> ans = new ArrayList<>( );

    for (int i=0, n=ops.length; i<n;i++){
      try{
        int a = Integer.parseInt(ops[i]);
        ans.add(a);
      }
      catch(NumberFormatException e){
        switch (ops[i]){
          case "+":
            ans.add(ans.get(ans.size()-1) + ans.get(ans.size()-2) );
            break;
          case "D":
            ans.add(ans.get(ans.size()-1) *2);
            break;
          case "C":
            ans.remove(ans.size()-1);
            break;
        }
      }
      System.out.println(ans.toString());
      int sumAns = ans.stream().mapToInt(Integer::valueOf).sum();
      System.out.println(sumAns);
    }

  }
}
