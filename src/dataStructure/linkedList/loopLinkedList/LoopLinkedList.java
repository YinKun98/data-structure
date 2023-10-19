package linkedList.loopLinkedList;

/**
 * @Author: yin-k
 * @Description: 单向循环链表
 * @Date: Created in 22:43 2022/12/11
 */
public class LoopLinkedList<T> {
    private static class Node<T>{
        private T data;
        private Node<T> next;
        public Node(){}
        public Node(T data){this.data=data;}
    }

    /*
    * 单循环链表头结点 不在环里
    * */
    private Node<T> head;
    private int size;

    public LoopLinkedList(){
        head = new Node<>(null);
        size=0;
    }

    public int getSize() {
        return size;
    }
}
