package user;

import book.BookList;
import operation.IOperation;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 09:55
 **/
public abstract class User {
    protected String name;

    protected IOperation[] iOperations;

    public User(String name){
        this.name=name;
    }

    public abstract int  menu();

    public IOperation doOperation(int choice){
        return this.iOperations[choice];
    }

}
