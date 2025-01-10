import java.util.Map;
import java.util.HashMap;

class lc576{
	private static final int MOD = 1000000007;

	private static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
		return dfs(m, n, maxMove, startRow, startColumn, new HashMap<>());
	}

	private static int dfs(int m, int n , int move, int r, int c, Map<Integer,Integer> memo){
		if (r < 0 || c <0 || r >= m || c >= n) return 1;
		if (move <= 0) return 0;
		int code = encode(move, r, c);
		if (memo.containsKey(code)) return memo.get(code);
		int ans =0;
		ans += dfs(m, n, move-1, r+1, c, memo)%MOD;
		ans %= MOD;
		ans += dfs(m, n, move-1, r-1, c, memo)%MOD;
		ans %= MOD;
		ans += dfs(m, n, move-1, r, c+1, memo)%MOD;
		ans %= MOD;
		ans += dfs(m, n, move-1, r, c-1, memo)%MOD;
		ans %= MOD;
		memo.put(code, ans);
		return ans;
	}

	private static int encode(int move, int r, int c){
		int ans = 0;
		ans |= move;
		ans <<= 6;
		ans |= r;
		ans <<= 6;
		ans |=c;
		return ans;
	}

	public static void main(String[] args){
		int m = 30, n = 40, maxMove = 50, startRow = 10, startColumn = 10;
		System.out.println(findPaths(m, n, maxMove, startRow, startColumn));
	}
}
