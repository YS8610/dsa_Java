import java.util.Arrays;

public class lc769 {
	public int maxChunksToSorted(int[] arr) {
		int l = arr.length;
		int lp = 0;
		int rp = 0;
		int ans = 0;
		boolean[] map = new boolean[l+1];
		boolean all = true;
		while (lp+rp < l){
			if (arr[lp] == lp){
				ans++;
				lp++;
				continue;
			}
			rp = lp+1;
			while (rp < l){
				Arrays.fill(map, false);
				all = true;
				for (int i=lp;i<=rp;i++)
					map[arr[i]] = true;
				for (int i=lp;i<=rp;i++)
					if (!map[i])
						all = false;
				if (all){
					ans++;
					lp = rp+1;
					rp=0;
					break;
				}
				else
					rp++;
			}
		}
		return ans;
	}
}
