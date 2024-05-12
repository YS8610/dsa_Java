public class lc2140 {
  private static long mostPoints(int[][] questions) {
    long max = 0;
    for (int i=0, n=questions.length; i<n; i++){
      long result = questions[i][0];
      for (int j=i+questions[i][1]+1;j<n;j+=questions[j][1]+1 ){
        result +=  questions[j][0];
      }
      if (i==0) max = result;
      else max = max>result?max:result;
    }
    return max;
  }

  public static void main(String[] args) {
    int[][] questions = {{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}};

    System.out.println( mostPoints(questions) );
  }
}
