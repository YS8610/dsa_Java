import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc436 {
  private static int[] findRightInterval(int[][] intervals)  {
    int n = intervals.length;
    Map<List<Integer>,Integer> map = new HashMap<>();
    int[][] clone = new int[n][2];
    for(int i =0; i<n;i++) {
      map.put(List.of(intervals[i][0],intervals[i][1]),i);
      clone[i][0] = intervals[i][0];
      clone[i][1] = intervals[i][1];
    }
    Arrays.sort(clone, (m1,m2)-> {
      if(m1[0]==m2[0] ) return Integer.compare(m1[1], m2[1]);
      return Integer.compare(m1[0], m2[0]);
    });
    int[] ans = new int[n];
    int pos;
    for (int i=0;i<n;i++){
      if (intervals[i][0]==intervals[i][1]){
        ans[i]=i;
        continue;
      }
      pos = Arrays.binarySearch(clone, new int[]{intervals[i][1],1}, (m1,m2)-> Integer.compare(m1[0], m2[0]));
      if (pos<0 && (pos+1)*-1>=n) ans[i] =-1;
      else if (pos<0 && (pos+1)*-1<n) {
        ans[i] =  map.get(List.of(clone[(pos+1)*-1][0], clone[(pos+1)*-1][1]));
      }
      else ans[i] =  map.get(List.of(clone[pos][0], clone[pos][1]));
    }
    return ans;
  }

  private static int[] findRightInterval1(int[][] intervals)  {
    int n = intervals.length;
    Map<Integer,Integer> map = new HashMap<>();
    int[][] clone = new int[n][2];
    for(int i =0; i<n;i++) {
      map.put(intervals[i][0],i);
      clone[i][0] = intervals[i][0];
      clone[i][1] = intervals[i][1];
    }
    Arrays.sort(clone, (m1,m2)-> {
      if(m1[0]==m2[0] ) return Integer.compare(m1[1], m2[1]);
      return Integer.compare(m1[0], m2[0]);
    });
    int[] ans = new int[n];
    int pos;
    for (int i=0;i<n;i++){
      if (intervals[i][0]==intervals[i][1]){
        ans[i]=i;
        continue;
      }
      pos = Arrays.binarySearch(clone, new int[]{intervals[i][1],1}, (m1,m2)-> Integer.compare(m1[0], m2[0]));
      if (pos<0 && (pos+1)*-1>=n) ans[i] =-1;
      else if (pos<0 && (pos+1)*-1<n) {
        ans[i] =  map.get(clone[(pos+1)*-1][0]);
      }
      else ans[i] =  map.get(clone[pos][0]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] intervals = {{4,5},{2,3},{1,2}};
    System.out.println( Arrays.toString(findRightInterval(intervals)));
    System.out.println( Arrays.toString(findRightInterval1(intervals)));
  }
}
