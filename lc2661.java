class lc2661{
	private static int firstCompleteIndex(int[] arr, int[][] mat) {
		int lr = mat.length;
		int lc = mat[0].length;
		int[][] map = new int[arr.length+1][2];
		for (int r=0;r<lr;r++)
			for (int c=0;c<lc;c++){
				map[mat[r][c]][0] = r;
				map[mat[r][c]][1] = c;
			}
		int[] row = new int[lr];
		int[] col = new int[lc];
		int[] tmp;
		for (int i=0, n=arr.length;i<n;i++){
			tmp = map[arr[i]];
			row[tmp[0]]++;
			col[tmp[1]]++;
			if (row[tmp[0]] == lc || col[tmp[1]] == lr)
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args){
		int[] arr = {2,8,7,4,1,3,5,6,9};
		int[][] mat = {{3,2,5},{1,4,6},{8,7,9}};
		System.out.println(firstCompleteIndex(arr, mat));
	}
}