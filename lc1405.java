import java.util.PriorityQueue;

public class lc1405 {
      private static String longestDiverseString(int a, int b, int c) {
    if (a==0 && b==0 && c==0) return "";
    PriorityQueue<int[]> pq = new PriorityQueue<>((m1,m2) ->Integer.compare(m2[0], m1[0]));
    int[] aArr = new int[]{a,'a'};
    int[] bArr = new int[]{b,'b'};
    int[] cArr = new int[]{c,'c'};
    if (a>0) pq.add(aArr);
    if (b>0) pq.add(bArr);
    if (c>0) pq.add(cArr);
    StringBuilder ans = new StringBuilder();
    int[] tmp;
    int[] sec;
    while (!pq.isEmpty()){
      tmp = pq.poll();
      if (ans.length() < 2){
        ans.append((char)tmp[1]);
        tmp[0]--;
        if (tmp[0] > 0)
          pq.add(tmp);
      }
      else{
        if (ans.charAt(ans.length()-1) == (char)tmp[1] && ans.charAt(ans.length()-2) == (char)tmp[1]){
          if (pq.isEmpty()) break;
          sec = pq.poll();
          ans.append((char)sec[1]);
          sec[0]--;
          if (sec[0] > 0) pq.add(sec);
          pq.add(tmp);
        }
        else{
          ans.append((char)tmp[1]);
          tmp[0]--;
          if (tmp[0] > 0)
            pq.add(tmp);
        }
      }
    }
    return ans.toString();
    }

    public static void main(String[] args) {
      int a = 1, b = 1, c = 7;
      System.out.println(longestDiverseString(a, b, c));
    }
}
