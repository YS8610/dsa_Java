class lc1910{

  private static String removeOccurrences(String s, String part) {
    char[] arr = s.toCharArray();
    int l = arr.length;
    boolean cont = true;
    while (cont){
      cont = false;
      for (int i =0; i<l;i++){
        if (arr[i] == ' ') continue;
        cont = cont || dfs(arr, part, i, 0);
      }
    }
    StringBuilder ans = new StringBuilder();
    for (char i : arr)
      if (i != ' ')
        ans.append(i);
    return ans.toString();
  }

  private static boolean dfs(char[] arr, String part, int i, int j){
    int l = arr.length;
    int l2 = part.length();
    if (j >= l2) return true;
    if (l <= i) return false;
    if (arr[i] == ' ') return dfs(arr, part, i+1, j);
    if (arr[i] != part.charAt(j)) return false;
    boolean ans = dfs(arr, part, i+1, j+1);
    if (ans)
      arr[i] = ' ';
    return ans;
  }

  public static void main(String[] args){
    String s = "axxxxyyyyb", part = "xy";
    System.out.println(removeOccurrences(s, part));
  }

}
