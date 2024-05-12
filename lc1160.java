public class lc1160 {
  private static int countCharacters(String[] words, String chars) {
    int[] map = new int[26];
    int[] temp = new int[26];
    boolean count = true;
    int ans = 0;
    for (int i=0,n=chars.length();i<n;i++){
      map[chars.charAt(i) - 'a'] +=1;
    }
    for (String w:words){
      for (int i=0,n=w.length();i<n;i++){
        temp[w.charAt(i) - 'a'] +=1;
      }
      for(int i=0;i<26;i++){
        if (temp[i]>0 && temp[i]>map[i]) count =false;
        temp[i] = 0;
      }
      if (count) ans += w.length();
      count = true;
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] words = {"cat","bt","hat","tree"};
    String chars = "atach";
    System.out.println(countCharacters(words, chars));
  }
}
