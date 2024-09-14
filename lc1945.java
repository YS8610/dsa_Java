public class lc1945 {
  private static int getLucky(String s, int k) {
    int l = s.length();
    int n = 0;
    for (int i =0;i<l;i++){
      if (s.charAt(i) - 'a' +1 < 10){
        n += s.charAt(i) - 'a' +1;
        continue;
      }
      n+= (s.charAt(i) - 'a' +1)%10;
      n+= ((s.charAt(i) - 'a' +1)/10)%10;
    }
    k--;
    int m;
    while (k>0){
      m=0;
      while (n/10>0){
        m+=n%10;
        n/=10;
      }
      m+=n%10;
      n=m;
      if (n < 10) break;
      k--;
    }
    return n;
  }

  public static void main(String[] args) {
    String s = "leetcode";
    int k = 2;
    System.out.println(getLucky(s, k));
  }
}
