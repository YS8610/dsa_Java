import java.util.Comparator;
import java.util.PriorityQueue;

public class lc502 {
  
  private static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    PriorityQueue<int[]> minheap = new PriorityQueue<>((m1,m2)->{
      if (m1[1] == m2[1]) return Integer.compare((int)m2[0], m1[0]);
      return Integer.compare(m1[1], m2[1]);
    });
    PriorityQueue<Integer> maxheap = new PriorityQueue<>(Comparator.reverseOrder());
    int l = profits.length;
    for (int i=0;i<l;i++){
      minheap.add(new int[]{profits[i], capital[i]});
    }
    while (!minheap.isEmpty() && k >0 && minheap.peek()[1] <=w){
      while (!minheap.isEmpty() && minheap.peek()[1] <=w){
        maxheap.add(minheap.poll()[0]);
      }
      while (!maxheap.isEmpty() && k > 0){
        w += maxheap.poll();
        k--;
        while (!minheap.isEmpty() && minheap.peek()[1] <=w){
          maxheap.add(minheap.poll()[0]);
        }
      }
    }
    return w;
  }

  public static void main(String[] args) {
    int k = 2, w = 0;
    int[] profits = {1,2,3}, capital = {0,9,10};
    System.out.println(findMaximizedCapital(k, w, profits, capital));
  }
}
