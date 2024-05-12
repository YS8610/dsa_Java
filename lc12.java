import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc12 {
  private static String intToRoman(int num){
    Map<Integer,String> map = new HashMap<>();
    map.put(0,"");
    map.put(1,"I");
    for (int i=2; i<4;i++) map.put(i, map.get(i-1)+"I" ); 
    map.put(4,"IV");
    map.put(5,"V");
    for (int i=6; i<9;i++) map.put(i, map.get(i-1)+"I" );
    map.put(9,"IX");
    // 10
    map.put(10,"X");
    for (int i=20; i<40;i+=10) map.put(i, map.get(i-10)+"X" );
    map.put(40,"XL");
    map.put(50,"L");
    for (int i=60; i<90;i+=10) map.put(i, map.get(i-10)+"X" );
    map.put(90,"XC");
    // 100
    map.put(100,"C");
    for (int i=200; i<400;i+=100) map.put(i, map.get(i-100)+"C" );
    map.put(400,"CD");
    map.put(500,"D");
    for (int i=600; i<900;i+=100) map.put(i, map.get(i-100)+"C" );
    map.put(900,"CM");
    // 1000
    map.put(1000,"M");
    for (int i=2000; i<4000;i+=1000) map.put(i, map.get(i-1000)+"M" );

    int[] numArray = Arrays.stream( String.valueOf(num).split("") )
                            .mapToInt(Integer::valueOf)
                            .toArray();
    int len = numArray.length;
    String ans = "";
    int power = numArray.length-1;
    for (int i=0; i<len;i++){
      ans += map.get( (int) Math.pow(10, power-i) * numArray[i] ) ;
    }
    
    return ans;
  }
  public static void main(String[] args) {
    int num = 3999;
    System.out.println( intToRoman(num) );
  }
}
