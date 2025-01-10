class lc1930{

	private static int countPalindromicSubsequence(String s){
		int[] prefix = new int[26];
		int[] postfix = new int[26];
		boolean[][] map = new boolean[26][26];
		int l = s.length();
		int ans = 0;
		prefix[s.charAt(0)-'a']++;
		for (int i=2;i<l;i++)
			postfix[s.charAt(i)-'a']++;
		for (int i=1, n=l-1;i<n;i++){
			if (i > 1){
				prefix[s.charAt(i-1)-'a']++;
				postfix[s.charAt(i)-'a']--;
			}
			for (int j=0;j<26;j++)
				if (prefix[j] >0 && postfix[j] >0)
					map[j][s.charAt(i)-'a'] = true;
		}
		for (int r=0;r<26;r++)
			for (int c=0; c<26;c++)
				if (map[r][c])
					ans++;
		return ans;
	}

	public static void main(String[] args){
		String s = "bbcbaba";
		System.out.println(countPalindromicSubsequence(s));
	}
}
