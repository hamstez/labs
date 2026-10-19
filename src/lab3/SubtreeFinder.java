package lab3;
public class SubtreeFinder{
    private static TreeNode bestRoot;
    private static int bestSize;

    public static TreeNode findLargestSubtree(TreeNode root, int[] forbidden){
        bestRoot = null;
        bestSize = 0;
        traverse(root, forbidden);
        return bestRoot;
    }

    private static boolean isForbidden(int value, int[] forbidden){
        for (int i=0; i<forbidden.length; i++){
            if (forbidden[i] == value) {
                return true;
            }
        }
        return false;
    }

    private static int traverse(TreeNode node, int[] forbidden){
        if (node == null) {
            return 0;
        }
        int leftResult = traverse(node.left, forbidden);
        int rightResult = traverse(node.right, forbidden);
        if (leftResult == -1 || rightResult == -1 || isForbidden(node.value, forbidden)){
            return -1;
        }
        int size = leftResult + rightResult + 1;
        if (size > bestSize) {
            bestSize = size;
            bestRoot = node;
        }
        return size;
    }

    public static void printSubtree(TreeNode node){
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        printSubtree(node.left);
        printSubtree(node.right);
    }
}