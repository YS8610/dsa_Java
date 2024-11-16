import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc884 {

  private static String[] uncommonFromSentences(String s1, String s2) {
    List<String> combinedString = new ArrayList<>();
    List<String> ans = new ArrayList<>();

    for (String b : s1.split(" ")) {
      combinedString.add(b);
    }
    for (String b : s2.split(" ")) {
      combinedString.add(b);
    }

    Set<String> combinedSet = new HashSet<>(combinedString);
    for (String b : combinedSet) {
      Long count = combinedString.stream().filter(x -> x.equals(b)).count();
      if (count.intValue() == 1) {
        ans.add(b);
      }
    }
    return ans.toArray(String[]::new);
  }

  public static void main(String[] args) {
    String s1 = "this apple is sweet", s2 = "this apple is sour";
    System.out.println(Arrays.toString(uncommonFromSentences(s1,s2)));
  }
}
