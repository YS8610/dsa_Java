import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class lc228 {
  
  private static List<String> summaryRanges(int[] nums) {
    Deque<Integer> q =new ArrayDeque<Integer>();
    List<String> ans = new ArrayList<>();
    int n = nums.length;
    if (n==0) return new ArrayList<>();
    if (n==1) return new ArrayList<>( List.of( String.valueOf(nums[0]) ));
    for (int num:nums){
      if (q.isEmpty()) q.add(num);
      else{
        if (Math.abs(num - q.peekLast()) >1) {
          String a = String.valueOf(q.poll());
          String b = "";
          while(!q.isEmpty()) b= String.valueOf(q.poll());
          if (b.isEmpty()) ans.add(a);
          else ans.add(a + "->" + b);
        }
        q.add(num);
      }
    }
    String c="";
    String d="";
    if (!q.isEmpty()) c = String.valueOf(q.poll()) ;
    while(!q.isEmpty()) d= String.valueOf(q.poll());
    if (d.isEmpty()) ans.add(c);
    else ans.add(c + "->" + d);
    return ans;
  }
// 2 pointer 
  private static List<String> summaryRanges1(int[] nums) {
    int n = nums.length;
    if (n==0) return new ArrayList<>();
    if (n==1) return new ArrayList<>( List.of( String.valueOf(nums[0]) ));
    List<String> ans = new ArrayList<>();
    String a = "";
    String b ="";
    outloop:
    for(int i=0;i<n;i++){
      a = String.valueOf(nums[i]);
      b= "";
      for (int j=i+1;j<n;j++){
        if ( nums[i]-i == nums[j]-j ) b= String.valueOf(nums[j]);
        else {
          i=j-1;
          if (b.isEmpty()) ans.add(a);
          else ans.add(a + "->"+b );
          break;
        }
        i=j-1;
        if (j==n-1) break outloop;
      }
    }
    if (b.isEmpty()) ans.add(a);
    else ans.add(a + "->"+b );
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {-2147483648,-2147483647,2147483647};
    System.out.println( summaryRanges(nums) );
    System.out.println( summaryRanges1(nums) );
  }
}
