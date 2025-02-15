import java.util.Map;
import java.util.HashMap;

class lc1726{
  
  private static int tupleSameProduct(int[] nums) {
    int l = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    int tmp;
    for (int i =0; i<l;i++){
      for (int j =i+1;j<l;j++){
        tmp = nums[i]*nums[j];
        map.computeIfPresent(tmp, (k,v) -> v+1);
        map.computeIfAbsent(tmp, k -> 1);  
      }
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()){
      if (entry.getValue() == 1)
        continue;
      ans += entry.getValue() * (entry.getValue()-1) * 4;     
    }
    //System.out.println(map.toString());
    return ans;
  }

  public static void main(String[] args){
    int[] nums = {2,3,4,6};
    System.out.println(tupleSameProduct(nums));
  }

}
