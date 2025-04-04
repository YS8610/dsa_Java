import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class lc1028 {
  private static TreeNode recoverFromPreorder(String traversal) {
    int l = traversal.length();
    int node = 1;
    for (int i =1; i <l; i++){
      if (traversal.charAt(i) == '-') continue;
      if (traversal.charAt(i-1) == '-') node++;
    }
    int[][] arr = new int[node][2];
    genArr(traversal, arr, 0, 0, 0, 0);
    System.out.println(Arrays.deepToString(arr));
    TreeNode root = new TreeNode(arr[0][0]);
    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.add(root);
    int lvl;
    TreeNode top;
    TreeNode tmp;
    for (int i =1; i<node;i++){
      lvl = arr[i][1];
      while (!stack.isEmpty() && stack.size() != lvl)
        stack.pollLast();
      top = stack.peekLast();
      tmp = new TreeNode(arr[i][0]);
      if (top.left != null)
        top.right = tmp;
      else
        top.left = tmp;
      stack.add(tmp);
    }
    return root;
  }

  private static void genArr(String str, int[][] arr, int stridx, int lvlno, int sum, int arridx){
    int l = str.length();
    if (stridx >= l) {
      arr[arridx++][0] = sum;
      return;
    }
    // '-'
    if (str.charAt(stridx) == '-'){
      if (sum != 0){
        arr[arridx++][0] = sum;
        sum = 0;
      }
      genArr(str, arr, stridx+1, lvlno+1, 0, arridx);
      return;
    }
    // number
    if (lvlno !=0){
      arr[arridx][1] = lvlno;
      lvlno=0;
    }
    sum = sum*10 + str.charAt(stridx) - '0';
    genArr(str, arr, stridx+1, lvlno, sum, arridx);
  }

  public static void main(String[] args) {
    String traversal = "121-401--349---90--88";
    System.out.println(recoverFromPreorder(traversal));
  }
}
