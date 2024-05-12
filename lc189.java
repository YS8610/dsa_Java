import java.util.Arrays;
import java.util.LinkedList;

public class lc189 {
  private static void rotate1(int[] nums, int k){
    LinkedList<Integer> a = new LinkedList<>( Arrays.stream(nums).boxed().toList() );
    for (int i=0;i<k;i++){
      int last = a.removeLast();
      a.addFirst(last);
    }
    for (int i=0,n=nums.length; i<n; i++){
      nums[i] = a.get(i);
    }
    return;
  }
  private static void rotate(int[] nums, int k){
    int[] extra = new int[k];
    int len = nums.length;
    if (k>len) k = k%len;
    for (int i=len-k,n=0; n<k; i++,n++){
      extra[n] = nums[i];
    }
    for (int i=len-1-k;i>=0;i--){
      nums[i+k] = nums[i];
    }
    for (int i=0; i<k; i++){
      nums[i] = extra[i];
    }
  }

  public static void main(String[] args) {
    int[] nums = {-1,-100,3,99};
    int k = 2;
    rotate(nums,k );
    System.out.println(  Arrays.toString(nums));
  }
}
