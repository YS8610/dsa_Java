class lc3271{
  private static String stringHash(String s, int k) {
    StringBuilder ans = new StringBuilder();
    int l = s.length();
    int tmp;
    for (int i =0; i<l;i+=k){
      tmp = 0;
      for (int j=i, n=i+k;j<n;j++)
        tmp += (int)(s.charAt(j)-'a');
      ans.append((char)(tmp%26 +'a'));
    }
    return ans.toString();
  }

  public static void main(String[] args){
    String s = "abcd";
    int k = 2;
    System.out.println(stringHash(s, k));
  }
}
