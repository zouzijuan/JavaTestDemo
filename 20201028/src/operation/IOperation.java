package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 09:50
 **/
public interface IOperation {
    Scanner scanner=new Scanner(System.in);
    void work(BookList bookList);
}
