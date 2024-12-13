public class lc1455 {
  private static int isPrefixOfWord(String sentence, String searchWord) {
    String[] s = sentence.split(" ");
    for (int i =0, n=s.length;i<n;i++)
      if (s[i].startsWith(searchWord))
        return i+1;
    return -1;
  }

  public static void main(String[] args) {
    String sentence = "i love eating burger";
    String searchWord = "burg";
    System.out.println(isPrefixOfWord(sentence, searchWord));
  }
}
