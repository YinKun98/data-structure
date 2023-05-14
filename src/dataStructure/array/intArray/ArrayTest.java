package array.intArray;

/**
 * @Author: yin-k
 * @Description: 整型数组测试类
 * @Date: Created in 17:02 2022/11/6
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array array = new Array(16);
        for (int i = 0; i <8 ; i++) {
            array.addTail(i*i);
        }
        System.out.println(array.toString());

        int remove = array.remove(5);
        System.out.println(remove);
        System.out.println(array.toString());

        array.removeElement(121);
        System.out.println(array.toString());

        System.out.println(array.isExists(121));


    }

}
