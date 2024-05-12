import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class lc628 {
  
  public static void main(String[] args) {
    int[] nums = {-1,-2,-3,0,1,7,8};
    int ans = 1;
    List<Integer> numsL = new ArrayList<>( Arrays.stream(nums).boxed().toList()); 
    List<Integer> max3 = new ArrayList<>();
    // List<Integer> numsLPos = new ArrayList<>(numsL.stream().filter(x -> x >= 0).toList());
    List<Integer> numsLNeg = new ArrayList<>(numsL.stream().filter(x -> x < 0).toList());


    int negCount = numsLNeg.size();

    for(int i=0;i<3;i++){
      max3.add(Collections.max(numsL));
      numsL.remove(Collections.max(numsL));
    }
    for (int j : max3){
      ans *= j;
    }
    
    if (negCount<=0 || negCount == nums.length || negCount==1 ){

      System.out.println(ans);
    }
    else{
      numsLNeg.sort((m1,m2) -> m1.compareTo(m2));
      System.out.println(numsLNeg.toString());
      int ans1 = numsLNeg.get(0)*numsLNeg.get(1)*  max3.get(0);
      System.out.println(ans1);
      if (ans == ans1){
        System.out.println(ans);
      }
      else{
        System.out.println(ans>ans1?ans:ans1);
      }
    }

  }
  

  



}
