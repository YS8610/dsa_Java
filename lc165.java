public class lc165 {

  private static int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int v1len = v1.length;
    int v2len = v2.length;
    int i = 0;
    int v1no, v2no;
    while (i < v1len || i < v2len) {
      v1no = i < v1len ? Integer.parseInt(v1[i]) : 0;
      v2no = i < v2len ? Integer.parseInt(v2[i]) : 0;
      if (v1no>v2no) return 1;
      if (v1no<v2no) return -1;
      i++;
    }
    return 0;
  }

  public static void main(String[] args) {
    String version1 = "0.1", version2 = "1.1";
    System.out.println(compareVersion(version1, version2));
  }
}
