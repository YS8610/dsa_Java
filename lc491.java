import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class lc491 {

  private static List<List<Integer>> findSubsequences(int[] nums) {
    int len = nums.length;
    List<List<Integer>> dp = new ArrayList<>(len);
    int rp;
    List<Integer>temp;
    int tmpLen;
    Set<List<Integer>> pAns= new HashSet<>();
    for (int i=0;i<len;i++){
      rp=i+1;
      while(rp<len){
        if (!dp.isEmpty()){
          for (int j=0,n=dp.size();j<n;j++){
            tmpLen = dp.get(j).size();
            if (dp.get(j).get(tmpLen-1)<=nums[rp]){
              temp = new ArrayList<>(dp.get(j));
              temp.add(nums[rp]);
              dp.add(temp);
            }
          }
        }
        if (nums[i]<=nums[rp]) dp.add(List.of(nums[i], nums[rp]));
        rp++;
      }
      pAns.addAll( dp.stream().map(ArrayList::new).collect(Collectors.toList()) );
      dp.clear();
    }
    return new ArrayList<>(pAns);
  }

  public static void main(String[] args) {
    int[] nums = { 1,2,3,4,1,1,1 };
    System.out.println(findSubsequences(nums).toString());
  }
}
