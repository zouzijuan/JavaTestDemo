import java.util.Arrays;
import java.util.Scanner;

/**
 * Program:20201015
 * description:
 * author:ZOU zijuan
 * create:2020-10-15 10:08
 **/
public class TestDemo {
    /*
    将当前数组转换为字符串输出。
     */
    public static String myToString(int[] array) {
        if (array == null) {
            return " ";
        }
        if (array.length == 0) {
            return "[]";
        }
        String ret = "[ ";
        for (int i = 0; i < array.length; i++) {
            ret = ret + array[i];
            if (i != array.length - 1) {
                ret = ret + ",";
            }
        }
        ret = ret + " ]";
        return ret;
    }
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {};
        System.out.println(myToString(array1));
        System.out.println(myToString(array2));
        System.out.println(myToString(null));

    }

    /*
    实现一个方法 avg, 以数组为参数, 求数组中所有元素的平均值(注意方法的返回值类型).
     */
    public static double avg(int[] array) {
        double sum = 0;
        double avg = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];

        }
        return avg = sum / array.length;

    }

    public static void main2(String[] args) {
        int[] array=new int[100];
        arrayInitial(array);
        String str= Arrays.toString(array);
        System.out.println(str);
    }

    /*
    实现一个方法 sum, 以数组为参数, 求数组所有元素之和
     */
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
        /*
        实现一个方法 transform, 以数组为参数,
        循环将数组中的每个元素 乘以 2 , 并设置到对应的数组元素上.
        例如 原数组为 {1, 2, 3}, 修改之后为 {2, 4, 6}
         */
    public static void transform(int[] array) {
         int sum = 0;
         for (int i = 0; i < array.length; i++) {
             array[i]=array[i]*2;
         }
        System.out.println(myToString(array));
        }

        /*
        实现一个方法 printArray, 以数组为参数, 循环访问数组中的每个元素, 打印每个元素的值.
         */
    public static void printArray(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");

        }

    }
    /*
    创建一个 int 类型的数组, 元素个数为 100, 并把每个元素依次设置为 1 - 100
    */
    public static void arrayInitial(int[] array){
        for (int i = 0; i <array.length ; i++) {
            array[i]=i+1;
        }
    }

}