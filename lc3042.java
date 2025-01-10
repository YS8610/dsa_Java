class lc3042{
  
  private static int countPrefixSuffixPairs(String[] words) {
    int l = words.length;
    int ans = 0;
    for (int i =0; i<l;i++){
      for (int j =i+1;j<l;j++){
        if (words[i].length() > words[j].length())
          continue;
        if (words[j].startsWith(words[i]) && words[j].endsWith(words[i]))
          ans++;
      }
    }
    return ans;
  }


  public static void main(String[] args){
    String[] words = {"a","aba","ababa","aa"};
    System.out.println(countPrefixSuffixPairs(words));
  }
}
