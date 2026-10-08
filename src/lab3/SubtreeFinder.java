package lab3;
import java.util.Set;

public class SubtreeFinder {
    private static TreeNode bestRoot;
    private static int bestSize;

    public static TreeNode findLargestSubtree(TreeNode root, Set<Integer> forbidden) {
        bestRoot = null;
        bestSize = 0;
        traverse(root, forbidden);
        return bestRoot;
    }

    private static int traverse(TreeNode node, Set<Integer> forbidden) {
        if (node == null) {
            return 0;
        }
        int leftResult = traverse(node.left, forbidden);
        int rightResult = traverse(node.right, forbidden);
        if (leftResult == -1 || rightResult == -1 || forbidden.contains(node.value)) {
            return -1;
        }
        int size = leftResult + rightResult + 1;
        if (size > bestSize) {
            bestSize = size;
            bestRoot = node;
        }
        return size;
    }

    public static void printSubtree(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printSubtree(node.left);
        printSubtree(node.right);
    }
}