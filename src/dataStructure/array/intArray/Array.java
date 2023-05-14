package array.intArray;

/**
 * @Author: yin-k
 * @Description: Java实现整型数组
 * @Date: Created in 16:14 2022/11/6
 */
public class Array {
    private int[] data; // 定义一个基础数组，用来存放数据
    private int size;  // 用于记录数组中数据的个数

    /**
     * 有参构造函数
     * @param capacity 初始化容量
     */
    public Array(int capacity){
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参构造函数，默认初始容量为16
     */
    public Array(){
        this(16);
    }

    /**
     * 获取数组中元素个数
     * @return 元素个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     * @return 数组容量
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return 数组是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }
// ---------------元素添加操作-----------------------
    /**
     * 向数组中添加元素
     * @param index 数组索引下标
     * @param e 元素
     */
    public void add(int index, int e){
        if(size == data.length){
            throw new IllegalArgumentException("Array is full.");
        }
        //这个方法默认index在已有元素内部
        if(index<0 || index>data.length || index >size){
            throw new IllegalArgumentException("Wrong index.");
        }
        for(int i = size-1; i>=index; i--)
            data[i+1] = data[i];
        data[index] = e;
        size++;
    }

    /**
     * 头插
     * @param e 元素
     */
    public void addFirst(int e){
        add(0, e);
    }

    /**
     * 尾插
     * @param e 元素
     */
    public void addTail(int e){
        add(size, e);
    }
//------------------查询操作------------------------

    /**
     * 获取元素
     * @param index 数组索引
     * @return 对应下标元素
     */
    public int get(int index){
        if(index<0||index>=size)
            throw new IllegalArgumentException("Wrong index.");
        return data[index];
    }

    public boolean isExists(int e){
        for (int i = 0; i < size ; i++) {
            if(data[i]==e)
                return true;
        }
        return false;
    }

    public int findIndex(int e){
        for (int i = 0; i < size; i++) {
            if (data[i]==e)
                return i;
        }
        return -1;
    }

    public int remove(int index){
        if (index<0 || index>=size)
            throw new IllegalArgumentException("Wrong index.");
        int ret = data[index];
        for(int i = index+1; i<size; i++)
            data[i-1] =data[i];
        size--;
        return ret;
    }

    public int removeFirst(){
       return remove(0);
    }

    public int removeTail(){
        return remove(size-1);
    }

    public void removeElement(int e){
        int index = findIndex(e);
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array:size = %d, capacity= %d\n",size,data.length))
        .append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i!=size-1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }

}






