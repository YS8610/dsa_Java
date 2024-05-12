import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class lc609 {
  private static List<List<String>> findDuplicate(String[] paths){
    Map<String,List<String>> memo = new HashMap<>();
    for (String path:paths){
      String[] files = path.split(" ");
      String dir = files[0];
      if (files.length==1) continue;
      for (int i=1,n=files.length;i<n;i++){
        int firstBracket = files[i].indexOf("(");
        int len = files[i].length();
        String content = files[i].substring(firstBracket, len);
        String fileDir = dir + "/" + files[i].substring(0,firstBracket);
        if (memo.containsKey(content)) memo.get(content).add(fileDir);
        else memo.put(content, new ArrayList<>( Arrays.asList(fileDir ) ));
      }
    }
    List<List<String>> ans = new ArrayList<>();
    for (String ctent: memo.keySet()){
      if (memo.get(ctent).size()>1) ans.add( new ArrayList<>(memo.get(ctent)) );
    } 
    return ans;
  }

  public static void main(String[] args) {
    String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
    System.out.println( findDuplicate(paths) );
  }
}
