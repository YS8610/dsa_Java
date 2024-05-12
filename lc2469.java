public class lc2469 {
  private static double[] convertTemperature(double celsius){
    double[] ans = new double[2];
    ans[0] = celsius + 273.15d;
    ans[1] = celsius *1.80d + 32d; 
    return ans;
  }
  public static void main(String[] args) {
    double celsius = 36.50;
    System.out.println(convertTemperature(celsius));
  }
}
