public class lc1267 {
  public int countServers(int[][] grid) {
		int ans = 0;
		int lr = grid.length;
		int lc = grid[0].length;
		int tmp;
		boolean[] row = new boolean[lr];
		boolean[] col = new boolean[lc];
		for (int r=0;r<lr;r++){
			tmp = 0;
			for(int c=0;c<lc;c++){
				tmp+=grid[r][c];
				if (tmp >=2){
					row[r] = true;
					break;
				}
			}
		}
		for (int c=0;c<lc;c++){
			tmp = 0;
			for (int r=0;r<lr;r++){
				tmp += grid[r][c];
				if (tmp >=2){
					col[c] = true;
					break;
				}
			}
		}
		for (int r=0;r<lr;r++)
			for(int c=0;c<lc;c++)
				if (grid[r][c] == 1 && (row[r] || col[c]))
					ans++;
		return ans;
  }
}
