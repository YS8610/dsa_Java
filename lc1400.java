class lc1400{
	private static boolean canConstruct(String s, int k){
		int l = s.length();
		if (k > l) return false;
		if (k == l) return true;
		int[] map = new int[26];
		for (int i =0;i<l;i++)
			map[s.charAt(i)-'a']++;
		int odd=0;
		for (int m :map)
			if ((m&1)==1)
				odd++;
		if (odd > k) return false;
		return true;
	}
	
	public static void main(String[] args){
		String s = "annabelle";
		int k = 2;
		System.out.println(canConstruct(s, k));
	}
}