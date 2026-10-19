package lab4;
public class Matcher{
    public static boolean isStructureMatch(Node a,Node b){
        if (a.children.size() != b.children.size()){
            return false;
        }
        for (int i = 0; i <a.children.size(); i++){
            if (!isStructureMatch(a.children.get(i), b.children.get(i))){
                return false;
            }
        }
        return true;
    }

    public static DynamicArray findMatchingSubtrees(Node root, Node pattern){
        DynamicArray result = new DynamicArray();
        traverse(root, pattern, result);
        return result;
    }

    private static void traverse(Node node, Node pattern, DynamicArray result){
        if (isStructureMatch(node, pattern)) {
            result.add(node);
        }
        for (int i = 0; i < node.children.size(); i++) {
            traverse(node.children.get(i), pattern, result);
        }
    }
}