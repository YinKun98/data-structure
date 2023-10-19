package linkedList.singlyLinkedList;

/**
 * @Author: yin-k
 * @Description: 单链表测试
 * @Date: Created in 11:00 2022/12/11
 */
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        System.out.println(linkedList.getSize());
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        System.out.println(linkedList.getSize());
        linkedList.print();
        linkedList.add(4,"E");
        System.out.println(linkedList.getSize());
        linkedList.print();
        linkedList.delete(4);
        linkedList.print();
        System.out.println(linkedList.update(0,"FF"));
        linkedList.print();
    }
}
