import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class lc826 {
  
  private static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker){
    int n = difficulty.length;
    int m = worker.length;
    List<List<Integer>> combined = new ArrayList<>(n);
    for (int i=0; i<n;i++) combined.add(List.of(difficulty[i], profit[i]));
    combined.sort( (m1,m2)-> m1.get(0).compareTo(m2.get(0)) );
    for (int i=0; i<n;i++) difficulty[i] = combined.get(i).get(0);
    for (int i=0; i<n;i++) profit[i] = combined.get(i).get(1);
    Arrays.sort(worker);
    PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());
    if (worker[m-1]<difficulty[0]) return 0;
    int maxProfit = 0;
    for (int w:worker){
      if (w<difficulty[0]) continue;
      int index = Arrays.binarySearch(difficulty, w);
      if (index>=0){
        int temp = index;
        while (temp>=0){
          index = temp;
          temp = Arrays.binarySearch(difficulty, temp+1, n, w);
        }
      }
      int sizeofQ = (index>=0?index:-1*index-1-1)+1;
      while (q.size()<sizeofQ && q.size()<=n){
        int a = q.size();
        q.offer( profit[a]);
      }
      maxProfit += q.peek();
    }
    return maxProfit;
  }



  public static void main(String[] args) {
    int[] difficulty = {23,30,35,35,43,46,47,81,83,98};
    int[] profit = {8,11,11,20,33,37,60,72,87,95};
    int[] worker = {95,46,47,97,11,35,99,56,41,92};
    System.out.println( maxProfitAssignment(difficulty, profit, worker) );
  }
}
