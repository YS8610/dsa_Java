import java.util.HashMap;
import java.util.Map;

class lc3393{
	private static int encode(int r, int c, int xor){
		int ans =0;
		ans |= r<<13;
		ans |= c <<4;
		ans |=xor;
		return ans;
	}

	private static int[] decode(int code){
		int bitmask = 1;
		int xor = 0;
		int c = 0;
		int r = 0;
		for (int i=0; i<4;i++){
			if ((bitmask & code)>0)
				xor+=bitmask;
			bitmask<<=1;
		}
		for (int i=4; i < 13;i++){
			if ((bitmask & code)>0)
				c+=bitmask;
			bitmask<<=1;
		}
		c>>=4;
		for (int i=13; i<22;i++){
			if ((bitmask & code)>0)
				r+=bitmask;
			bitmask<<=1;
		}
		r >>=13;
		return new int[]{r, c, xor};
	}

	private static int dfs(int[][] grid, int k, int r, int c, int xor, int mod, Map<Integer, Integer>memo){
		if (r <0 || c<0|| r>=grid.length||c>=grid[0].length)
			return 0;
		int data = encode(r, c, xor);
		if (memo.containsKey(data)) 
			return memo.get(data);
		if (r == grid.length-1 && c == grid[0].length-1){
			xor ^= grid[r][c];
			if (xor == k)
				return 1;
			return 0;
		}
		int ans = (dfs(grid, k, r+1, c, xor^grid[r][c], mod, memo)
						+ dfs(grid, k, r, c+1, xor^grid[r][c], mod, memo))
						% mod;
		memo.put(data, ans);
		return ans;
	}
	
	private static int countPathsWithXorValue(int[][] grid, int k){
		int mod = 1000000007;
		return dfs(grid, k, 0,0, 0, mod, new HashMap<>());
	}

	public static void main(String[] args) {
		int[][] grid = {
			{1, 3, 3, 3},
			{0, 3, 3, 2},
			{3, 0, 1, 1}
		};
		int k = 11;
		System.out.println(countPathsWithXorValue(grid, k));
	}
}
