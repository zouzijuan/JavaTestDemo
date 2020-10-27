import java.util.Scanner;

/**
 * Program:20201013
 * description:
 * author:ZOU zijuan
 * create:2020-10-15 16:40
 **/
public class TestDemo {
    

    public static void main6(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(fib(n));
    }

    public static int fib(int n) {
        int f1=1;
        int f2=1;
        int f3=1;
        for(int i=3;i<=n;i++){
            f3=f1+f2;
            f1=f2;
            f2=f3;
        }
        return f3;
    }

    //有一组数据，只有一个数字是出现一次，其他是两次，请找出这个数字。
    //方法一
    public static void main5(String[] args) {
        int[] array={1,2,5,1,2};

        for (int i = 0; i < 4; i++) {
            int count=0;

            for (int j = 0; j <=4 ; j++) {
                if(array[i]==array[j]){
                    count++;
                }
               }

            if(count==1){
                System.out.println(array[i]);
                break;
            }
        }
    }

    //方法二
    public static void main4(String[] args) {
        int[] array={1,2,5,1,2};
        int ret=0;
        for (int i = 0; i <= 4; i++) {
            ret=ret^array[i];
        }
        System.out.println(ret);

    }


    //调用方法求3个数中的最大值
    public static void main3(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        int c=scanner.nextInt();

        System.out.println(max3(a,b,c));
    }

    public static int max3(int a,int b,int c) {
        int max=0;
        if(max2(a,b)>c){
            max=max2(a,b);
        } else {
            max=c;
        }
        return max;

    }

    public static int max2(int a,int b) {
        int max=0;
        if(a>b){
            max=a;
        } else {
            max=b;
        }
        return max;

    }

    //求1!+2!+3!+4!+……+n!的和
    public static void main2(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int sum=0;
        int i=1;
        for(;i<=n;i++){
            sum+=oneFactorial(i);
        }
        System.out.println(sum);
    }

    //求N的阶乘
    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        System.out.println(n+"的阶乘是"+oneFactorial(n));
    }

    public static int oneFactorial(int n) {
        int fac=1;
        int i=1;
        for( ;i<=n;i++){
            fac*=i;
        }
        return fac;
    }
}
