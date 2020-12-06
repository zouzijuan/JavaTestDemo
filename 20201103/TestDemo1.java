import org.omg.CORBA.Object;

import java.util.Objects;

/**
 * Program:20201103
 * description:
 * author:ZOU zijuan
 * create:2020-11-03 21:42
 **/
class MyStack {
    public int[] elem;
    public int usedSize=0;

    public MyStack(){
        this.elem=new int[5];
    }
    public void push(int item){
        if(isFull()){
            return;
        }
       this.elem[this.usedSize++]=item;

    }
    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        return this.elem[--this.usedSize];

    }
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("栈为空！");
        }
        return this.elem[--this.usedSize];

    }
    public boolean isEmpty(){
        return this.usedSize==0;
    }

    public boolean isFull(){
      return usedSize==this.elem.length;
    }
}
public class TestDemo1{
    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        myStack.push(4);
        System.out.println(myStack.pop());
    }
}
