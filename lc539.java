import java.util.List;

public class lc539 {
  private static int findMinDifference(List<String> timePoints) {
    int maxtp = 24 * 60;
    if (timePoints.size()>maxtp) return 0;
    int ans = maxtp;
    boolean[] timeline = new boolean[maxtp];
    int m = 0;
    for (String tp : timePoints){
      m = (tp.charAt(0)-'0')*600;
      m += (tp.charAt(1)-'0')*60;
      m += (tp.charAt(3)-'0')*10;
      m += (tp.charAt(4)-'0');
      if (timeline[m]) return 0;
      else timeline[m] = true;
    }
    int startpt =0;
    for (int i =0; i<maxtp;i++){
      if (timeline[i]) {
        startpt = i;
        break;
      }
    }
    int pp = startpt;
    for (int i = startpt+1; i<maxtp;i++){
      if (timeline[i]){
        ans = Math.min(ans, i-pp);
        pp = i;
      }
    }
    return Math.min(ans, maxtp - pp + startpt);
  }

  public static void main(String[] args) {
    List<String> timePoints = List.of("00:00","23:59","00:00");
    System.out.println(findMinDifference(timePoints));
  }
}
