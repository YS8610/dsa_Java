import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class lc1396 {
  Map< String,Map<Integer,Integer> > map;

  public lc1396() {
    this.map = new HashMap<>();
  }
  
  public void checkIn(int id, String stationName, int t) {
    if (this.map.containsKey(stationName)){
      Map<Integer,Integer> a = this.map.get(stationName);
      
    }
    else{
      // this.map.get(stationName).add( List.of(id,t) );
    }
  }
  
  public void checkOut(int id, String stationName, int t) {
    // this.map.get(stationName).add( List.of(id,t) );
  }
  
  public double getAverageTime(String startStation, String endStation) {
    // List<List<Integer>> checkin = this.map.get(startStation);
    // List<List<Integer>> checkout = this.map.get(endStation);
    return 0d;
  }
}
