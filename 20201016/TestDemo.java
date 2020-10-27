import java.util.Arrays;

/**
 * Program:20201016
 * description:
 * author:ZOU zijuan
 * create:2020-10-16 09:47
 **/
public class TestDemo {
    //二分查找
    public static int binarySearch(int[] array,int toFind){
        int left=0;
        int right=array.length-1;
        while(left<=right) {
            int mid = (left + right) / 2;
            if (array[mid] > toFind) {
                right = mid - 1;
            } else if (array[mid] < toFind) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
      return -1;
    }

    public static void main1(String[] args) {
        int[] array={1,2,3,4,5};
        System.out.println(binarySearch(array, 5));
    }


    //冒泡排序
    public static void bubbleSort(int [] array){
        int count=0;
        for (int i = 0; i <array.length ; i++) {
            count++;
            boolean flg=false;
            for (int j = 0; j <array.length-1-i ; j++) {
                flg=false;//每一趟都有可能没有交换
                if (array[j]>array[j+1]){
                    int tmp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=tmp;
                    flg=true;
                }
            }
            if(flg==false) {
                break;
            }
        }
        System.out.println(count);
    }

    public static void main3(String[] args) {
        int[] array={1,9,7,11,10};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }


    //数组逆序
    public static void reverse(int[] array){
        int left=0;
        int right=array.length-1;
        while(left<right){
            int tmp=array[left];
            array[left]=array[right];
            array[right]=tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8};
        reverse(array);
        System.out.println(Arrays.toString(array));

    }

    //判断数组是否有序
    public static boolean isSorted(int[] array){
        for (int i = 0; i <array.length-1 ; i++) {
            if (array[i]>array[i+1]){
                return false;
            }

        }
        return true;
    }

    public static void main4(String[] args) {
        int[] array={1,9,7,11,10};
        System.out.println(isSorted(array));
    }

    //对一个整型数组进行拷贝, 得到一个新的数组.
    public static int[] copyOf(int[] array){
        int [] copy=new int[array.length];
        for (int i = 0; i <array.length ; i++) {
            copy[i]=array[i];

        }
        return copy;
    }

    public static void main5(String[] args) {
        int[] array={1,3,5,7,9};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(copyOf(array)));
    }

}
