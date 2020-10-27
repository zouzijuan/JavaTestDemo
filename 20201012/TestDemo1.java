import java.util.Scanner;
import java.util.Random;

public class TestDemo1{

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);

		int n=scan.nextInt();
		int count=0;
		while(n!=0){
			count++;
			System.out.println(n%10);
			n/=10;
		}
		
	}



	public static void main13(String[] args) {
		Scanner scan=new Scanner(System.in);

		int count=3;
		while(count!=0){

			System.out.println("请输入密码：");
			String password=scan.nextLine();

			if(password.equals("123456")){
				System.out.println("登陆成功");
				break;
			} else {
				count--;
				System.out.println("登陆失败");
				System.out.println("你还有"+count+"次机会");
			}

		}
	}
	public static void main12(String[] args) {
		Scanner scan=new Scanner(System.in);

		int n=scan.nextInt();
		System.out.print("偶数位：");
		for(int i=31;i>=1;i-=2){
			System.out.print(((n>>i)&1)+" ");
		}

		System.out.print("奇数位：");

		for(int i=30;i>=0;i-=2){
			System.out.print(((n>>i)&1)+" ");
		}



	}

	public static void main11(String[] args) {

		Scanner scan=new Scanner(System.in);

		int n=scan.nextInt();
		int count=0;
		while(n!=0){
			count++;
			n=n&(n-1);
		}
		System.out.println(count);
		
	}

	public static void main10(String[] args) {

		Scanner scan=new Scanner(System.in);

		int n=scan.nextInt();

		int count=0;
		int tmp=n;
		while(tmp!=0){
			count++;
			tmp/=10;
		}
		tmp=n;
		int sum=0;
		while(tmp!=0){
			sum+=Math.pow(tmp%10,count);
			tmp/=10;
		}
		if(sum==n){
			System.out.println(n+"是自幂数");
		}

		
	}
	public static void main9(String[] args) {

		Random random=new Random();
        Scanner scan=new Scanner(System.in);

		int rand=random.nextInt(100)+1;
		while(true){

			int n=scan.nextInt();

			if(n<rand){
				System.out.println("猜小了");
			} else if (n==rand){
				System.out.println("猜对了");
				break;
			} else{
				System.out.println("猜大了");
			}
		}
	}
	public static void main8(String[] args) {
		int flg=1;
		double sum=0;
		int i=1;
		for(i=1;i<=100;i++){
			sum+=(1.0/i)*flg;
			flg=-flg;

		}
		System.out.println(sum);
	}

	public static void main7(String[] args) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();

		while(a%b!=0){
			int c=a%b;
			a=b;
			b=c;
		}
		System.out.println("最大公约数是"+b);


	}

	

	public static void main6(String[] args) {
        int a=0;
		int i=1;
		int j=1;
		for(i=1;i<=9;i++){
			for(j=1;j<=i;j++){
				a=i*j;
				System.out.print(j+"*"+i+"="+a+" ");

			}
			System.out.println();

		}
		
	}

	public static void main5(String[] args) {

		//从键盘获取数据
		Scanner scan=new Scanner (System.in);

		while(scan.hasNextInt()){
	        //读入一个整型
	        int age=scan.nextInt();
	        if(age<18){
	        	System.out.println("少年");
	        } else if(age>=18&&age<28){
	        	System.out.println("青年");
	        } else if(age>=28&&age<55){
	        	System.out.println("中年");
	        } else {
	        	System.out.println("老年");
	        }
	    }




		
	}

	public static void main4(String[] args) {


		Scanner scan =new Scanner (System.in);

        while(scan.hasNextInt()){
				 //读入一个整型
		         int num=scan.nextInt();

				int i=2;
				for(i=2;i<num;i++){
					if(num%i==0){
						System.out.println(num+"不是素数");
						break;
					}
				}
				if (i==num){
					System.out.println(num+"是素数");
				}
		}
	}

	public static void main3(String[] args) {
		int num=1;
		int i=2;
		for(num=1;num<=100;num++){

			for(i=2;i<num;i++){
				if(num%i==0){
					break;
				}
			}
			if(i==num){
			  System.out.println(num);

		    }

	    }

	}

    public static void main2(String[] args) {
    	int i=1000;
    	while(i<=2000){
    		if(i%4==0&&i%100!=0||i%400==0){
    			System.out.println(i);
    		}
    		i++;
    	}
    }

	public static void main1(String[] args) {
		int i=1;
		int num=0;
		for(i=1;i<=100;i++){

			//个位出现9的个数
			if(i%10==9){
				num++;
			}

			//十位出现9的个数
			if (i/10==9){
				num++;
			}
	    }
	    System.out.println(num);
	}
}