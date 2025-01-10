class lc2185{
  
  private static int prefixCount(String[] words, String pref) {
    int ans = 0;
    for (String w:words)
      if (w.startsWith(pref))
        ans++;
    return ans;
  }
  
  public static void main(String[] args){
    String[] words = {"pay","attention","practice","attend"};
    String pref = "at";
    System.out.println(prefixCount(words, pref));
  }
}
