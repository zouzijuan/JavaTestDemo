package operation;

import book.Book;
import book.BookList;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 09:38
 **/
public class FindOperation implements IOperation {
    public void work(BookList bookList){
        System.out.println("查找图书");

        String name=this.scanner.next();
        int currentSize=bookList.getUsedSize();
        int i = 0;
        for (; i <currentSize ; i++) {
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                System.out.println(book);
                break;
            }
        }
        if(i==currentSize){
            System.out.println("没有此书");
        }
    }
}
