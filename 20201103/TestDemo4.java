import java.util.Stack;

/**
 * Program:20201103
 * description:
 * author:ZOU zijuan
 * create:2020-11-03 20:32
 **/

public class TestDemo4 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] S=new String[]{"1","2","3","*","+"};
        solution.evalRPN(S);
    }
}

class Solution {

    //比较退格字符
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> sta1=new Stack<>();
        Stack<Character> sta2=new Stack<>();
        for (int i = 0; i <S.length(); i++) {
            char tmp=S.charAt(i);
            if(tmp!='#'){
                sta1.push(tmp);
            }
            if(tmp=='#'&&!sta1.empty()){
                sta1.pop();
            }
        }

        for (int i = 0; i <T.length(); i++) {
            char tmp=T.charAt(i);
            if(tmp!='#'){
                sta2.push(tmp);
            }
            if(tmp=='#'&&!sta2.empty()){
                sta2.pop();
            }
        }
        return sta1.equals(sta2);
    }

    //棒球比赛
    public int calPoints(String[] ops) {
        Stack<Integer> stack=new Stack<>();
        for(String s:ops){
            switch (s){
                case "+":{
                    int tmp1=0;
                    int tmp2=0;
                    if(!stack.empty()){
                        tmp1=stack.pop();
                    }
                    if (!stack.empty()) {
                        tmp2 = stack.pop();
                    }
                    stack.push(tmp2);
                    stack.push(tmp1);
                    stack.push(tmp1+tmp2);
                    break;
                }

                case "D":{
                    int tmp1=0;
                    if(!stack.empty()) {
                        tmp1 = stack.pop();
                        stack.push(tmp1);
                        stack.push(tmp1 * 2);
                    }
                    break;

                }
                case "C":{
                    if (!stack.empty()){
                        stack.pop();
                    }
                    break;
                }
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        int sum=0;
        while (!stack.empty()){
            sum+=stack.pop();
        }
        return sum;

    }

    //栈的弹出压入序列
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //数组为空的情况
        if(pushA.length == 0 || popA.length == 0){
            return false;
        }

        //弹出序列的下表索引
        int popIndex = 0;

        //辅助栈
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<pushA.length;i++){
            //不停地将pushA中的元素压入栈中，一旦栈顶元素与popA相等了，则开始出栈
            //不相等则继续入栈
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek()==popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        //栈中没有元素了说明元素全部一致，并且符合弹出顺序，那么返回true
        return stack.isEmpty();
    }



    //逆波兰表达式求值
    public void evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        String ret=null;
        for (int i = 0; i <tokens.length ; i++) {
            ret="(";
            String tmp=tokens[i];
            if(tmp=="+"||tmp=="-"||tmp=="*"||tmp=="/"){
                String ret1=null;
                String ret2=null;
                if(!stack.empty()){
                    ret1=stack.pop();
                }
                if(!stack.empty()){
                    ret2=stack.pop();
                }
                ret+=ret2+tmp+ret1;
                ret+=")";
                stack.push(ret);
            } else {
                stack.push(tmp);
            }
        }
        System.out.println(ret);
    }

    public int evalRPN1(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int sum=0;
        for (int i = 0; i <tokens.length ; i++) {
            String tmp=tokens[i];
           switch (tmp){
               case "+":{
                   int tmp1=0;
                   int tmp2=0;
                   if(!stack.empty()) tmp1=stack.pop();
                   if(!stack.empty()) tmp2=stack.pop();
                   sum=tmp2+tmp1;
                   stack.push(sum);
                   break;
               }
               case "-": {
                   int tmp1=0;
                   int tmp2=0;
                   if(!stack.empty()) tmp1=stack.pop();
                   if(!stack.empty()) tmp2=stack.pop();
                   sum=tmp2-tmp1;
                   stack.push(sum);
                   break;
               }
               case "*": {
                   int tmp1=0;
                   int tmp2=0;
                   if(!stack.empty()) tmp1=stack.pop();
                   if(!stack.empty()) tmp2=stack.pop();
                   sum=tmp2*tmp1;
                   stack.push(sum);
                   break;
               }
               case "/": {
                   int tmp1=0;
                   int tmp2=0;
                   if(!stack.empty()) tmp1=stack.pop();
                   if(!stack.empty()) tmp2=stack.pop();
                   sum=tmp2/tmp1;
                   stack.push(sum);
                   break;
               }
               default:{
                   stack.push(Integer.valueOf(tmp));
               }
           }
        }
        return stack.empty()?sum:stack.pop();
    }

}



//股票价格跨度
class StockSpanner {
    Stack<Integer> stack;
    Stack<Integer> spam;

    public StockSpanner() {
        stack=new Stack<>();
        spam=new Stack<>();
    }

    public int next(int price) {
        int spanner=1;
        while (!stack.empty()&&price>=stack.peek()){
            spanner++;
            spam.push(stack.pop());
        }
        while (!spam.empty()){
            stack.push(spam.pop());
        }
        stack.push(price);
        return spanner;
    }
}


//循环双端队列
class MyCircularDeque {
    public int[] elem;
    public int front;
    public int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.elem=new int[k+1];

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }

        if(this.front==0){
            front=this.elem.length-1;
            this.elem[front]=value;
        } else {
            this.front=this.front-1;
            this.elem[this.front]=value;
        }
        return true;

    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        this.elem[this.rear]=value;
        this.rear=(this.rear+1)%this.elem.length;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        this.front=(this.front+1)%this.elem.length;
        return true;

    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        if(rear==0){
            this.rear=this.elem.length-1;
        } else {
            this.rear=this.rear-1;
        }
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return this.elem[this.front];

    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        int index=this.rear==0?this.elem.length-1:this.rear-1;
        return this.elem[index];

    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(rear==front){
            return true;
        }
        return false;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        if((rear+1)%this.elem.length==front){
            return true;
        }
        return false;
    }
}

