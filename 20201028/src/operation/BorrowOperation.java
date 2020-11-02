package operation;

import book.Book;
import book.BookList;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 09:39
 **/
public class BorrowOperation implements IOperation {
    public void work(BookList bookList){
        System.out.println("借阅图书");
        System.out.println("请输入借阅图书的书名:");

        String name=this.scanner.next();
        int currentSize=bookList.getUsedSize();
        int i = 0;
        for (; i <currentSize ; i++) {
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setBorrowed(true);
                break;
            }
        }
        if(i==currentSize){
            System.out.println("没有此书");
            return;
        }
        System.out.println("借阅成功");
    }
}
