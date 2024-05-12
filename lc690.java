import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class lc690 {
  
  private static int getImportance(List<Employee> employees, int id){
    Map<Integer,Integer> impts = new HashMap<>();
    Map<Integer,List<Integer>> sub = new HashMap<>();
    Deque<Integer> q = new ArrayDeque<Integer>();
    int ans = 0;
    for(Employee e: employees){
      impts.put(e.id,e.importance);
      sub.put(e.id,e.subordinates);
    }
    q.add(id);
    while (!q.isEmpty()){
      int target = q.removeFirst();
      ans+= impts.containsKey(target)?impts.get(target):0;
      if (sub.containsKey(target)) sub.get(target).forEach( x -> q.add(x));
    }
    return ans;
  }

}
