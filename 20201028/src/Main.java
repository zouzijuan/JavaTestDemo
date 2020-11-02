import book.BookList;
import operation.IOperation;
import user.Admin;
import user.NormalUser;
import user.User;

import java.util.Scanner;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 08:44
 **/
public class Main {

    public static User login(){
        System.out.println("请输入用户名:");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.next();
        System.out.println("请输入你的身份,1是管理员，0是普通用户");

        int choice=scanner.nextInt();
        if(choice==1){
            return new Admin(name);
        } else {
            return new NormalUser(name);
        }
    }

    public static void main(String[] args) {
        BookList bookList=new BookList();
        User user=login();
        while(true){
            int choice=user.menu();
            IOperation iOperation=user.doOperation(choice);
            iOperation.work(bookList);
        }


    }
}
