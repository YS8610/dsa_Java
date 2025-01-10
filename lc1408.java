import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

class lc1408{

  private static List<String> stringMatching(String[] words) {
    Set<String> ans = new HashSet<>();
    int l = words.length;
    for (int i =0;i<l;i++){
      for (int j = 0; j<l;j++){
        if (i==j)
          continue;
        if (words[i].indexOf(words[j]) >=0)
          ans.add(words[j]);
      }
    }
    return new ArrayList<>(ans);
  }

  public static void main(String[] args){
    String[] words = {"mass","as","hero","superhero"};
    System.out.println(stringMatching(words));
  }

}
