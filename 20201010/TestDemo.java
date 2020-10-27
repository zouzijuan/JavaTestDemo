public class TestDemo{

	public static void main(String[] args) {
		System.out.println(10%3);//1
		System.out.println(-10%3);//-1
		System.out.println(10%-3);//1
		System.out.println(-10%-3);//-1
	}

	public static void main8(String[] args) {
		System.out.println(5/2);//2
		System.out.println(5.0/2);//2.5
		System.out.println((float)5/2);//2.5
		System.out.println(5/(float)2);//2.5
		System.out.println((float)(5/2));//2.0
	}

	public static void main7(String[] args) {
		int num=10;
		String str=10+" ";
		System.out.println(str);

		String str2=String.valueOf(num);
		System.out.println(str2);

	}

	public static void main6(String[] args) {
		int a=10;
		double b=1.0;
		a=(int)b;//会有精度的损失
		System.out.println(a);
	}

	public static void main5(String[] args) {
		int a=10;
		long b=a;
		int c=(int)b;//强制类型转换
		System.out.println(a+","+b+","+c);
	}

	public static void main4(String[] args) {
		final int A=10;
		System.out.println(A);
	}

	public static void main3(String[] args) {
		System.out.println("zou"+"zijuan");

		int a=10;
		int b=20;
		System.out.println("a ="+a);
		System.out.println(a+b);
		System.out.println("a ="+a+",b ="+b);
	}

	public static void main2(String[] args) {
		System.out.println("\"abcd\"");
		System.out.println("D:\\java\\20201010");
	}

	public static void main1(String[] args) {
		String str="hello";
		System.out.println(str);

		System.out.println("打印并且换行");
		System.out.printf("%s\n","格式化打印");
		System.out.printf("打印但是不换行");
		System.out.printf("%d\n",10);
	}
}