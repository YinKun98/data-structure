package dynamicGenericsArray;

/**
 * @Author: yin-k
 * @Description: 动态泛型数组测试类
 * @Date: Created in 19:21 2022/11/6
 */
public class ArrayTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            arrayList.add(i);
        }

        System.out.println(arrayList.toString());
        for (int i = 0; i < 6; i++) {
            arrayList.add(i*i);
        }
        System.out.println(arrayList.toString());
    }
}
