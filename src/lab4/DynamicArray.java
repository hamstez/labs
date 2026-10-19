package lab4;
public class DynamicArray{
    private Node[] items;
    private int size;

    public DynamicArray(){
        items = new Node[2];
        size = 0;
    }

    public void add(Node item){
        if (size == items.length){
            grow();
        }
        items[size] = item;
        size++;
    }

    public Node get(int index){
        if (index<0 || index >=size){
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return items[index];
    }

    public int size(){
        return size;
    }

    private void grow(){
        Node[] newItems = new Node[items.length * 2];
        for (int i=0; i<items.length; i++) {
            newItems[i]=items[i];
        }
        items = newItems;
    }
}