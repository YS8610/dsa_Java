public class lc1603 {
  int[] space;
  public lc1603(int big, int medium, int small) {
    this.space = new int[]{big,medium,small};
  }

  public boolean addCar(int carType) {
      if (this.space[carType-1]>0) {
        this.space[carType-1] --;
        return true;
      }
      return false;
  }

  public static void main(String[] args) {
    lc1603 obj = new lc1603(1, 1, 0);
    boolean param_1 = obj.addCar(1);
    boolean param_2 = obj.addCar(2);
    boolean param_3 = obj.addCar(3);
    boolean param_4 = obj.addCar(1);
    System.out.println( param_1);
    System.out.println( param_2);
    System.out.println( param_3);
    System.out.println( param_4);
  }
}
