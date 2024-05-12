import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class lc80 {
  
  private static int removeDuplicates(int[] nums){
    Map<Integer,Integer> memo = new LinkedHashMap<>();
    for (int num:nums){
      if (memo.containsKey(num)) memo.put(num, memo.get(num)>=2?2:memo.get(num)+1);
      else memo.put(num,1);
    }
    int counter = 0;
    for (int key : memo.keySet()){
      if (memo.get(key)==1) {
        nums[counter] = key;
        counter++;
      }
      else if ( memo.get(key) == 2){
        for (int i=0;i<2;i++ ){
          nums[counter+i] = key;
        }
        counter+=2;
      }
    }
    System.out.println( Arrays.toString(nums) );
    return counter;
  }

  public static void main(String[] args) {
    int[] nums = {0,0,1,1,1,1,2,3,3};
    System.out.println( removeDuplicates(nums) );
  }

}
