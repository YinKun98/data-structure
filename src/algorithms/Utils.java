package algorithms;

import java.util.Random;

/**
 * @Author: yin-k
 * @Description:
 * @Date: Created in 20:59 2023/5/8
 */
public class Utils {
    /**
     * 生成指定长度和范围的整型数组
     * @param length 数组长度
     * @param range 元素范围
     * @return 整型数组
     */
    public static int[] genRandomArray(int length,int range){
        Random random = new Random();
        int[] ints = new int[length];
        for (int i = 0; i < length; i++){
            ints [i] = random.nextInt(range);
        }
        return ints;
    }
}
