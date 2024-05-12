import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1481 {
  private static int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer,Integer> map = new HashMap<>();
    for(int i:arr){
      if (map.containsKey(i)) map.put(i, map.get(i)+1);
      else map.put(i,1);
    }
    List<List<Integer>>list = new ArrayList<>(map.size());
    for(int key :map.keySet()){
      list.add(List.of(key,map.get(key)));
    }
    list.sort((m1,m2)->Integer.compare(m1.get(1), m2.get(1)));
    
    int counter=0;
    for (int i=0; i<k;i++){
      if (map.get(list.get(counter).get(0)) >0){
        map.put(list.get(counter).get(0), map.get(list.get(counter).get(0))-1);
        if (map.get(list.get(counter).get(0))==0) {
          map.remove(list.get(counter).get(0));
          counter++;
        }
      }
      else{
        map.remove(list.get(counter).get(0));
        counter++;
        map.put(list.get(counter).get(0), map.get(list.get(counter).get(0))-1);
      }
    }
    return map.size();
  }
  
  private static int findLeastNumOfUniqueInts1(int[] arr, int k) {
    Map<Integer,Integer> map = new HashMap<>();
    for(int i:arr){
      if (map.containsKey(i)) map.put(i, map.get(i)+1);
      else map.put(i,1);
    }
    int[][] list = new int[map.size()][2];
    int indx=0;
    for(int key: map.keySet()){
      list[indx][0] = key;
      list[indx][1] = map.get(key);
      indx++;
    }
    Arrays.sort(list, (m1,m2)-> Integer.compare(m1[1], m2[1]));
    int counter=0;
    for (int i=0; i<k;i++){
      if (map.get(list[counter][0]) >0){
        map.put(list[counter][0], map.get(list[counter][0])-1);
        if (map.get(list[counter][0])==0) {
          map.remove(list[counter][0]);
          counter++;
        }
      }
      else{
        map.remove(list[counter][0]);
        counter++;
        map.put(list[counter][0], map.get(list[counter][0])-1);
      }
    }
    return map.size();
  }

  public static void main(String[] args) {
    int[] arr = {5,5,4};
    int k = 1;
    System.out.println(findLeastNumOfUniqueInts(arr, k));
    System.out.println(findLeastNumOfUniqueInts1(arr, k));
  }
}
