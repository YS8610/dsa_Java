import java.util.Map;
import java.util.HashMap;

class lc2466{
	private static final int MOD = 1000000007;

	private static int countGoodStrings(int low, int high, int zero, int one) {
		int ans = 0;
		Map<Integer,Integer> memo = new HashMap<>();
		for (int i =low; i <= high;i++){
			ans += dfs(zero, one, i, memo);
			ans%=MOD;
		}
		return ans;
	 }

	private static int dfs(int z, int o, int len, Map<Integer, Integer> memo){
		if (len == 0) return 1;
		if (len < 0) return 0;
		if (memo.containsKey(len)) return memo.get(len);
		int ans = 0;
		ans = (dfs(z, o, len-z, memo)
				+ dfs(z, o, len-o, memo))%MOD;
		memo.put(len, ans);
		return ans;
	}

  public static void main(String[] args){
    int low = 2;
    int high = 3;
    int zero = 1;
    int one = 2;
    System.out.println(countGoodStrings(low, high, zero, one));
  }
}
