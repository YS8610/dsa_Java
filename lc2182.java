import java.util.PriorityQueue;

class lc2182{
  public String repeatLimitedString(String s, int repeatLimit) {
		int[] map = new int[26];
		int l = s.length();
		for (int i =0; i<l;i++)
			map[s.charAt(i)-'a']++;
		StringBuilder ans = new StringBuilder(l);
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
			(m1,m2) -> {
				if (m2[0] == m1[0])
					return Integer.compare(m2[1], m1[1]);
				return Integer.compare(m2[0],m1[0]);
			}
		);
		for (int i =0; i<26;i++){
			if (map[i] <= 0) continue;
				pq.add(new int[]{i, map[i]});
		}
		int[] tmp, tmp1;
		while (!pq.isEmpty()){
			tmp = pq.poll();
			if (tmp[1] <= repeatLimit){
				for (int i=0;i<repeatLimit && tmp[1] > 0;i++){
					ans.append((char)(tmp[0]+'a'));
					tmp[1]--;
				}
				continue;
			}
			for (int i=0;i<repeatLimit && tmp[1] > 0;i++){
				ans.append((char)(tmp[0]+'a'));
				tmp[1]--;
			}
			if (pq.isEmpty()) break;
			tmp1 = pq.peek();
			ans.append((char)(tmp1[0]+'a'));
			tmp1[1]--;
			if (tmp1[1] <=0) pq.poll();
			pq.add(tmp);
		}
		return ans.toString();
  }
}
