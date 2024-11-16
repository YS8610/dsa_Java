import java.util.HashSet;
import java.util.Set;

public class lc507 {
  private static boolean checkPerfectNumber(int num) {
    if (num==1) return false;
    Set<Integer> s = new HashSet<>();
    s.add(1);
    int sum = 1;
    for (int i =2, tmp=0; i<num;i++){
      if (num%i==0){
        if (s.contains(i)) break;
        s.add(i);
        sum+=i;
        tmp = num/i;
        if (s.contains(tmp)) break;
        s.add(tmp);
        sum+=tmp;
      }
    }
    return num==sum;
  }

  public static void main(String[] args) {
    int num=28;
    System.out.println(checkPerfectNumber(num));
  }
}
