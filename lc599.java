import java.util.HashMap;
import java.util.Map;

public class lc599 {
  private static String[] findRestaurant(String[] list1, String[] list2) {
    int l1 = list1.length, l2 = list2.length;
    Map<String,Integer> ans = new HashMap<>();
    if (l1<=l2){
      for (int i =0;i<l1;i++){
        for (int j=0;j<l2;j++){
          if (list2[j].equals(list1[i])){
            ans.put(list2[j],i+j);
          }
        }
      }
    }
    else{
      for (int i =0;i<l2;i++){
        for (int j=0;j<l1;j++){
          if (list2[j].equals(list1[i])){
            ans.put(list2[j],i+j);
          }
        }
      }
    }
    
    return null;
  }

  public static void main(String[] args) {
    
  }
}
