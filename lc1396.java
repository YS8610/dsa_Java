import java.util.HashMap;
import java.util.Map;

public class lc1396 {
  class Event {
    String stationName;
    int t;

    public Event(String stationName, int t) {
      this.stationName = stationName;
      this.t = t;
    }
  }

  Map<Integer, Event> cust;
  Map<String, int[]> station;

  public lc1396() {
    this.cust = new HashMap<>();
    this.station = new HashMap<>();
  }

  public void checkIn(int id, String stationName, int t) {
    this.cust.put(id, new Event(stationName, t));
  }

  public void checkOut(int id, String stationName, int t) {
    Event e = this.cust.get(id);
    String dest = concat(e.stationName, stationName);
    int[] tmp = this.station.getOrDefault(dest, new int[2]);
    tmp[0] += t - e.t;
    tmp[1]++;
    this.station.put(dest, tmp);
  }

  public double getAverageTime(String startStation, String endStation) {
    int[] tmp = this.station.get(concat(startStation, endStation));
    return tmp[0] / (double) tmp[1];
  }

  private String concat(String a, String b) {
    int l = a.length() + 1 + b.length();
    char[] tmp = new char[l];
    int i = -1;
    int j = 0;
    while (++i < a.length())
      tmp[i] = a.charAt(i);
    tmp[++i] = ',';
    while (++i < l)
      tmp[i] = b.charAt(j++);
    return String.valueOf(tmp);
  }
}
