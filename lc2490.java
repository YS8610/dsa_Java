public class lc2490 {
  private static boolean isCircularSentence(String sentence) {
    if (sentence.charAt(0) != sentence.charAt(sentence.length()-1))
      return false;
    for (int i=0,n=sentence.length();i<n;i++){
      if (sentence.charAt(i)!=' ') continue;
      if (sentence.charAt(i-1) != sentence.charAt(i+1))
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String sentence = "leetcode exercises sound delightful";
    System.out.println(isCircularSentence(sentence));
  }
}
