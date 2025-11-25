class lc1930 {

	private static int countPalindromicSubsequence(String s) {
		int[] prefix = new int[26];
		int[] postfix = new int[26];
		boolean[][] map = new boolean[26][26];
		int l = s.length();
		int ans = 0;
		prefix[s.charAt(0) - 'a']++;
		for (int i = 2; i < l; i++)
			postfix[s.charAt(i) - 'a']++;
		for (int i = 1, n = l - 1; i < n; i++) {
			if (i > 1) {
				prefix[s.charAt(i - 1) - 'a']++;
				postfix[s.charAt(i) - 'a']--;
			}
			for (int j = 0; j < 26; j++)
				if (prefix[j] > 0 && postfix[j] > 0)
					map[j][s.charAt(i) - 'a'] = true;
		}
		for (int r = 0; r < 26; r++)
			for (int c = 0; c < 26; c++)
				if (map[r][c])
					ans++;
		return ans;
	}

	static public int countPalindromicSubsequence1(String s) {
		int l = s.length();
		int[] map = new int[26];
		int fmask = 0;
		int bmask = 0;
		int ans = 0;
		boolean[][] visited = new boolean[26][26];
		for (int i = 0; i < l; i++) {
			map[s.charAt(i) - 'a']++;
			bmask |= 1 << (s.charAt(i) - 'a');
		}
		for (int i = 1, n = l - 1; i < n; i++) {
			fmask |= (1 << (s.charAt(i - 1) - 'a'));
			map[s.charAt(i - 1) - 'a']--;
			if (map[s.charAt(i - 1) - 'a'] == 0)
				bmask ^= (1 << (s.charAt(i - 1) - 'a'));
			if (map[s.charAt(i) - 'a'] == 1)
				bmask ^= (1 << (s.charAt(i) - 'a'));
			ans += check(fmask, s.charAt(i) - 'a', bmask, visited);
			if (map[s.charAt(i) - 'a'] == 1)
				bmask ^= (1 << (s.charAt(i) - 'a'));
		}
		return ans;
	}

	static public int check(int fmask, int mid, int bmask, boolean[][] visited) {
		int count = 0;
		for (int i = 0, mask = 1; i < 26; i++) {
			mask = (1 << i);
			if ((fmask & mask) > 0 && (bmask & mask) > 0) {
				count += visited[i][mid] ? 0 : 1;
				visited[i][mid] = true;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String s = "aabca";
		System.out.println(countPalindromicSubsequence1(s));
	}
}
