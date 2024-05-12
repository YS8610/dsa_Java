import java.util.ArrayList;
import java.util.List;


public class lc1161 {
  // only work if it is a complete binary tree
  // private static int maxLevelSum1(TreeNode root) {
  //   Queue<TreeNode> q = new ArrayDeque<>();
  //   int highSum =root.val;
  //   int counter=0;
  //   int lvl=0;
  //   int sum =0;
  //   int anslvl=0;
  //   q.add(root);
  //   while (!q.isEmpty()){
  //     TreeNode first = q.poll();
  //     counter++;
  //     if ( counter >= (1<<(lvl+1)) ) {
  //       if (sum>highSum) anslvl = lvl;
  //       // if (sum>=highSum) anslvl = lvl;
  //       lvl++;
  //       highSum = sum>=highSum?sum:highSum;
  //       sum=0;
  //     }
  //     sum+=first.val;
  //     if(first.left==null && first.right==null) continue;
  //     if (first.left!=null) q.add(first.left);
  //     else q.add(new TreeNode(0));
  //     if (first.right!=null) q.add(first.right);
  //     else q.add(new TreeNode(0));
  //   }
  //   if (sum>highSum) anslvl = lvl;
  //   return anslvl+1;
  // }

  private static int maxLevelSum(TreeNode root) {
    List<TreeNode> parentList = new ArrayList<>();
    List<TreeNode> childList;
    int lvl=0;
    int highestSum = root.val;
    int sum=0;
    int anslvl=1;
    parentList.add(root);
    while (!parentList.isEmpty()){
      lvl++;
      sum=0;
      childList= new ArrayList<>();

      for (TreeNode parent : parentList) {
        sum +=parent.val;
        if (parent.left!=null) childList.add(parent.left);
        if (parent.right!=null) childList.add(parent.right);
      }
      if (sum>highestSum){
        anslvl=lvl;
        highestSum = sum;
      } 
      parentList = new ArrayList<>(childList);
    }
    return anslvl;
  }
  // binary tree
  public static void main(String[] args) {
    int nullSub = 0;
    // List<Integer> treeNodesVal= List.of(63909,43838,4549,-31714,-99701,-96320,88666,75152,-14750,-12671,60405,nullSub,29388,nullSub,nullSub,nullSub,-83674,nullSub,nullSub,-83490,nullSub,-49913,86188,84455,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,-36061,91438,-75550);
    // List<Integer> treeNodesVal= List.of(-27745,27518,54612,nullSub,79175,-55310,-38265,nullSub,nullSub,73079,-42208,37513,18112,-73627,nullSub,91755,nullSub,nullSub,-60797,-78407,29146,11707,nullSub,nullSub,-42650,-12111,nullSub,-36290,82890,60637,51963,nullSub,nullSub,nullSub,nullSub,83323,nullSub,78120,nullSub,-61634,-12828,36784,53898,-50094,-83697,nullSub,-89871,-28950,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,-69294,-69762,65189,83559,68085,41715,nullSub,nullSub,nullSub,nullSub,nullSub,-88143,-27856,nullSub,9949,nullSub,nullSub,2575,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,nullSub,-6319,-78964,nullSub,-43587,-14981,nullSub,nullSub,84885,84898,nullSub,nullSub,-2467,-95751);
    // List<Integer> treeNodesVal= List.of(-100,-200,-300,-20,-5,-10,nullSub);
    List<Integer> treeNodesVal= List.of(989,nullSub,10250,98693,-89388,nullSub,nullSub,nullSub,-32127);
    List<Integer> b = new ArrayList<>();
    for (Integer val :treeNodesVal) {
      if (val!=nullSub) b.add(val);
      else b.add(null);
    }
    TreeNode p0 = TreeNode.populate(b);
    System.out.println( maxLevelSum(p0) );
  }
}
