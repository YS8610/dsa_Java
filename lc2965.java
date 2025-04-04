import java.util.Arrays;

class lc2965 {
    static public int[] findMissingAndRepeatedValues(int[][] grid) {
        int l = grid.length;
        int r = grid.length;
        int n = l*r;
        int[] map = new int[n+1];
        for (int[] row : grid)
            for (int num: row)
                map[num]++;
        int[] ans = new int[2]; 
        for (int i=1;i<=n;i++){
            if (map[i] == 0)
                ans[1] = i;
            if (map[i] == 2)
                ans[0] = i;
        }
        return ans;
    }
	
	public static void main(String[] args){
		int[][] grid = {{1,3},{2,2}};
		System.out.println(Arrays.toString(findMissingAndRepeatedValues(grid)));
	}
}
