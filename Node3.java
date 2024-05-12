import java.util.List;

public class Node3 {
    public int val;
    public List<Node3> children;

    public Node3() {}

    public Node3(int _val) {
        val = _val;
    }

    public Node3(int _val, List<Node3> _children) {
        val = _val;
        children = _children;
    }
}
