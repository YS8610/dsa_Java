import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class lc3408 {
  PriorityQueue<int[]> pq;
  Map<Integer, int[]> map;

  public lc3408(List<List<Integer>> tasks) {
    this.map = new HashMap<>();
    this.pq = new PriorityQueue<>((m1, m2) -> {
      if (m1[2] == m2[2]) {
        if (m1[1] == m2[1])
          return Integer.compare(m2[0], m1[0]);
        return Integer.compare(m2[1], m1[1]);
      }
      return Integer.compare(m2[2], m1[2]);
    });
    for (List<Integer> t : tasks) {
      this.pq.add(new int[] { t.get(0), t.get(1), t.get(2) });
      this.map.put(t.get(1), new int[] { t.get(0), t.get(2) });
    }
  }

  public void add(int userId, int taskId, int priority) {
    this.pq.add(new int[] { userId, taskId, priority });
    this.map.put(taskId, new int[] { userId, priority });
  }

  public void edit(int taskId, int newPriority) {
    int[] val = this.map.get(taskId);
    val[1] = newPriority;
    this.pq.add(new int[] { val[0], taskId, newPriority });
  }

  public void rmv(int taskId) {
    this.map.remove(taskId);
  }

  public int execTop() {
    while (!this.pq.isEmpty()
        && this.pq.peek()[2] != this.map.getOrDefault(this.pq.peek()[1], new int[] { -1, -1 })[1])
      this.pq.poll();
    if (this.pq.isEmpty())
      return -1;
    int[] task = this.pq.poll();
    this.map.remove(task[1]);
    return task[0];
  }

  public static void main(String[] args) {
    List<List<Integer>> tasks = new ArrayList<>();
    tasks.add(List.of(1, 101, 8));
    tasks.add(List.of(2, 102, 20));
    tasks.add(List.of(3, 103, 5));
    lc3408 taskmaster = new lc3408(tasks);
    taskmaster.add(4, 104, 5);
    taskmaster.edit(102, 9);
    System.out.println(taskmaster.execTop());
    taskmaster.rmv(101);
    taskmaster.add(50, 101, 8);
    System.out.println(taskmaster.execTop());
  }
}
