package linkedList.doubleLinkedList;

/**
 * @Author: yin-k
 * @Description: 双向链表测试类
 * @Date: Created in 17:55 2022/12/11
 */
public class DoubleLinkedListTest {
    public static void main(String[] args) {
        DoubleLinkedList<String> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.addTail("A");
        doubleLinkedList.addTail("B");
        doubleLinkedList.print();
        doubleLinkedList.addHead("C");
        doubleLinkedList.print();
        System.out.println(doubleLinkedList.remove(1));
        doubleLinkedList.print();
        doubleLinkedList.add(1,"D");
        doubleLinkedList.print();
        doubleLinkedList.clear();
        doubleLinkedList.print();
    }
}
