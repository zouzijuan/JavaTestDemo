/**
 * Program:20201023
 * description:
 * author:ZOU zijuan
 * create:2020-10-23 23:08
 **/
public class TestDemo {
    public static void main(String[] args) {
        DoubleList doubleList=new DoubleList();
        doubleList.addLast(3);
        doubleList.addLast(2);
        doubleList.addLast(3);
        doubleList.addLast(3);
        doubleList.addLast(3);
        doubleList.display();

        doubleList.removeAllKey(3);
        doubleList.display();

    }
}
