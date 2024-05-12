import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class lc82 {
  private static ListNode deleteDuplicates(ListNode head){
    Map<Integer,List<ListNode>> map = new LinkedHashMap<>();
    if (head==null) return null;
    ListNode cp = head;
    int v;
    while(cp!=null){
      v=cp.val;
      if (map.containsKey(v)) map.get(v).add(cp);
      else map.put( v , new ArrayList<>( Arrays.asList(cp) ));
      cp=cp.next;
    }
    ListNode ans=null;
    List<ListNode> result;
    for (int k : map.keySet()){
      result = map.get(k);
      if (result.size()==1){
        if (ans==null) {
          ans =result.get(0);
          cp=ans;
        }
        else{
          cp.next = result.get(0);
          cp=cp.next;
        }
      }
    }
    if(ans!=null) cp.next=null;
    return ans;
  }

  private static ListNode deleteDuplicates1(ListNode head){
    Map<Integer,ListNode> map = new LinkedHashMap<>();
    Map<Integer,Integer> map1 = new HashMap<>();
    if (head==null) return null;
    ListNode cp = head;
    int v;
    while(cp!=null){
      v=cp.val;
      map.put( v , cp );
      if(map1.containsKey(v)) map1.put(v, map1.get(v)+1);
      else map1.put(v,1);
      cp=cp.next;
    }
    ListNode ans=null;
    ListNode result;
    for (int k : map.keySet()){
      result = map.get(k);
      if (map1.get(result.val)==1){
        if (ans==null) {
          ans =result;
          cp=ans;
        }
        else{
          cp.next = result;
          cp=cp.next;
        }
      }
    }
    if(ans!=null) cp.next=null;
    return ans;
  }
  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[]{1,2,2,3,5,5});
    ListNode ans = deleteDuplicates(head);
    ListNode ans1 = deleteDuplicates1(head);
    ListNode.stringify(ans);
    ListNode.stringify(ans1);
  }

}
