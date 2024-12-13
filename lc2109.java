public class lc2109 {

  private static String addSpaces(String s, int[] spaces) {
    int ls = spaces.length;
    int l = s.length();
    char[] ans = new char[l + ls];
    int j = 0;
    int k = 0;
    for (int i = 0; i < l; i++) {
      if (k < ls && i == spaces[k]) {
        ans[j++] = ' ';
        ans[j++] = s.charAt(i);
        k++;
        continue;
      }
      ans[j++] = s.charAt(i);
    }
    return new String(ans);
  }

  public static void main(String[] args) {
    String s = "EnjoyYourCoffee";
		int[] spaces = {5,9};
		System.out.println(addSpaces(s,spaces));
  }
}
