public class lc3484 {
  int[][] cells;

  public lc3484(int rows) {
    this.cells = new int[rows][26];
  }

  public void setCell(String cell, int value) {
    int col = cell.charAt(0) - 'A';
    int l = cell.length();
    int row = 0;
    for (int i = 1; i < l; i++)
      row = row * 10 + (cell.charAt(i) - '0');
    row--;
    this.cells[row][col] = value;
  }

  public void resetCell(String cell) {
    int col = cell.charAt(0) - 'A';
    int row = getRow(cell);
    this.cells[row][col] = 0;
  }

  public int getValue(String formula) {
    String[] elements = (formula.substring(1)).split("\\+");
    int ans = 0;
    int tmp;
    int col = 0;
    for (String e : elements) {
      tmp = 0;
      if (e.charAt(0) >= 'A' && e.charAt(0) <= 'Z') {
        col = e.charAt(0) - 'A';
        tmp = getRow(e);
        ans += this.cells[tmp][col];
        continue;
      }
      for (int i = 0; i < e.length(); i++)
        tmp = tmp * 10 + (e.charAt(i) - '0');
      ans += tmp;
    }
    return ans;
  }

  private int getRow(String cell) {
    int l = cell.length();
    int row = 0;
    for (int i = 1; i < l; i++)
      row = row * 10 + (cell.charAt(i) - '0');
    row--;
    return row;
  }
}
