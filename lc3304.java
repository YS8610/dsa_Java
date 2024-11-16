public class lc3304 {
  private static char kthCharacter(int k) {
    if (k==1) return 'a';
    StringBuilder a = new StringBuilder();
    a.append('a');
    int l = 1;
    while (l < k){
      for (int i=0, n=a.length(); i<n;i++){
        a.append((char)((a.charAt(i)+1)%'a'+'a'));
        l++;
        if (l >= k) return (char)((a.charAt(i)+1)%'a'+'a');
      }
    }
    return a.charAt(k);
  }

  public static void main(String[] args) {
    int k = 1;
    System.out.println(kthCharacter(k));
  }
}
