import java.util.function.BiFunction;

public class Problem_50 {
    public interface Node {
    }
    // Internal node
    public static final class InternalNode implements Node {

        private final BiFunction<Double, Double, Double> function;
        private final Node left;
        private final Node right;

        public InternalNode(BiFunction<Double, Double, Double> function, Node left, Node right) {
            this.function = function;
            this.left = left;
            this.right = right;
        }
    }
    // Leaf Node
    public static final class LeafNode implements Node {
        private final double val;
        public LeafNode(double val) {
            this.val = val;
        }
    }

    private static double Evaluate(Node node) {
        if (node instanceof LeafNode)
            return ((LeafNode)node).val;

        double left = Evaluate(((InternalNode)node).left);
        double right = Evaluate(((InternalNode)node).right);
        return ((InternalNode)node).function.apply(left, right);
    }

    public static void main(String[] args){
        // creating tree
        BiFunction<Double, Double, Double> add = (a, b) -> a + b;
        BiFunction<Double, Double, Double> multiply = (a, b) -> a * b;
        InternalNode addLeft = new InternalNode(add, new LeafNode(3), new LeafNode(2));
        InternalNode addRight = new InternalNode(add, new LeafNode(4), new LeafNode(5));
        Node root = new InternalNode(multiply, addLeft, addRight);
        // Solving
        double ans = Evaluate(root);
        System.out.println("Evaluated value is "+ans);
    }

}
