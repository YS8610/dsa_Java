class lc2379{
	static public int minimumRecolors(String blocks, int k) {
        int l = blocks.length();
        int[] prefix = new int[l];
        prefix[0] = blocks.charAt(0)=='B'?1:0;
        for (int i =1;i<l;i++)
            prefix[i] = prefix[i-1] + (blocks.charAt(i)=='B'?1:0);
        int ans = l;
        ans = Math.min(k-prefix[k-1], ans);
        for (int i =1, n=l-k, tmp=l; i<=n;i++){
            if (ans ==0) return 0;
            tmp = prefix[i+k-1] - prefix[i-1];
            ans = Math.min(k - tmp, ans);
        }
        return ans;
    }
	
	public static void main(String[] args){
		String blocks = "WBBWWBBWBW";
		int k = 7;
		System.out.println(minimumRecolors(blocks, k));
	}
}