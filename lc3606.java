import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc3606 {
  public record PromoCode(String code, int i) {};

  public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
    int l = code.length;
    List<PromoCode> subans = new ArrayList<>(l);
    List<String> ans = new ArrayList<>(l);
    Set<String> set = new HashSet<>();
    set.add("electronics");
    set.add("grocery");
    set.add("pharmacy");
    set.add("restaurant");
    for (int i = 0; i < l; i++) {
      if (!isActive[i] || !validator(code[i]) || !set.contains(businessLine[i]))
        continue;
      subans.add(new PromoCode(code[i], i));
    }
    Collections.sort(subans, (m1, m2) -> {
      int i1 = m1.i();
      int i2 = m2.i();
      if (businessLine[i1].equals(businessLine[i2]))
        return m1.code().compareTo(m2.code());
      return businessLine[i1].compareTo(businessLine[i2]);
    });
    // System.out.println(subans.toString());
    for (PromoCode p : subans)
      ans.add(p.code());
    return ans;
  }

  private boolean validator(String code) {
    int l = code.length();
    if (code.isBlank())
      return false;
    for (int i = 0; i < l; i++) {
      if (code.charAt(i) == ' ')
        return false;
      if (Character.isLetterOrDigit(code.charAt(i)) || code.charAt(i) == '_')
        continue;
      return false;
    }
    return true;
  }
}
