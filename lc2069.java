import java.util.Arrays;

public class lc2069 {
    int width;
    int height;
    int dir;
    // e, n, w, s
    int[][] move = {
        { 1, 0 },
        { 0, 1 },
        { -1, 0 },
        { 0, -1 }
    };
    int[] pos;
    int perimeter;

    public lc2069(int width, int height) {
      this.width = width;
      this.height = height;
      // e, n, w, s
      this.dir = 0;
      this.pos = new int[] { 0, 0 };
      this.perimeter = width * 2 + height * 2 - 4;
    }

    public void step(int num) {
      int tmp;
      if (num >= perimeter)
        num %=perimeter;
      if (num == 0)
          num = perimeter;
      while (num > 0){
        int maxEast = width - pos[0]-1;
        int maxWest = pos[0];
        int maxNorth = height - pos[1] -1;
        int maxSouth = pos[1];
        // east
        if (dir == 0){
          tmp = Math.min(maxEast, num);
          if (tmp == 0)
            dir = (dir+1)%4;
          else
            pos[0] += tmp;
          num-=tmp;
        }
        // north
        else if (dir == 1){
          tmp = Math.min(maxNorth, num);
          if (tmp == 0)
            dir = (dir+1)%4;
          else
            pos[1] += tmp;
          num -=tmp;
        }
        // west
        else if (dir == 2){
          tmp = Math.min(maxWest, num);
          if (tmp == 0)
            dir = (dir+1)%4;
          else
            pos[0] -= tmp;
          num -=tmp;
        }
        // south
        else{
          tmp = Math.min(maxSouth, num);
          if (tmp == 0)
            dir = (dir+1)%4;
          else
            pos[1] -= tmp;
          num -=tmp;
        }
      }
    }

    public int[] getPos() {
      return this.pos;
    }

    public String getDir() {
      if (this.dir == 0)
        return "East";
      if (this.dir == 1)
        return "North";
      if (this.dir == 2)
        return "West";
      if (this.dir == 3)
        return "South";
      return "East";
    }


  public static void main(String[] args) {
    lc2069 robot = new lc2069(6,3);
    robot.step(2);
    robot.step(2);
    System.out.println(Arrays.toString(robot.getPos()));
    System.out.println(robot.getDir());
    robot.step(2);
    robot.step(1);
    robot.step(4);
    System.out.println(Arrays.toString(robot.getPos()));
    System.out.println(robot.getDir());
  }
}
