package operation;

import book.Book;
import book.BookList;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 09:37
 **/
public class DelOperation implements IOperation {
    public void work(BookList bookList){
        System.out.println("删除图书");
        System.out.println("请输入你要删除的书籍:");

        String name=this.scanner.next();
        int currentSize=bookList.getUsedSize();
        int i = 0;
        for (; i <currentSize ; i++) {
            Book book=bookList.getBook(i);
            if(book.getName().equals(name)){
                break;
            }
        }
        if(i==currentSize){
            System.out.println("没有此书");
        }
        int pos=i;
        for (int j = pos; j <currentSize-1 ; j++) {
            Book book = bookList.getBook(i + 1);
            bookList.setBook(i, book);
        }
        bookList.setUsedSize(currentSize-1);
        System.out.println("删除成功");
    }
}
