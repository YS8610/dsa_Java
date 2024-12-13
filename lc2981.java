public class lc2981 {
  public int maximumLength(String s) {
		int len = s.length();
		int ans = -1;
		int[][] map = new int[26][50];
		int j=0;
		for (int i = 0; i<len; i++){
			j = 0;
			while (i+j <len && s.charAt(i) == s.charAt(i+j)){
				map[s.charAt(i)-'a'][j]++;
				j++;
			}
		}
		for (int[] lmap: map)
			for (int i=0; i<49;i++)
				if (lmap[i] >=3) 
					ans = Math.max(ans,i+1);
		return ans;
  }
}
