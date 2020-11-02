package operation;

import book.BookList;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 09:39
 **/
public class ExitOperation implements IOperation {
    public void work(BookList bookList){
        System.out.println("退出系统");
        System.exit(0);
    }
}
