import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Program:20201104
 * description:
 * author:ZOU zijuan
 * create:2020-11-4 15:53
 **/

class MyStack {
    public Queue<Integer> qu1;
    public Queue<Integer> qu2;
    public int usedSize;

    /** Initialize your data structure here. */
    public MyStack() {
        qu1=new LinkedList<>();
        qu2=new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!qu1.isEmpty()){
            qu1.offer(x);
        } else if (!qu2.isEmpty()){
            qu2.offer(x);
        } else {
            qu1.offer(x);
        }
        usedSize++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()){
            return -1;
        }

        int size=usedSize-1;
       if(!qu1.isEmpty()){
           while (size>0){
               qu2.offer(qu1.poll());
               size--;
           }
           usedSize--;
           return qu1.poll();
       } else {
           while (size>0){
               qu1.offer(qu2.poll());
               size--;
           }
           usedSize--;
           return qu2.poll();
       }

    }

    /** Get the top element. */
    public int top() {
        if(empty()){
            return -1;
        }

        int size=usedSize;
        int tmp=-1;
        if(!qu1.isEmpty()){
            while(size>0) {
                tmp=qu1.poll();
                qu2.offer(tmp);
                size--;
            }
            return tmp;
        } else {
            while (size>0){
                tmp=qu2.poll();
                qu1.offer(tmp);
                size--;
            }
            return tmp;
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(qu1.isEmpty()&&qu2.isEmpty()){
            return true;
        }
        return false;
    }
}


class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();//入
        s2 = new Stack<>();//出
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.empty()) {
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if(!s2.empty()) {
            return s2.pop();
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if(s2.empty()) {
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if(!s2.empty()) {
            return s2.peek();
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(s1.empty() && s2.empty()) {
            return true;
        }
        return false;
    }
}


class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        //1、stack是一定需要放元素的
        //2、最小栈当中 是否存放数据   x<= 最小栈的栈顶元素
        stack.push(x);
        if(minStack.empty()){
            minStack.push(x);
        } else if(x<=minStack.peek()){
            minStack.push(x);
        }

    }

    public void pop() {
        //1、stack是一定需要弹出元素的
        //2、最小栈当中 是否弹出数据    x  ==  最小栈的栈顶元素
        int tmp=stack.pop();
        if(tmp==minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        //跟最小栈没有关系
        return stack.peek();
    }

    public int getMin() {
        //每次返回最小栈的栈顶元素
        return minStack.peek();
    }
}


public class TestDemo {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char tmp = s.charAt(i);
            if (tmp == '(' || tmp == '[' || tmp == '{') {
                stack.push(tmp);
            } else {

                if (stack.empty()) {
                    System.out.println("右括号多");
                    return false;
                } else {

                    if (tmp == ')' && stack.peek() == '(' || tmp == ']' && stack.peek() == '['
                            || tmp == '}' && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        System.out.println("左右括号不匹配");
                        return false;
                    }

                }
            }
        }
        if(!stack.empty()){
            System.out.println("左括号多");
            return false;
        }
        System.out.println("括号匹配");
        return true;
    }

    public static void main(String[] args) {
        MyStack myStack=new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());

    }
}

