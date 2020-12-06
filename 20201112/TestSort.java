import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * program:20201112
 * description:
 * author:Zou zijuan
 * create:2020-11-12 11:15
 **/
public class TestSort {
    /**
     * 稳定性：稳定
     * 时间复杂度：
     *          最好情况下：O(n)      数组的数据是有序的
     *          最坏情况下：O(n^2)    数组的数据是无序的
     * 空间负责度：O(1)
     * 特点：越有序越快
     * @param array
     */
    public static void insertSort(int[] array){
       for (int i = 1; i <array.length ; i++) {
           int tmp=array[i];
           int j =i-1;
           for (; j>=0; j--){
              if(array[j]>tmp){
                    array[j+1]=array[j];
              } else {
                  break;
              }
           }
           array[j+1]=tmp;
        }
    }

    /**
     * 稳定性：不稳定的排序
     * 时间复杂度：O(n^1.3)~O(n^1.5)
     * 空间复杂度：O(1)
     * @param array
     * @param gap
     */
    public static void shell(int[] array,int gap){
        for (int i = gap; i <array.length ; i++) {
            int tmp=array[i];
            int j = i-gap;
            for (; j>=0 ; j-=gap){
                if(array[j]>tmp){
                    array[j+gap]=array[j];
                } else {
                    break;
                }
            }
            array[j+gap]=tmp;
        }
    }
    public static void shellSort(int[] array){
        int[] drr={5,3,1};
        for (int i = 0; i <drr.length ; i++) {
            shell(array,drr[i]);

        }
    }

    /**
     * 稳定性：不稳定
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * @param array
     */
    public static void selectSort(int[] array){
        for (int i = 0; i <array.length ; i++) {
            for (int j =i+1; j <array.length ; j++) {
                if(array[i]>array[j]){
                    int tmp=array[i];
                    array[i]=array[j];
                    array[j]=tmp;
                }
            }
        }
    }

    public static void adjustDown(int[] array,int parent,int len) {
        int child = 2*parent+1;
        while (child < len) {

            if(child+1 < len && array[child] < array[child+1]) {
                child++;
            }

            if(array[child] > array[parent]) {
                int tmp = array[child];
                array[child] = array[parent];
                array[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else {
                break;
            }
        }
    }

    public static void createHeap(int[] array) {
        for (int i = (array.length-1-1)/2; i >= 0 ; i--) {
            adjustDown(array,i,array.length);
        }
    }

    /**
     * 时间复杂度：O(n*logn)
     * 空间复杂度：O(1)
     * 稳定性：不稳定的排序
     * @param array
     */
    public static void heapSort(int[] array) {
        long start = System.currentTimeMillis();
        createHeap(array);
        int end = array.length - 1;
        while (end > 0) {
            int tmp = array[0];
            array[0] = array[end];
            array[end] = tmp;
            adjustDown(array, 0, end);
            end--;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - start);
    }


    //划分函数
    public static int partion(int[] array,int start,int end) {
        int tmp = array[start];
        while (start < end) {
            while (start < end && array[end] >= tmp) {
                end--;
            }
            if(start >= end) {
                //array[start] = tmp;
                break;
            }else {
                array[start] = array[end];
            }

            while (start < end && array[start] <= tmp) {
                start++;
            }
            if(start >= end) {
                //array[start] = tmp;
                break;
            }else {
                array[end] = array[start];
            }

        }
        array[start] = tmp;
        return start;
    }


    public static void insertSort2(int[] array,int low,int high) {
        for (int i = low+1; i <= high; i++) {
            int tmp = array[i];
            int j = i-1;
            for (; j >= low ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    //array[j+1] = tmp;
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }
    /**
     * 时间复杂度：O(n*logn)
     *          最坏：有序   逆序的  顺序   O(n^2)
     *          9  8  7  6 5
     * 空间复杂度：O(logn)
     * 稳定性：不稳定的排序
     * @param array
     * @param low
     * @param high
     */
    public static void quick(int[] array,int low,int high) {
        if(low >= high) {
            return;
        }

        //1、优化   当 low  high  之间的数据个数  小于 某个值的时候   采用直接插入排序
        if(high-low+1 <= 100) {
            insertSort2(array,low,high);
            return;
        }
        //2、优化方式   三数取中
        medianOfThree(array,low,high);

        int par = partion(array,low,high);

        quick(array,low,par-1);
        quick(array,par+1,high);
    }
    public static void swap(int[] array,int low,int high) {
        int tmp = array[low];
        array[low] = array[high];
        array[high] = tmp;
    }
    public static void medianOfThree(int[] array,int low,int high) {
        int mid = (low+high)/2;
        //array[mid] < array[low] < array[high]
        if(array[low] >= array[high]) {
            swap(array,low,high);
        }
        if(array[low] <= array[mid]) {
            swap(array,low,mid);
        }
        if(array[mid] >= array[high]) {
            swap(array,low,mid);
        }
    }

    public static void quickSort(int[] array) {
        quick(array,0,array.length-1);
        //quickNor(array,0,array.length-1);
    }

    /**
     * 非递归实现快排
     * @param array
     * @param low
     * @param high
     */
    public static void quickNor(int[] array,int low,int high) {
        Stack<Integer> stack = new Stack<>();
        int par = partion(array,low,high);

        if(par > low+1) {
            stack.push(low);
            stack.push(par-1);
        }

        if(par < high-1) {
            stack.push(par+1);
            stack.push(high);
        }

        while (!stack.empty()) {
            int end = stack.pop();
            int start = stack.pop();
            par = partion(array,start,end);
            if(par > start+1) {
                stack.push(start);
                stack.push(par-1);
            }

            if(par < end-1) {
                stack.push(par+1);
                stack.push(end);
            }
        }
    }

    public static void merge(int[] array,
                             int low,int high,int mid) {
        int s1 = low;
        int s2 = mid+1;
        int[] tmpArr = new int[high-low+1];
        int k = 0;//就是tmpArr的下标

        //代表2个段都有数据
        while (s1 <= mid && s2 <= high) {
            if(array[s1] <= array[s2]) {
                tmpArr[k] = array[s1];
                k++;
                s1++;
            }else {
                tmpArr[k] = array[s2];
                k++;
                s2++;
            }
        }
        //第一个归并段 还有 若干数据
        while (s1 <= mid) {
            tmpArr[k++] = array[s1++];
        }
        while (s2 <= high) {
            tmpArr[k++] = array[s2++];
        }
        //也就是说 tmpArr 当中存放的 就是这次归并的有序之后 的 结果
        for (int i = 0; i < tmpArr.length; i++) {
            array[low+i] = tmpArr[i];
        }
    }

    /**
     * 时间复杂度：nlogn
     * 空间复杂度：O(n)
     * 稳定性：稳定的排序
     * @param array
     * @param low
     * @param high
     */
    public static void mergeSortInternal(int[] array,
                                         int low,int high) {
        if(low >= high) {
            return;
        }
        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid+1,high);
        //开始合并
        merge(array,low,high,mid);
    }

    public static void mergeSort(int[] array) {
        mergeSortInternal(array,0,array.length-1);
    }


    /**
     * 非递归的归并排序
     * @param array
     * @param gap
     */
    public static void mergeNor(int[] array,int gap) {
        int len = array.length;
        int s1 = 0;
        int e1 = s1+gap-1;
        int s2 = e1+1;
        int e2 = s2+gap-1 < len ? s2+gap-1 : len-1 ;
        int[] tmpArr = new int[len];
        int k = 0;
        //先判断是否有2个归并段
        while (s2 < len) {
            while(s1 <= e1 && s2 <= e2) {
                if(array[s1] <= array[s2]) {
                    tmpArr[k++] = array[s1++];
                }else {
                    tmpArr[k++] = array[s2++];
                }
            }
            while(s1 <= e1) {
                tmpArr[k++] = array[s1++];
            }
            while(s2 <= e2) {
                tmpArr[k++] = array[s2++];
            }
            //一组已经比较完了
            s1 = e2+1;
            e1 = s1+gap-1;
            s2 = e1+1;
            e2 = s2+gap-1 < len ? s2+gap-1 : len-1 ;
        }
        //不够两个归并段的时候
        while (s1 <= len-1) {
            tmpArr[k] = array[s1];
            k++;
            s1++;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = tmpArr[i];
        }
    }

    public static void mergeSortNor(int[] array) {
        for (int i = 1; i < array.length; i *= 2) {
            mergeNor(array,i);
        }
    }


    public static void main(String[] args) {
        int[] array={11,33,4,6,8,0,3,15,11};
        quickSort(array);
        System.out.println(Arrays.toString(array));

    }
}
