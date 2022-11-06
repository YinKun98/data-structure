package genericsArray;

/**
 * @Author: yin-k
 * @Description: 泛型数组测试类
 * @Date: Created in 18:40 2022/11/6
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array<String> stringArray = new Array<String>(8);
        for (int i = 0; i < 4; i++) {
            stringArray.add(i,"String->"+i);
        }
    }
}
