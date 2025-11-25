import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class lc1797 {
  int ttl;
  Set<String> set;
  Map<String, Integer> map;

  public lc1797(int timeToLive) {
    this.ttl = timeToLive;
    this.map = new HashMap<>();
    this.set = new LinkedHashSet<>();
  }

  public void generate(String tokenId, int currentTime) {
    this.map.put(tokenId, currentTime);
    this.set.add(tokenId);
  }

  public void renew(String tokenId, int currentTime) {
    int time = this.map.getOrDefault(tokenId, -1);
    if (time == -1 || time + this.ttl <= currentTime) {
      evict(currentTime);
      return;
    }
    this.map.put(tokenId, currentTime);
    this.set.remove(tokenId);
    this.set.add(tokenId);
  }

  public int countUnexpiredTokens(int currentTime) {
    evict(currentTime);
    return this.set.size();
  }

  private void evict(int ctime) {
    Iterator<String> it = this.set.iterator();
    String tmp;
    while (it.hasNext()) {
      tmp = it.next();
      if (map.get(tmp) + this.ttl > ctime)
        return;
      it.remove();
      this.map.remove(tmp);
    }
  }
}
