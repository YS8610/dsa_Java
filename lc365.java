import java.util.HashSet;
import java.util.Set;

import javax.swing.text.html.parser.TagElement;

public class lc365 {
  
  private static boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity){
    int bigJug = Math.max(jug2Capacity, jug1Capacity);
    int smallJug = Math.min(jug2Capacity, jug1Capacity);
    int total = jug1Capacity+jug2Capacity;
    // both jugs have similar capacity
    if ( smallJug==bigJug){
      if (targetCapacity == smallJug || targetCapacity==2*smallJug) return true;
      return false;
    }
    // target capacity is lower than small jug
    if ( smallJug<targetCapacity  ){
      if (smallJug%bigJug == targetCapacity) return true;
      if ( smallJug - smallJug%bigJug == targetCapacity ) return true;
      return false; 
    }
    // target capacity = small jug
    else if (smallJug == targetCapacity ) return true;
    // small jub < target capacity < bigjug
    else if (bigJug>targetCapacity){
      if (targetCapacity% smallJug==0) return true;
      if (bigJug-smallJug== targetCapacity) return true;
      if (smallJug%bigJug + smallJug == targetCapacity) return true;
      if (2*smallJug - smallJug%bigJug == targetCapacity ) return true;
      return false;
    }
    // target capacity = big jug
    else if (bigJug == targetCapacity) return true;
    // big jug < targetCapacity < small + big jug
    else if (bigJug<targetCapacity && total>targetCapacity){
      if (smallJug%bigJug + bigJug== targetCapacity) return true;
      if ( smallJug - smallJug%bigJug + bigJug == targetCapacity ) return true;
      return false;
    }
    // target capacity = big + small jug
    else if ( targetCapacity == total) return true;
    // big + small jug <target capacity
    else return false;

  }

  public static void main(String[] args) {
    int jug1Capacity = 3, jug2Capacity = 5, targetCapacity = 4;
    System.out.println( canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity) );
  }
}
