/**
 * Program:20201014
 * description:
 * author:ZOU zijuan
 * create:2020-10-14 22:07
 **/
public class TestDemo {

    public static void main8(String[] args) {
        System.out.println(nFactor(5));
    }

    public static int nFactor(int n) {
        if(n==1){
            return 1;
        }
        return n*nFactor(n-1);

    }

    public static void main7(String[] args) {
        System.out.println(add(10,20));
        System.out.println(add(12.5,13.5,14.5));
    }

    public static int add(int a,int b){
        return a+b;
    }
    public static double add(double a,double b,double c){
        return a+b+c;
    }

    public static void main6(String[] args) {
        System.out.println(maxTwo(20,30));
        System.out.println(maxTwo(12.5,13.5));
        System.out.println(maxTwo(12.8,15.6,19));
    }

    public static int maxTwo(int a,int b) {
        int max=0;
        if(a>b){
            return a;
        } else {
            return b;
        }
    }

    public static double maxTwo(double a,double b) {
        double max=0;
        if(a>b){
            return a;
        } else {
            return b;
        }
    }

    public static double maxTwo(double a,double b,int c) {
        double max=0;
        if(maxTwo(a,b)>c){
            return maxTwo(a,b);
        } else {
            return c;
        }
    }

    public static void main5(String[] args) {
        print(1314);
    }
    public static void print(int n) {
        if (n/10!=0){
            print(n/10);
        }
        System.out.print((n%10)+"  ");
    }

    //求解汉诺塔问题
    public static void main4(String[] args) {
        hanoiTower(1,'A','B','C');
        System.out.println();
        hanoiTower(2,'A','B','C');
        System.out.println();
        hanoiTower(3,'A','B','C');
        System.out.println();
    }
    public static void move(char pos1,char pos2) {
        System.out.print(pos1+"->"+pos2+" ");

    }

    public static void hanoiTower(int n,char pos1,char pos2,char pos3) {
        if(n==1){
            move(pos1,pos3);
            return;
        }
        hanoiTower(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanoiTower(n-1,pos2,pos1,pos3);


    }

    public static void main(String[] args) {
        System.out.println(fibOr(5));
    }

    public static int  fibOr(int n) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return fibOr(n-1)+fibOr(n-2);

    }

    public static void main2(String[] args) {
        System.out.println(sum(10));
    }
    public static int sum(int n) {
        if(n==1){
            return 1;
        }
      return   n+sum(n-1);

    }

    public static void main1(String[] args) {
        System.out.println(sumAdd(123));
    }

    public static int sumAdd(int n) {
        if(n<10){
          return n;

        }
        return sumAdd(n/10)+n%10;


    }
}

