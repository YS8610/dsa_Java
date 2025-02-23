import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class lc47 {
  private static List<List<Integer>> permuteUnique(int[] nums){
    List<List<Integer>> ans = new ArrayList<>();

    if ( nums.length==0) return new ArrayList<>();
    if (nums.length == 1 ) {
      List<Integer> numTemp = Arrays.asList(nums[0]);
      List<List<Integer>> a = new ArrayList<>();
      a.add(numTemp);
      return new ArrayList<>( a ); 
    }
    
    int len = nums.length;
    int[] numsSmall = new int[len-1];
    int numRemoved = nums[len-1];
    for (int i=0, n=numsSmall.length; i<n;i++){
      numsSmall[i] = nums[i];
    }
    List<List<Integer>> results = permuteUnique(numsSmall);
    if (!results.isEmpty()){
      for (List<Integer> result : results){
        for(int j=0, m=result.size(); j<m;j++){
          List<Integer> resultClone = new ArrayList<>(result);
          resultClone.add(j, numRemoved);
          ans.add(new ArrayList<>(resultClone));
        }
        List<Integer> resultClone = new ArrayList<>(result);
        resultClone.add(numRemoved);
        ans.add(new ArrayList<>(resultClone));
      }
    }
    Set<List<Integer>> ansSet = new HashSet<>();
    for (List<Integer> a : ans){
      ansSet.add(new ArrayList<>(a));
    }
    List<List<Integer>> ansUnique = new ArrayList<>( ansSet.stream()
                                                            .map(ArrayList::new)
                                                            .collect(Collectors.toList()) );

    return ansUnique;
  }
  public static void main(String[] args) {
    int[] nums = {1,1,2,2};
    System.out.println( permuteUnique(nums).toString() );
  }
}
