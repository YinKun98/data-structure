package genericsArray;

/**
 * @Author: yin-k
 * @Description: 泛型数组,将数组中的类型进行了扩展
 * @Date: Created in 18:32 2022/11/6
 */
public class Array<E>{
    private E[] data;
    private int size;

    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }
    public void add(int index, E e){
        if(size == data.length)
            throw new IllegalArgumentException("Array is full.");
        if(index<0||index>size||index>data.length)
            throw new IllegalArgumentException("Wrong index.");
        for (int i = size-1; i >=index ; i--) {
            data[i+1] = data[i];
        }
        size++;
        data[index] = e;
    }
}
