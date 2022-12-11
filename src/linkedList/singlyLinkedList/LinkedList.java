package linkedList.singlyLinkedList;

/**
 * @Author: yin-k
 * @Description: 单向链表实现类
 * @Date: Created in 19:50 2022/11/6
 */
public class LinkedList<T> {

    /**
    * 节点class
    * */
    private static class Node<T> {
        private T t;           // 值
        private Node<T> next;  // 指针

        private Node(T t){
            this.t = t;
        }
    }

    /**
     * 头结点，头结点是为了方便在下面的方法中遍历链表用的
     * 初始化的时候默认创建一个空的node对象
     */
    private final Node<T> head = new Node<>(null);

    /**
     * 链表的节点数量
     */
    private int size; // 默认是0，不包括头结点

    /*
     * 注意点：
     * 1、只有添加操作的索引判断是 index>size,其余都是index>size-1；
     * 2、使用counter=-1，来标识头结点的；
     * 3、遍历时，要新建临时节点，并将头结点复制给它，用它来遍历；
     * 4、get()每次都会从头结点开始遍历，丧失了随机存取的性能；
     * 5、使用构造函数创建链表时，size初始化为0；
     * 6、链表默认含有两个属性，一个头结点，一个size变量
     */

    public LinkedList(){
    }
    /**
    * 链表结尾添加节点
    * */
    public void add(T t){
        Node<T> temp = head;        // 新建一个节点指向头结点
        while (temp.next != null){  // 找最后一个节点
            temp = temp.next;
        }
        temp.next = new Node<>(t);  // 在链尾新增一个节点
        size++;
    }

    /**
     * 在指定位置添加节点
     * @param index 位置索引
     * @param t    值
     */
    public void add(int index, T t){
        if(index<0 || index>size){
            throw new ArrayIndexOutOfBoundsException("非法的索引位置！");
        }else{
            Node<T> temp = head; // 临时引用变量节点复制头结点，用来从前到后遍历整个链表
            int counter = -1;    // 用来寻找插入位置
            while(temp != null){
                /*
                 * 找目标节点的前一个节点，
                 * 将counter的初始值设为-1，来标识头节点
                 * 如果当前节点不是插入的前一个节点，就将counter++；
                */
                if((index-1)==counter){
                    Node<T> node = new Node<>(t);
                    Node<T> back = temp.next;
                    temp.next = node;
                    node.next = back;
                    size++;
                    break;
                }
                temp = temp.next;
                counter++;
            }
        }
    }

    /**
     * 删除指定位置节点
     * @param index 位置索引
     */
    public void delete(int index){
        if(index < 0 || index>size-1 ){
            throw new ArrayIndexOutOfBoundsException("非法的索引位置");
        }else{
            Node<T> temp = head;
            int counter = -1;
            while (temp != null){
                if(index - 1 ==counter){
                    temp.next = temp.next.next;
                    size--;
                    break;
                }
                temp = temp.next;
                counter++;
            }
        }
    }

    /**
     * 更新指定位置的值
     * @param index 索引
     * @param t 值
     * @return 返回更新后该节点的值
     */
    public T update(int index,T t){
        if(index<0 || index > size-1){
            throw  new ArrayIndexOutOfBoundsException("非法的索引位置！");
        }else {
            Node<T> temp = head;
            int counter = -1;
            while (temp != null){
                if(counter == index){
                    temp.t = t;
                    return temp.t;
                }
                temp = temp.next;
                counter++;
            }
        }
        return null;
    }

    /**
     * 获取指定索引位置的值
     * @param index 位置索引
     * @return 返回值
     */

    public T get(int index){
        if(index < 0 || index > size-1){
            throw  new ArrayIndexOutOfBoundsException("非法的索引位置");
        }else {
            Node<T> temp = head;
            int counter = -1;
            while (temp != null){
                if(counter == index){
                    return temp.t;
                }
                temp = temp.next;
                counter++;
            }
        }
        return null;
    }

    public int getSize() {
        return size;
    }

    /**
     * 打印当前链表的数据
     */
    public void print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<size;i++){
            if(i!=size-1){
                stringBuilder.append(get(i)).append("->");
            }else {
                stringBuilder.append(get(i));
            }
        }
        System.out.println(stringBuilder.toString());
    }

}

