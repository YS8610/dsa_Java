import java.util.Arrays;

class lc498{
	private static int[] findDiagonalOrder(int[][] mat) {
		int l = mat.length * mat[0].length;
		int[] ans = new int[l];
		dfs(mat, 0, 0, -1, 1, 0, ans);
		return ans;
	}

	private static void dfs(int[][] mat, int r, int c, int dr, int dc, int i, int[] ans){
		int lr = mat.length;
		int lc = mat[0].length;
		ans[i++] = mat[r][c];

		if (r+dr <0 || c+dc <0 || r+dr>=lr || c+dc>=lc){
			if (dr == -1 && dc == 1){
				if (c+1 < lc)
					dfs(mat, r+0, c+1, 1, -1, i, ans);
				else if (r+1 < lr)
					dfs(mat, r+1, c, 1, -1, i, ans);
				else
					return;
			}
			else{
				if (r+1 < lr)
					dfs(mat, r+1, c, -1, 1, i, ans);
				else if (c+1 < lc)
					dfs(mat, r, c+1, -1, 1, i, ans);
				else return;
			}
		}
		else
			dfs(mat, r+dr, c+dc, dr, dc, i, ans);
	}

	public static void main(String[] args){
		int[][] mat = {{1,2,3,4},{4,5,6,99},{7,8,9,33}};
		System.out.println(Arrays.toString(findDiagonalOrder(mat)));
	}
}
