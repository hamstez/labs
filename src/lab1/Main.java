/*Задача 14.
Используя очередь, отредактировать текст, оставляя один пробел в каждой серии пробелов.*/
public class Main {
    public static void main(String[] args) {
        String text = " fefs   ef ewewqq     q dqdd    d  ";
        Queue input = new Queue();
        for (int i = 0; i < text.length(); i++) {
            input.enqueue(text.charAt(i));
        }
        Queue res = new Queue();
        boolean prevSpace = false;
        while (!input.isEmpty()) {
            char c = input.dequeue();
            if (c == ' ') {
                if (!prevSpace) {
                    res.enqueue(c);
                }
                prevSpace = true;
            } else {
                res.enqueue(c);
                prevSpace = false;
            }
        }
        System.out.println("Исходная строка:");
        System.out.println(text);
        System.out.println("Результат:");
        while (!res.isEmpty()) {
            System.out.print(res.dequeue());
        }
        System.out.println();
    }
}