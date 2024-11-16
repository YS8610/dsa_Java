import java.util.ArrayDeque;
import java.util.Deque;

public class lc3335 {
  private static int lengthAfterTransformations(String s, int t) {
    long[] map = new long[26];
    int mod = 1;
    for (int i =0;i <9;i++) mod*=10;
    mod += 7;
    for (int i =0;i<s.length();i++) map[s.charAt(i) - 'a']++;
    for (int i =0, n=t/26; i<n;i++){
      for (int j=0;j<26;j++){
        map[j] <<=1;
        map[j] %= mod;
      }
    }
    t %=26;
    Deque<Long> q = new ArrayDeque<>();
    for (long a : map) q.addLast(a);
    long ans=0;
    long tmp;
    while (--t>=0){
      tmp = (q.pollLast() * 2)%mod;
      // if (tmp >= mod) tmp %=mod;
      q.addFirst(tmp);
    }
    for (long i : q) ans+=i;
    return (int)(ans%mod);
  }

  public static void main(String[] args) {
    String s = "jqktcurgdvlibczdsvnsg";
    int t = 7517;
    System.out.println(lengthAfterTransformations(s, t));
  }
}
