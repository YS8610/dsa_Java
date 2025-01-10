import java.util.Arrays;

public class lc2940 {
	private static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {

		return null;
	}

	private static int qResult(int[] heights, int[] q){
		int l = heights.length;
		int a = q[0];
		int b = q[1];
		while (a <l && b <l){


			if (a==b) return b;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] heights = {6,4,8,5,2,7}; 
		int[][] queries = {{0,1},{0,3},{2,4},{3,4},{2,2}};
		System.out.println(Arrays.toString(leftmostBuildingQueries(heights, queries)));
	}
}
