import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class lc290 {
  
  public static void main(String[] args) {
    String pattern = "abba", s = "dog dog dog dog";
    
    Map<String,String> a = new Hashtable<>();

    String[] pA = pattern.chars()
            .mapToObj(c -> String.valueOf((char) c))
            .toArray(String[]::new);
    String[] sA = Arrays.stream(s.split(" "))
                        .filter(x -> x!=" ")
                        .toArray(String[]::new);
    Set<String> pS = new HashSet<>(Arrays.asList(pA));
    Set<String> sS = new HashSet<>(Arrays.asList(sA));

    if (pS.size() != sS.size()) System.out.println(false);

    System.out.println(Arrays.toString(sA));
    System.out.println(Arrays.toString(pA));
        
    for (int i=0, n=pA.length; i<n; i++){
      if (a.get(pA[i]) == null){
        a.put(pA[i],sA[i]);
      }
      else {
        if (!a.get(pA[i]).equals(sA[i]) ) System.out.println("false");
      }
    }
    String[] valueArray = a.values().stream().toArray(String[]::new);
    Set<String> valueSet = new HashSet<>(Arrays.asList(valueArray) );
    
    if (valueArray.length != valueSet.size()) System.out.println(false);
    if(pA.length != sA.length ) System.out.println(false);


  }
}
