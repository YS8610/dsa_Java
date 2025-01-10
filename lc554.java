import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class lc554{
	private static int leastBricks(List<List<Integer>> wall) {
		Map<Integer,Integer> map = new HashMap<>();
		int tmp = 0;
		int width = 0;
		for (int brick : wall.get(0))
			width += brick;
		for (List<Integer> brick : wall){
			tmp = 0;
			for (int b: brick){
				tmp += b;
				if (tmp == width) break;
				map.computeIfPresent(tmp, (k,v) -> v+1);
				map.computeIfAbsent(tmp, k -> 1);
			}
		}
		tmp = 0;
		for (Map.Entry<Integer,Integer>entry: map.entrySet())
			tmp = Math.max(tmp, entry.getValue());
		return wall.size()-tmp;
	}

	public static void main(String[] args){
		List<List<Integer>> wall = new ArrayList<>();
		wall.add(List.of(1,2,2,1));
		wall.add(List.of(3,1,2));
		wall.add(List.of(1,3,2));
		wall.add(List.of(2,4));
		wall.add(List.of(3,1,2));
		wall.add(List.of(1,3,1,1));
		wall.add(List.of(3,3));
		System.out.println(leastBricks(wall));
	}
}
