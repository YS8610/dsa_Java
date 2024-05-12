import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc819 {
  public static void main(String[] args) {
    String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = {"hit"};

    Set<String> uniqueWords = new HashSet<>();
    List<String> bannedArray = new ArrayList<>(Arrays.asList(banned));
    String ans=null;
    Long count = Long.valueOf(0);

    String[] paraSplit = paragraph.split("\\W");
    List<String> paraProcressed =  Arrays.asList(paraSplit)
                                          .stream()
                                          .filter(x -> !x.equals(""))
                                          .filter(x -> !x.equals(" ") )
                                          .map(x -> x.toLowerCase())
                                          .toList();

    for (String a : paraProcressed){
      if ( !bannedArray.contains(a) && !a.equals("")) uniqueWords.add(a);
    }

    for (String b : uniqueWords){
      Long count1 = paraProcressed.stream()
                            .filter(x -> x.equals(b) )
                            .count();
      if (count1>count){
        ans =b;
        count = count1;
      }
    }

    System.out.println(paraProcressed.toString());
    System.out.println(uniqueWords.toString());
    System.out.println(ans);


  }
}
