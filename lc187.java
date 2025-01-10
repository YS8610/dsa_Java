import java.util.ArrayList;
import java.util.List;

public class lc187 {
	private static class Trie{
		boolean end;
		int n;
		Trie[] node;
		
		Trie(){
			end = false;
			n = 0;
			node = new Trie[4];
		}
	}

	public List<String> findRepeatedDnaSequences(String s) {
		List<String> ans = new ArrayList<>();
		int[] map = new int[128];
		map['A'] = 0;
		map['C'] = 1;
		map['G'] = 2;
		map['T'] = 3;
		Trie head = new Trie();
		int l = s.length();
		if (l <=10) return ans;
		Trie cp = head;
		for (int i = 0, n=l-9; i<n;i++){
			cp = head;
			for (int j=0; j<10;j++){
				if (cp.node[map[s.charAt(i+j)]] == null)
					cp.node[map[s.charAt(i+j)]] = new Trie();
				cp = cp.node[map[s.charAt(i+j)]];
			}
			cp.end = true;
			cp.n++;
			if (cp.n == 2)
				ans.add(s.substring(i, i+10));
		}
		return ans;
	}
}
