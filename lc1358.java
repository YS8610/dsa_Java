class lc1358{
  private static int numberOfSubstrings(String s) {
    int l = s.length();
    int ans = 0;
    int[] map = new int[3];
    int i =0; 
    int j= i+1;
    int n = l-2;
    map[s.charAt(i)-'a']++;
    while (i <n){
      while (j <l && !isok(map))
        map[s.charAt(j++)-'a']++;
      if (isok(map))
        ans += l-j+1;
      map[s.charAt(i++)-'a']--;
      if (i == j)
        j++;
    }
    return ans;
  }

  private static boolean isok(int[] map){
    for (int m : map)
      if (m <= 0)
        return false;
    return true;
  }

  public static void main(String[] args){
    String s = "bbbbccaaa";
    System.out.println(numberOfSubstrings(s));
  }
}
