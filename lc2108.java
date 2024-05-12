public class lc2108 {
  private static String firstPalindrome(String[] words) {
    int len=0;
    int lp, rp;
    out:
    for(String word: words){
        len = word.length();
        if (len==1) return word;
        lp=0;
        rp=len-1;
        while(lp<rp){
            if(word.charAt(lp)!=word.charAt(rp)) continue out;
            lp++;
            rp--; 
        }
        return word;
    }
    return "";
  }

  public static void main(String[] args) {
    String[] words = {"abc","car","ada","racecar","cool"};
    System.out.println(firstPalindrome(words));
  }
}
