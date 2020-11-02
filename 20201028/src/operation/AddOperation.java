package operation;

import book.Book;
import book.BookList;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 09:37
 **/
public class AddOperation implements IOperation{
    public void work(BookList bookList){
        System.out.println("新增图书");
        System.out.println("请输入书名:");
        String name=this.scanner.next();
        System.out.println("请输入作者:");
        String author=this.scanner.next();
        System.out.println("请输入价格:");
        int price=this.scanner.nextInt();
        System.out.println("请输入类型:");
        String type=this.scanner.next();

        Book book=new Book(name,author,price,type);
        int currentSize=bookList.getUsedSize();
        bookList.setBook(currentSize,book);
        bookList.setUsedSize(currentSize+1);

    }
}
