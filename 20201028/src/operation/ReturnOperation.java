package operation;

import book.Book;
import book.BookList;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 09:39
 **/
public class ReturnOperation implements IOperation {
    public void work(BookList bookList){
        System.out.println("归还图书");
        System.out.println("请输入你要归还的图书:");

        String name=this.scanner.next();
        int currentSize=bookList.getUsedSize();
        int i = 0;
        for (; i <currentSize ; i++) {
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                book.setBorrowed(false);
                break;
            }
        }
        if(i==currentSize){
            System.out.println("没有此书");
            return;
        }
        System.out.println("归还图书成功");
    }
}
