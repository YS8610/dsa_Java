import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc2353 {
  class Food {
    String name;
    int rating;

    public Food(String name, int rating) {
      this.name = name;
      this.rating = rating;
    }
  }

  Map<String, PriorityQueue<Food>> map;
  Map<String, Integer> m1;
  Map<String, String> m2;

  public lc2353(String[] foods, String[] cuisines, int[] ratings) {
    this.map = new HashMap<>();
    this.m1 = new HashMap<>();
    this.m2 = new HashMap<>();
    int l = foods.length;
    for (int i = 0; i < l; i++) {
      m1.put(foods[i], ratings[i]);
      m2.put(foods[i], cuisines[i]);
      Food food = new Food(foods[i], ratings[i]);
      if (map.containsKey(cuisines[i])) {
        map.get(cuisines[i]).add(food);
      } else {
        PriorityQueue<Food> pq = new PriorityQueue<>((m1, m2) -> {
          if (m1.rating == m2.rating)
            return m1.name.compareTo(m2.name);
          return Integer.compare(m2.rating, m1.rating);
        });
        pq.add(food);
        map.put(cuisines[i], pq);
      }
    }
  }

  public void changeRating(String food, int newRating) {
    if (m1.get(food) != newRating) {
      m1.put(food, newRating);
    }
    String cuisine = m2.get(food);
    map.get(cuisine).add(new Food(food, newRating));
  }

  public String highestRated(String cuisine) {
    PriorityQueue<Food> pq = map.get(cuisine);
    while (pq.peek().rating != m1.get(pq.peek().name))
      pq.poll();
    return pq.peek().name;
  }
}
