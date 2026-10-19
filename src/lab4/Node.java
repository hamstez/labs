package lab4;
public class Node{
    int value;
    DynamicArray children;

    Node(int value){
        this.value = value;
        this.children = new DynamicArray();
    }

    void addChild(Node child){
        children.add(child);
    }
}