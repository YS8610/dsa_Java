import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc1657 {
  private static boolean closeStrings(String word1, String word2) {
    int l1=word1.length();
    int l2=word2.length();
    Set<Integer>s1 = new HashSet<>();
    Set<Integer>s2 = new HashSet<>();
    if (l1!=l2) return false;
    int[] a1 = new int[26];
    int[] a2 = new int[26];
    for (int i=0;i<l1;i++){
      a1[(int)word1.charAt(i) - 'a']++;
      a2[(int)word2.charAt(i) - 'a']++;
    }
    for (int i=0;i<26;i++){
      if (a1[i]>0) s1.add(i);
      if (a2[i]>0) s2.add(i);
    }
    if (!s1.equals(s2)) return false;
    List<Integer> a11 = new ArrayList<>(s1.size());
    List<Integer> a22 = new ArrayList<>(s2.size());

    for (int i=0;i<26;i++){
      if (a1[i]>0) a11.add(a1[i]);
      if (a2[i]>0) a22.add(a2[i]);
    }
    a11.sort((m1,m2)->m1.compareTo(m2));
    a22.sort((m1,m2)->m1.compareTo(m2));
    
    if (!a11.equals(a22)) return false;
    return true;
  }
  
  public static void main(String[] args) {
    String word1 = "xxxxxxxxxxxxxxxxxxx", word2 = "zzzzzzzzzzzzzzzzzzz";
    System.out.println( closeStrings(word1, word2) );
  }
}
