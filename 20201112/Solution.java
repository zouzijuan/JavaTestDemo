import java.lang.reflect.Array;
import java.util.*;
/**
 * program:20201112
 * description:
 * author:Zou zijuan
 * create:2020-11-13-16:42
 **/
class VersionComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}

class Car {
    int position;
    double time;
    Car(int p, double t) {
        position = p;
        time = t;
    }

}
public class Solution{

    //颜色分类
    public void sortColors(int[] nums) {
        for (int i = 1; i <nums.length ; i++) {
            int tmp=nums[i];
            int j =i-1;
            for (; j>=0; j--){
                if(nums[j]>tmp){
                   nums[j+1]=nums[j];
                } else {
                    break;
                }
            }
           nums[j+1]=tmp;
        }
    }

    //车队
    public int carFleet(int target, int[] position, int[] speed) {
        int len=position.length;
        Car[] cars=new Car[len];
        for (int i = 0; i <len; i++) {
            cars[i]=new Car(position[i],(target-position[i])*1.0/speed[i]);
        }
        for (int i = 1; i <len ; i++) {
            Car tmp=cars[i];
            int j =i-1;
            for (; j>=0; j--){
                if(cars[j].position<tmp.position){
                    cars[j+1]=cars[j];
                } else {
                    break;
                }
            }
            cars[j+1]=tmp;
        }
        Stack<Double> stack=new Stack<>();
        for(int i=0;i<len;i++){
            if(stack.empty()||stack.peek()<cars[i].time){
                stack.push(cars[i].time);
            }
        }
        return stack.size();
    }

    //比较版本号
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        VersionComparator comparator = new VersionComparator();
        int flag = 0;
        int i = 0;
        int j = 0;
        while (i < str1.length && j < str2.length) {
            int tmp1=Integer.valueOf(str1[i]);
            int tmp2=Integer.valueOf(str2[i]);
            int result=comparator.compare(tmp1,tmp2);
            if(result==0){
                flag=0;
            } else if(result<0){
                return -1;
            } else {
                return 1;
            }
            i++;
            j++;
        }

        if(str1.length<str2.length){
            for(i=str1.length;i<str2.length;i++){
                if(Integer.valueOf(str2[i])>0){
                    return -1;
                }
            }
        } else if(str1.length>str2.length){
            for(j=str2.length;j<str1.length;j++){
                if(Integer.valueOf(str1[j])>0){
                    return 1;
                }
            }
        }
        return 0;
    }
}