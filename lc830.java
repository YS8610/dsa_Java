import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc830 {
  public static void main(String[] args) {
    String s = "a";

    int count=0;
    List<List<Integer>> ans = new ArrayList<>();

    for (int i =0, n = s.length();i<n;i++){
      if (i==s.length()-1){
        if (i==0){
          System.out.println(ans);
        }
        else if (s.charAt(i)==s.charAt(i-1)){
          count++;
          if (count>=2){
            if (i-(i-count+1)<2) System.out.println(ans);
            ans.add(new ArrayList<Integer>(Arrays.asList(i-count+1,i)));
          }
          break;
        } 
      }
      else if (s.charAt(i)==s.charAt(i+1)){
        count ++;
      }
      else{
        if (count>=2){
          ans.add(new ArrayList<Integer>(Arrays.asList(i-count,i)));
        } 
        count=0;
      }
    }
    System.out.println(ans.toString());
  }
}
