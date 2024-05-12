import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class lc1146 {
  Map<Integer,Integer> netChange;
  List<Map<Integer,Integer>> snapIndex;
  int counter;


  public lc1146(int length) {
    this.netChange = new HashMap<>();
    this.snapIndex = new ArrayList<>( );
    this.snapIndex.add(new HashMap<>());
    this.counter = 0;
  }
  
  public void set(int index, int val) {
    this.snapIndex.get(this.counter).put(index, val);
  }
  
  public int snap() {
    this.counter++;
    this.snapIndex.add( new HashMap<>() );
    return this.counter-1;
  }
  
  public int get(int index, int snap_id) {
    for (int i = snap_id; i>=0; i--){
      if (this.snapIndex.get(i).containsKey(index)) {
        return this.snapIndex.get(i).get(index); 
      }
    }
    return 0;
  }

  public static void main(String[] args) {
    int length = 50000;
    lc1146 obj = new lc1146(length);
    obj.set(0, 49352);
    obj.snap();
    System.out.println(obj.get(0,0));

    obj.set(0,5373);
    obj.snap();
    System.out.println( obj.get(0,0) ); 
    
    obj.set(0,23341);
    obj.snap();
    System.out.println( obj.get(0,2) ); 

  }
}
//  Better Version
  // Map<Integer,Integer> netChange;
  // List<Map<Integer,Integer>> snapIndex;
  // int counter;

  // public SnapshotArray(int length) {
  //   this.netChange = new HashMap<>();
  //   this.snapIndex = new ArrayList<>();
  //   this.counter = 0;
  // }
  
  // public void set(int index, int val) {
  //   this.netChange.put(index, val);
  // }
  
  // public int snap() {
  //   this.counter++;
  //   this.snapIndex.add( new HashMap<>( this.netChange) );
  //   return this.counter-1;
  // }
  
  // public int get(int index, int snap_id) {
  //   int ans =0;
  //   Map<Integer,Integer> mapIndex = this.snapIndex.get(snap_id);
  //   if (mapIndex.containsKey(index)) return mapIndex.get(index);
  //   return ans;
  // }

// brutal force method
    // List<Integer> array;
    // List<List<Integer>> event;

    // public SnapshotArray(int length) {
    //     this.array = new ArrayList<>(Collections.nCopies(length, 0));
    //     this.event = new ArrayList<>(50000);
    // }
    
    // public void set(int index, int val) {
    //     this.array.set(index, val);
    // }
    
    // public int snap() {
    //     this.event.add( new ArrayList<>(this.array) );
    //     return this.event.size()-1;
    // }
    
    // public int get(int index, int snap_id) {
    //     List<Integer> a = this.event.get(snap_id);
    //     return a.get(index);
    // }