package lab3;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Set<Integer> forbidden = new HashSet<>();
        forbidden.add(5);

        TreeNode result = SubtreeFinder.findLargestCleanSubtree(root, forbidden);

        System.out.println("Запрещённые вершины: " + forbidden);

        if (result == null) {
            System.out.println("Чистого поддерева не найдено");
        } else {
            System.out.println("Корень найденного поддерева: " + result.value);
            System.out.print("Вершины поддерева: ");
            SubtreeFinder.printSubtree(result);
            System.out.println();
        }
    }
}