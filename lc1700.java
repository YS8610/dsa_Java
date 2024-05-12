public class lc1700 {

  private static int countStudents(int[] students, int[] sandwiches) {
    int no = students.length;
    int sum = 0;
    for (int s : students) sum += s;
    for (int i = 0, n = no; i < n; i++) {
      if (sandwiches[i] == 1) {
        if (sum < 1) return no;
        no--;
        sum--;
      } else {
        if (no - sum == 0) return no;
        no--;
      }
    }
    return no;
  }

  public static void main(String[] args) {
    int[] students = {1,1,1,0,0,1}, sandwiches = {1,0,0,0,1,1};
    System.out.println(countStudents(students, sandwiches));
  }
}
