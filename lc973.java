import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.PriorityQueue;

public class lc973 {

  public int[][] kClosest(int[][] points, int k) {
    int l = points.length;
    Point2D[] data = new Point2D[l];
    for (int i = 0; i < l; i++) data[i] = new Point(points[i][0], points[i][1]);
    PriorityQueue<Point2D> pq = new PriorityQueue<>((m1, m2) ->
      Double.compare(m1.distance(0, 0), m2.distance(0, 0))
    );
    for (Point2D p : data) pq.add(p);
    int[][] ans = new int[k][2];
    Point2D tmp;
    for (int i = 0; i < k && !pq.isEmpty(); i++) {
      tmp = pq.poll();
      ans[i][0] = (int) tmp.getX();
      ans[i][1] = (int) tmp.getY();
    }
    return ans;
  }
}
