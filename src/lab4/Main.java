package lab4;
/*Задача 14.
Дано N-дерево. Найти все поддеревья, структура которых совпадает с заданной.*/
public class Main{
    public static void main(String[] args){
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node2.addChild(new Node(5));
        node2.addChild(new Node(6));
        node3.addChild(new Node(7));
        node3.addChild(new Node(8));
        root.addChild(node2);
        root.addChild(node3);
        root.addChild(node4);
        Node pattern =new Node(0);
        pattern.addChild(new Node(125));
        pattern.addChild(new Node(31));
        DynamicArray matches = Matcher.findMatchingSubtrees(root, pattern);
        System.out.println("Найдено совпадений: " + matches.size());
        for (int i =0; i<matches.size();++i){
            System.out.println("Корень совпавшего поддерева: " + matches.get(i).value);
        }
    }
}