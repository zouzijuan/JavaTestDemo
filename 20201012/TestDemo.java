import java.util.Scanner;

public class TestDemo{

	public static void main(String[] args) {
		int i=1;
		while(i<=100){
			if(i%3==0&&i%5==0){
				System.out.println(i);
			}
			i++;
		}
	}

	public static void main5(String[] args) {
		int i=1;
		int sum=0;
		while(i<=5){
			int fac=1;
			int tmp=1;
			while(tmp<=i){
				fac=fac*tmp;
				tmp++;
             }
             System.out.println(i+"!="+fac);


             i++;
             sum=sum+fac;
         }
        System.out.println("1!+2!+3!+4!+5!="+sum);
	}

	public static void main4(String[] args) {
		int i=1;
		int fac=1;
		while(i<=5){
			fac=fac*i;
			i++;
		}
		System.out.println(fac);
	}

	public static void main3(String[] args) {

		//从键盘获取数据
        Scanner scan =new Scanner (System.in);
        
        while(scan.hasNextInt()){


        //读入一个整型
        int num=scan.nextInt();


			if(num%2==0){
				System.out.println("偶数");
			} else {
				System.out.println("奇数");
			}
		}

	}

	public static void main2(String[] args) {
		int a=1;
		if(a==1){
			System.out.println("hello!");
		} else {
			System.out.println("else");
		}
		
	}
    
	public static void main1(String[] args) {
		//顺序结构
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");
	}
}