import java.util.Arrays;

/**
 * Program:20201017
 * description:
 * author:ZOU zijuan
 * create:2020-10-17 20:15
 **/

/* 编写一个Calculator，有两个属性num1,num2,这两个数据的值，
    不能在定义的同时初始化，最后实现加减乘除四种运算 */
class Calculator{
    private int num1;
    private int num2;

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int add(){
        return this.num1+this.num2;
    }

    public int sub(){
        return  this.num1-this.num2;
    }

    public double dev(){
        return this.num1*1.0/this.num2;
    }

}

//实现交换两个变量的值。要求：交换实参的值
class MyValue{
    public int val;
}


public class TestDemo {
    public static void swap(MyValue myValue1,MyValue myValue2){
        int tmp=myValue1.val;
        myValue1.val=myValue2.val;
        myValue2.val=tmp;

    }

    public static void main(String[] args) {
        MyValue myValue1=new MyValue();
        MyValue myValue2=new MyValue();

        myValue1.val=10;
        myValue2.val=20;
        System.out.println(myValue1.val+"  "+myValue2.val);

        swap(myValue1,myValue2);
        System.out.println(myValue1.val+"  "+myValue2.val);
    }

    public static void main3(String[] args) {
        Calculator calculator = new Calculator();
        calculator.setNum1(6);
        calculator.setNum2(3);
        System.out.println(calculator.add());
        System.out.println(calculator.sub());
        System.out.println(calculator.dev());
    }









    public static void main1(String[] args) {
        int[] array={1,2,3,4,5,6,7,8};
        paritySeparation(array);
        System.out.println(Arrays.toString(array));

    }
    public static void paritySeparation(int[] arr){
        int left=0;
        int right=arr.length-1;
        while(left<right){
            while(left<right&&arr[left]%2==0){
                left++;
            }
            while(left<right&&arr[right]%2!=0){
                right--;
            }
            if(left<right){
                int tmp=arr[left];
                arr[left]=arr[right];
                arr[right]=tmp;
            }
        }
    }

    public static void main2(String[] args) {
        int[] array1={1,2,3};
        int[] array2={2,3,4};
        exchangeArray(array1,array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }
    public static void exchangeArray(int[] array1,int[] array2){
        for (int i = 0; i <array1.length ; i++) {
            int tmp=array1[i];
            array1[i]=array2[i];
            array2[i]=tmp;

        }
    }
}