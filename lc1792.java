import java.util.PriorityQueue;

class lc1792{
	private static double maxAverageRatio(int[][] classes, int extraStudents) {
		PriorityQueue<int[]> pq = new PriorityQueue<>(
			(m1,m2) -> Double.compare(diff1(m2), diff1(m1))
		);
		double ans = 0;
		int[] tmp;
		for (int[] c :classes){
			if (c[0] == c[1]) continue;
			pq.add(c);
		}
		while (extraStudents > 0 && !pq.isEmpty()){
			tmp = pq.poll();
			tmp[0]++;
			tmp[1]++;
			pq.add(tmp);
			extraStudents--;
		}
		for (int[] c :classes)
			ans += c[0]/(double)c[1];
		return ans/(double)classes.length;
	}

	private static double diff1(int[] c){
		return (c[0]+1)/(double)(c[1]+1) - (c[0])/(double)(c[1]);
	}
	
	private static double diff(int[][] classes, int[] c){
		int l = classes.length;
		double ans = 0;
		for (int i=0; i<l;i++){
			if (classes[i] == c) continue;
			ans += classes[i][0]/(double)classes[i][1];
		}
		ans += (c[0]+1)/(double)(c[1]+1);
		return ans/l;
	}
	
	public static void main(String[] args){
		int[][] classes = {{1,2},{3,5},{2,2}};
		int extraStudents = 2;
		System.out.println(maxAverageRatio(classes, extraStudents));
	}
	
}