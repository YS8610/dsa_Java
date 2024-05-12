public class lc223 {
  private static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int a1 = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
    int a2 = Math.abs(bx2 - bx1) * Math.abs(by2 - by1);
    int totalArea = a1 + a2;
    // if a is completely inside b (b larger or equal size)
    if ((bx1 <= ax1 && bx2 >= ax2 && by1 <= ay1 && by2 >= ay2)) {
      return Math.max(a1, a2);
    }
    // if b is completely inside a (a larger or equal size)
    if (ax1 <= bx1 && ax2 >= bx2 && ay1 <= by1 && ay2 >= by2){
      return Math.max(a1, a2);
    }
    // assume rectangle a on left side and on top of rectangle b
    if (ax1 < bx1 && ay1 > by1) {
      if (ax2 <= bx1)
        return totalArea;
      if (ay1 >= by2)
        return totalArea;
      return totalArea - Math.abs(bx1 - Math.min(ax2, bx2)) * Math.abs(ay1 - Math.min(ay2, by2));
    }
    // assume rectangle a on right side and on top of rectangle b
    else if (ax1 > bx1 && ay1 > by1) {
      if (bx2 <= ax1)
        return totalArea;
      if (ay1 >= by2)
        return totalArea;
      return totalArea - Math.abs(ax1 - Math.min(ax2, bx2)) * Math.abs(ay1 - Math.min(ay2, by2));
    }
    // assume rectangle a on left side and on below of rectangle b
    else if (ax1 < bx1 && ay1 < by1) {
      if (ax2 <= bx1)
        return totalArea;
      if (ay2 <= by1)
        return totalArea;
      return totalArea - Math.abs(bx1 - Math.min(ax2, bx2)) * Math.abs(by1 - Math.min(ay2, by2));
    }
    // assume rectangle a on right side and on below of rectangle b
    else if (ax1 > bx1 && ay1 < by1) {
      if (bx2 <= ax1)
        return totalArea;
      if (ay2 <= by1)
        return totalArea;
      return totalArea - Math.abs(ax1 - Math.min(ax2, bx2)) * Math.abs(by1 - Math.min(ay2, by2));
    }
    // assume rectangle a on left side and same level as rectangle b
    else if (ax1 < bx1 && ay1 == by1) {
      if (ax2 <= bx1)
        return totalArea;
      return totalArea - Math.abs(bx1 - Math.min(ax2, bx2)) * Math.min(Math.abs(ay1 - ay2), Math.abs(by1 - by2));

    }
    // assume rectangle a on right side and same level as rectangle b
    else if (ax1 > bx1 && ay1 == by1) {
      if (ax1 >= bx2)
        return totalArea;
      return totalArea - Math.abs(ax1 - Math.min(ax2, bx2)) * Math.min(Math.abs(ay1 - ay2), Math.abs(by1 - by2));
    }
    // assume rectangle a on same side and on top of rectangle b
    else if (ax1 == bx1 && ay1 > by1) {
      if (ay1 >= by2)
        return totalArea;
      return totalArea - Math.abs(ay1 - Math.min(ay2, by2)) * Math.min(Math.abs(ax1 - ax2), Math.abs(bx1 - bx2));
    }
    // assume rectangle a on same side and on below of rectangle b
    else if (ax1 == bx1 && ay1 < by1) {
      if (by1 >= ay2)
        return totalArea;
      return totalArea - Math.abs(by1 - Math.min(ay2, by2)) * Math.min(Math.abs(ax1 - ax2), Math.abs(bx1 - bx2));
    }
    // both rectangle got the same lower left corner
    else {
      return totalArea
          - Math.min(Math.abs(ax1 - ax2), Math.abs(bx1 - bx2)) * Math.min(Math.abs(ay1 - ay2), Math.abs(by1 - by2));
    }
  }

  public static void main(String[] args) {
    int ax1 = -3, ay1 = 0;
    int ax2 = 3, ay2 = 4;
    int bx1 = 0, by1 = -1;
    int bx2 = 9, by2 = 2;
    System.out.println( computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
  }
}
