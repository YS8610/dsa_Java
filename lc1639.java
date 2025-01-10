import java.util.Arrays;

public class lc1639 {
	private static final int MOD = 1000000007;
	
	// private static class Trie{
	// 	boolean end;
	// 	Trie[] nodes;

	// 	Trie(){
	// 		this.end = false;
	// 		this.nodes = new Trie[26];
	// 	}

	// 	void addWord(String word){
	// 		Trie cp = this;
	// 		for (int i =0, n = word.length(); i<n;i++){
	// 			if (cp.nodes[word.charAt(i)-'a'] == null)
	// 				cp.nodes[word.charAt(i)-'a'] = new Trie();
	// 			cp = cp.nodes[word.charAt(i)-'a'];
	// 		}
	// 		cp.end = true;
	// 	}
	// }

	// private static int dfs(Trie cp, String target, int i){
	// 	int l = target.length();
	// 	if (i >= l) return 1;
	// 	if (cp.end == true) return 0;
	// 	int ans=0;
	// 	for (int j=0;j<26;j++){
	// 		if (cp.nodes[j] == null) continue;
	// 		if (j != target.charAt(i)-'a'){
	// 			ans += dfs(cp.nodes[j], target, i);
	// 			continue;
	// 		}
	// 		ans += dfs(cp.nodes[j], target, i+1);
	// 	}
	// 	return ans;
	// }

	private static int numWays(String[] words, String target) {
		int l = words[0].length();
		if (target.length() > l) return 0;
		int[][] memo = new int[l][target.length()];
		for (int[] m :memo) Arrays.fill(m, -1);
		int[][] map = new int[l][26];
		for (String w:words)
			for (int i =0;i<l;i++)
				map[i][w.charAt(i)-'a']++;
		return dfs(map, target, 0, 0, memo);
	}

	private static int dfs(int[][] map, String target, int tidx, int maplvl, int[][] memo){
		int l = target.length();
		if (tidx >= l) return 1;
		if (maplvl >= map.length) return 0;
		if (memo[maplvl][tidx] != -1) return memo[maplvl][tidx];
		int ans = 0;
		for (int i=0;i<26;i++){
			if (map[maplvl][i]==0) continue;
			if (i == target.charAt(tidx)-'a')
				ans += dfs(map, target, tidx+1, maplvl+1, memo) * map[maplvl][i];
			else
				ans += dfs(map, target, tidx, maplvl+1, memo);
		}
		memo[maplvl][tidx] = ans;
		return ans;
	}

	public static void main(String[] args) {
		String[] words = {"acca","bbbb","caca","aaaa"};
		String target = "aba";
		System.out.println(numWays(words, target));
	}
}
