import java.util.Comparator;
import java.util.PriorityQueue;

public class lc2558 {
  public long pickGifts(int[] gifts, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		for (int g:gifts) pq.add(g);
		long ans = 0;
		int tmp;
		for (int i = 0; i<k && !pq.isEmpty();i++){
			tmp = pq.poll();
			pq.add((int) Math.sqrt(tmp));
			if (tmp == 1) break;
		}
		while (!pq.isEmpty())
			ans+= pq.poll();
		return ans;
  }
}
