public class lc1514 {
  private static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
  
    return -1d;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] edges = {{0,1},{1,2},{0,2}};
    double[] succProb = {0.5,0.5,0.2};
    int start = 0, end = 2;
    System.out.println(maxProbability(n, edges, succProb, start, end));
  }
}
