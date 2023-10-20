package dataStructure.array.dynamicGenericsArray;

/**
 * @Author: yin-k
 * @Description: 动态泛型数组
 * @Date: Created in 18:43 2022/11/6
 */
public class ArrayList<E> {
    private E[] data;
    private int size;
    // 系统扩容系数，当数组的元素个数大于等于数组容量*系数时，进行扩容
    private final double resizeRatio = 0.75;

    public ArrayList(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public ArrayList(){
        this(8);
    }

    /**
     * 扩容方法
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void add(int index, E e){
        if (index>size || index<0)
            throw new IllegalArgumentException("Wrong index.");
        if (size == (int)(data.length*resizeRatio))
            resize(2*data.length);
        for(int i=size-1; i>=index; i--){
            data[i+1] = data[i];
        }
        data[index] =e;
        size++;
    }
    public void addFirst(E e){
        add(0,e);
    }

    /**
     * 尾插
     * @param e 元素
     */
    public void add(E e){
        add(size,e);
    }

    public E get(int index){
        if(index<0 || index> size)
            throw new IllegalArgumentException("Wrong index.");
        return data[index];
    }

    public void set(int index,E e){
        if(index<0 || index> size)
            throw new IllegalArgumentException("Wrong index.");
        data[index] = e;
    }

    public boolean isExists(E e){
        for (int i = 0; i < size; i++) {
            if(data[i] == e)
                return true;
        }
        return false;
    }

    public int findIndex(E e){
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index){
        if(index<0 || index >= size)
            throw new IllegalArgumentException("Removed failed.");
        E r = data[index];
        for(int i = index-1; i<size; i++){
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;
        if(size <= data.length/resizeRatio/2 )
            resize(data.length/2);
        return r;
    }
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除数组末尾的元素
     * @return 末尾元素
     */
    public E remove(){
        return remove(size-1);
    }

    public void removeElement(E e){
        int index = findIndex(e);
        if(index != -1)
            remove(index);
    }

    @Override
    public String toString(){
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(String.format("ArrayList: size=%d,capacity=%d \n",size,data.length))
                .append("[");
        for (int i=0;i<size;i++){
            stringBuffer.append(data[i]);
            if(i!=size-1)
                stringBuffer.append(",");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

}
