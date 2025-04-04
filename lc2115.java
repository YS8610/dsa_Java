import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

class lc2115{

  private static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    Set<String> ans = new HashSet<>();
    Set<String> cannot = new HashSet<>();
    Map<String, Integer> recipesMap = new HashMap<>();
    for (int i =0,n=recipes.length;i<n;i++)
      recipesMap.put(recipes[i],i);
    Set<String> set = new HashSet<>();
    for (String s : supplies)
      set.add(s);
    for (String r : recipes)
      dfs(ans, cannot, set, recipesMap, ingredients, r, new HashSet<>());
    return new ArrayList<>(ans);
  }

  private static boolean dfs(Set<String>ans, Set<String>cannot, Set<String> set, Map<String, Integer> recipesMap, List<List<String>>ingredients, String recipe, Set<String> visited){
    if (ans.contains(recipe)) 
      return true;
    if (cannot.contains(recipe))
      return false;
    if (visited.contains(recipe))
      return false;
    visited.add(recipe);
    int id = recipesMap.get(recipe);
    boolean tmp;
    for (String ing : ingredients.get(id)){
      if (set.contains(ing))
        continue;
      if (!recipesMap.containsKey(ing)){
        cannot.add(ing);
        return false;
      }
      tmp = dfs(ans, cannot, set, recipesMap, ingredients, ing, new HashSet<>(visited));
      if (!tmp){
        cannot.add(ing);
        return false;
      }
    }
    ans.add(recipe);
    return true;
  }

  static public void main(String[] args){
    String[] recipes = {"ju","fzjnm","x","e","zpmcz","h","q"};
    List<List<String>> ingredients = new ArrayList<>();
    ingredients.add(List.of("d"));
    ingredients.add(List.of("hveml","f","cpivl"));
    ingredients.add(List.of("cpivl","zpmcz","h","e","fzjnm","ju"));
    ingredients.add(List.of("cpivl","hveml","zpmcz","ju","h"));
    ingredients.add(List.of("h","fzjnm","e","q","x"));
    ingredients.add(List.of("d","hveml","cpivl","q","zpmcz","ju","e","x"));
    ingredients.add(List.of("f","hveml","cpivl"));
    String[] supplies = {"f","hveml","cpivl","d"};
    System.out.println(findAllRecipes(recipes, ingredients, supplies).toString());
  }

}
