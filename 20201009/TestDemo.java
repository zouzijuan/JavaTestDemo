/**
 * 文档注释
 */

/*
块注释
 */

//行注释

class Test{
	
}
public class TestDemo{

	public static void main8(String[] args) {
		boolean flg=true;
		System.out.println(flg);
	}

	public static void main7(String[] args) {
		short sh=18;
		System.out.println(sh);

		System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);

	}

	public static void main6(String[] args) {
		byte b=10;
		System.out.println(b);

		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
	}
	public static void main5(String[] args) {
		/**
		 * 2个字节
		 * 16 bit
		 */
		char ch='邹';
		System.out.println(ch);
	}
	public static void main(String[] args) {
		float f=12.5f;
		System.out.println(f);

		double d=12.8;
		System.out.println(d);
	}
	public static void main3(String[] args) {
		long a=10L;
		System.out.println(a);

		System.out.println(Long.MAX_VALUE);
		System.out.println(Long.MIN_VALUE);
    }

	public static void main2(String[] args) {
		int a=10;
		System.out.println(a);
		System.out.println("int最大值:"+Integer.MAX_VALUE);
		System.out.println("int最小值:"+Integer.MIN_VALUE);
		int b=Integer.MAX_VALUE+1;
		System.out.println("int最大值+1:"+b);
		int c=Integer.MIN_VALUE-1;
		System.out.println("int最小值-1:"+c);
	}

	public static void main1(String[] args) {

		for (int i=0;i<args.length ;i++ ) {
			System.out.println(args[i]);
			
		}
		System.out.println("========");
		System.out.println("hello");
	}
}

