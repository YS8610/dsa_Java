public class lc1813 {
  private static boolean areSentencesSimilar(String sentence1, String sentence2) {
    int l1 = sentence1.length();
    int l2 = sentence2.length();
    if (l1 == 0 || l2 == 0) return true;
    if (sentence1.equals(sentence2)) return true;
    String[] s1 = sentence1.split(" ");
    String[] s2 = sentence2.split(" ");
    if (s1.length == s2.length) return false;
    String[] less = s1.length>= s2.length?s2:s1;
    String[] more = s1.length>= s2.length?s1:s2;
    int prefix = 0;
    int suffix = 0;
    int j = less.length-1;
    int i = more.length-1;
    while (prefix < less.length && less[prefix].equals(more[prefix]))
      prefix++;
    while (j >=0 && less[j].equals(more[i])){
      i--;
      j--;
      suffix++;
    }
    if (prefix + suffix >= less.length) return true;
    return false;
  }

  public static void main(String[] args) {
    String sentence1 = "bb aa aa bb", sentence2 = "aa bb";
    System.out.println(areSentencesSimilar(sentence1, sentence2));
  }
}
