class lc789{
  private static boolean escapeGhosts(int[][] ghosts, int[] target) {
    int l = ghosts.length;
    int[] distG = new int[l];
    for (int i=0, n=0;i<l;i++)
      distG[n++] = Math.abs(ghosts[i][0]-target[0])+Math.abs(ghosts[i][1]-target[1]);
    int distP = Math.abs(target[0])+Math.abs(target[1]);
    for (int d : distG)
      if (distP >= d)
        return false;
    return true;
  }

  public static void main(String[] args){
    int[][] ghosts = {{1,0},{0,3}};
    int[] target = {0,1};
    System.out.println(escapeGhosts(ghosts, target));
  }
}
