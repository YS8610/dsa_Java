import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.TreeSet;

public class lc1912 {
  List<Map<Integer, Entry>> pricelist;
  PriorityQueue<Entry> rented;
  Map<Integer, SortedSet<Entry>> movieMap;

  class Entry{
    int shop;
    int movie;
    int px;

    public Entry(int shop, int movie, int px){
      this.shop = shop;
      this.movie = movie;
      this.px = px;
    }

    public boolean equals(Entry e){
      if (e.shop == this.shop && e.movie == this.movie && this.px == e.px)
        return true;
      return false;
    }
  }

  public lc1912(int n, int[][] entries) {
    int shop, movie, px;
    this.rented = new PriorityQueue<>((m1, m2) -> {
      if (m1.px == m2.px) {
        if (m1.shop == m2.shop)
          return Integer.compare(m1.movie, m2.movie);
        return Integer.compare(m1.shop, m2.shop);
      }
      return Integer.compare(m1.px, m2.px);
    });
    this.pricelist = new ArrayList<>(n);
    for (int i = 0; i < n; i++)
      this.pricelist.add(new HashMap<>());
    this.movieMap = new HashMap<>();
    for (int[] entry : entries) {
      shop = entry[0];
      movie = entry[1];
      px = entry[2];
      Entry e = new Entry(shop, movie,px);
      this.pricelist.get(shop).put(movie, e);
      if (!this.movieMap.containsKey(movie)){
        this.movieMap.put(movie, new TreeSet<>((m1,m2) ->{
          if (m1.px == m2.px)
            return Integer.compare(m1.shop, m2.shop);
          return Integer.compare(m1.px, m2.px);
        }));
      }
      this.movieMap.get(movie).add(e);
    }
  }

  public List<Integer> search(int movie) {
    List<Integer> ans = new ArrayList<>(5);
    int i = 0;
    for (Entry s : this.movieMap.getOrDefault(movie, new TreeSet<>())){
      if (i++ >= 5)
        break;
      ans.add(s.shop);
    }
    return ans;
  }

  public void rent(int shop, int movie) {
    Entry entry = this.pricelist.get(shop).get(movie);
    this.rented.add(entry);
    this.movieMap.get(movie).remove(entry);
  }
  
  public void drop(int shop, int movie) {
    Entry entry = this.pricelist.get(shop).get(movie);
    this.movieMap.get(movie).add(entry);
    this.rented.remove(entry);
  }

  public List<List<Integer>> report() {
    List<List<Integer>> ans = new ArrayList<>(5);
    Entry[] tmp = new Entry[5];
    Entry r;
    int i =0;
    while (!this.rented.isEmpty() && i < 5){
      r =this.rented.poll();
      ans.add(List.of(r.shop, r.movie));
      tmp[i++] = r;
    }
    while (--i >= 0)
      this.rented.add(tmp[i]);
    return ans;
  }

  public static void main(String[] args){
    int n = 10;
    int[][] entries = {{4,374,55},{1,6371,21},{8,3660,24},{1,56,32},{5,374,71},{3,4408,36},{6,9322,73},{6,9574,92},{8,7834,62},{2,6084,27},{7,3262,89},{2,8959,53},{0,3323,41},{6,6565,45},{0,4239,20}};
    lc1912 obj = new lc1912(n, entries);
    obj.rent(0,4239);
    obj.drop(0, 4239);
    obj.rent(3,4408);
    obj.rent(2,6084);
    obj.rent(0,4239);
    obj.drop(0, 4239);
    System.out.println(obj.search(9346).toString());
    System.out.println(obj.report().toString());
    obj.rent(6,9322);
    System.out.println(obj.search(8698).toString());
    obj.rent(0,4239);
    System.out.println(obj.report().toString());


  }
}
