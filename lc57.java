import java.util.Arrays;

public class lc57 {
  private static int[][] insert(int[][] intervals, int[] newInterval){
    int pos = Arrays.binarySearch(intervals, newInterval, (m1,m2) ->  Integer.compare(m1[0], m2[0]) );
    int posEnd = Arrays.binarySearch(intervals, newInterval, (m1,m2) ->  Integer.compare(m1[1], m2[1]) );
    int n = intervals.length;
    int[] merged = new int[2];
    // new interval 1st element is present
    if (pos>=0) merged[0]=newInterval[0];
    // newinterval 1st element is absent
    else{
      int insertedPos = (pos+1)*-1;
      if (insertedPos==0) merged[0]=newInterval[0];
      else{
        // pos is within interval
        if (intervals[insertedPos-1][1]>=newInterval[0]){
          merged[0]=intervals[insertedPos-1][0];
        }
        else merged[0] = newInterval[0];
      }
    }
    // newInterval 2nd element is present
    if (posEnd>=0) merged[1] = newInterval[1];
    // newInterval 2nd element is absent
    else{
      int insertedPosEnd = (posEnd+1)*-1;
      if (insertedPosEnd>=n) merged[1] = newInterval[1];
      else if (intervals[insertedPosEnd][0]>newInterval[1]){
          merged[1] = newInterval[1];
      }
      // intervals[insertedPosEnd][0]<=newInterval[1]
      else merged[1] = intervals[insertedPosEnd][1];
    }
    // after obtaining merged int[]
    int mergedPos = Arrays.binarySearch(intervals, merged, (m1,m2) ->  Integer.compare(m1[0], m2[0]) );
    int mergedPosEnd = Arrays.binarySearch(intervals, merged, (m1,m2) ->  Integer.compare(m1[1], m2[1]) );
    int[][] ans1, ans2;
    // create first part ans
    if (mergedPos==0){
      ans1 = new int[1][2];
      ans1[0] = merged;
    }
    else if ( mergedPos>0){
      ans1 = new int[mergedPos+1][2];
      for (int i =0; i<mergedPos;i++) ans1[i]=intervals[i];
      ans1[mergedPos] = merged;
    }
    else{
      int insertedPos = (mergedPos+1)*-1;
      ans1 = new int[insertedPos+1][2];
      for (int i=0; i<insertedPos;i++) ans1[i] = intervals[i];
      ans1[insertedPos] = merged;
    }
    // create 2nd part ans
    if (mergedPosEnd==n-1) return ans1;
    else if ( mergedPosEnd>=0){
      ans2 = new int[n-mergedPosEnd-1][2];
      int j=0;
      for (int i=mergedPosEnd+1;i<n;i++){
        ans2[j] = intervals[i];
        j++;
      }
    }
    // else if (mergedPosEnd<0)
    else {
      int actualMergedPosEnd = (mergedPosEnd+1)*-1;
      if (actualMergedPosEnd>=n) return ans1;
      else {
        ans2 = new int[n-actualMergedPosEnd][2];
        int j=0;
        for (int i=actualMergedPosEnd;i<n;i++){
          ans2[j] = intervals[i];
          j++;
        }
      }
    }
    int[][] result = Arrays.copyOf(ans1, ans1.length + ans2.length);
    System.arraycopy(ans2, 0, result, ans1.length, ans2.length);
    return result;
  }



  public static void main(String[] args) {
    int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16},{18,24}};
    int[] newInterval = {0,5};
    // System.out.println( Arrays.deepToString(insert(intervals, newInterval)) );
    System.out.println( Arrays.deepToString(insert(intervals, newInterval)) );
  }

}
