package linkedList.doubleLinkedList;

/**
 * @Author: yin-k
 * @Description: 实现双向链表
 * @Date: Created in 11:20 2022/12/11
 */
public class DoubleLinkedList<T> {

    /*
    * 节点class
    * */
    private static class Node<T>{
        T value;
        Node<T> pre;
        Node<T> next;

        private Node(T value){
            this.value = value;
        }
    }
    /*
     * 双向链表含有三个属性，头结点、尾结点、节点数量
     * */
    private int size;
    private final Node<T> head;
    private final Node<T> tail;

    public DoubleLinkedList(){
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.next = tail;
        tail.pre = head;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void clear(){
        head.next = tail;
        tail.pre = head;
        size = 0;
    }


    /**
     * 尾插法
     * @param t 值
     */
    public void addTail(T t){
        Node<T> node = new Node<>(t);
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
        size++;
    }

    /**
     * 头插法
     * @param t value
     */
    public void addHead(T t){
        Node<T> node = new Node<T>(t);
        node.next=head.next;
        node.pre = head.next.pre;
        head.next.pre = node;
        head.next = node;
        size++;

    }

    /**
     * 指定位置插入
     * @param index 位置索引
     * @param value 值
     */
    public void add(int index, T value){
        if(index<0||index>size){
            throw new ArrayIndexOutOfBoundsException("非法的索引位置!");
        }
        if(index == size){
            addTail(value);
        }else if (index == 0){
            addHead(value);
        }else {
            Node<T> oldNode = node(index);
            Node<T> newNode = new Node<>(value);
            newNode.next = oldNode;
            newNode.pre = oldNode.pre;
            oldNode.pre.next = newNode;
            oldNode.pre = oldNode;
            size++;

        }
    }

    public T remove(int index){
        checkIndex(index);
        Node<T> node = node(index);
        node.next.pre = node.pre;
        node.pre.next = node.next;
        size--;
        return node.value;
    }



    /**
     * 获取指定位置的节点值
     * @param index 位置索引
     * @return value
     */
    public T get(int index){
        return node(index).value;
    }

    /**
     *
     * @param index 位置索引
     * @return 指定位置节点
     */
    private Node<T> node(int index){
        checkIndex(index);
        // 当索引位置在一半节点以前，就从头结点开始遍历，否则就从尾结点开始遍历
        Node<T> temp;
        if(index<=(size>>1)){
            temp = head;
            // -1代表的是是头结点的位置索引,当i等于index时，指针已经在指定位置了
            for (int i = -1; i < index; i++) {
                temp = temp.next;
            }
        }else{
            temp = tail;
            // size代表的是尾结点的位置索引,当i等于index时，指针已经在指定位置了
            for (int i = size; i > index; i--) {
                temp = temp.pre;
            }
        }
        return temp;

    }

    public void print(){
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if(i!=size-1){
                stringBuffer.append(get(i).toString()).append("<->");
            }else{
                stringBuffer.append(get(i));
            }
        }
        System.out.println("size:"+size+" "+stringBuffer.toString());
    }

    private  void checkIndex(int index){
        if(index<0 || index>size-1){
            throw new ArrayIndexOutOfBoundsException("非法的索引位置");
        }
    }

}
