package user;

import operation.*;

import java.util.Scanner;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 10:10
 **/
public class Admin extends User {
    public Admin(String name) {
        super(name);

        this.iOperations=new IOperation[]{
                new ExitOperation(),
                new FindOperation(),
                new AddOperation(),
                new DelOperation(),
                new DisplayOperation(),
        };
    }

    @Override
    public int menu() {
        System.out.println("hello!"+this.name+"欢迎您进入图书管理系统！");
        System.out.println("1 查找图书");
        System.out.println("2 新增图书");
        System.out.println("3 删除图书");
        System.out.println("4 显示图书");
        System.out.println("0 退出系统");
        Scanner scanner=new Scanner(System.in);
        int choice=scanner.nextInt();
        return choice;
    }
}
