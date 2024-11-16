import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class lc318{
  private static int maxProduct(String[] words){
    int len = words.length;
    // Arrays.sort(words, (m1,m2)->Integer.compare(m2.length(), m1.length()));
    List<Set<Integer>> l = new ArrayList<>(len);
    for (String word : words){
      Set<Integer> s = new HashSet<>();
      for (int i=0,n=word.length();i<n;i++){
        s.add((int) word.charAt(i)-'a');
      }
      l.add(s);
    }
    boolean isLongest = true;
    int ans = 0;
    for (int i=0; i<len-1;i++){
      for (int j=i+1;j<len;j++){
        isLongest=true;
        for (int k:l.get(j)){
          if (l.get(i).contains(k)) {
            isLongest= false;
            break;
          }
        }
        if (isLongest) ans=Math.max(ans, words[i].length() * words[j].length()); 
      }
    }
    return ans;
  }

  private static int maxProduct1(String[] words){
    int[] mask = new int[words.length];
    int ans = 0;
    for (int i=0, n=words.length;i<n;++i){
      for (int j=0,m=words[i].length();j<m;j++){
        mask[i] |= (1<< (words[i].charAt(j) - 'a'));
      }
    }
    int rp = words.length-1;
    for (int lp = 0, n =words.length;lp<n-1;lp++ ){
      rp = words.length-1;
      while (lp <rp){
        if ((mask[lp] & mask[rp])==0) 
          ans = Math.max(ans, words[lp].length()*words[rp].length());
        rp--;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] words = {"abcw","baz","foo","bar","xtfn","abcdef"};
    System.out.println(maxProduct(words));
    System.out.println(maxProduct1(words));
  }
}