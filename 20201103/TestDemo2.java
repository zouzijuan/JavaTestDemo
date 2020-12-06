/**
 * Program:20201103
 * description:
 * author:ZOU zijuan
 * create:2020-11-03 23:38
 **/
public class TestDemo2 {
    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);
        myQueue.offer(4);

        System.out.println(myQueue.peek());

        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        myQueue.poll();
        myQueue.poll();
        myQueue.poll();
    }

}
class Node{
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class MyQueue{
    public Node head;
    public Node tail;

    public void offer(int val){
        Node node=new Node(val);
        if(this.head==null){
            this.head=node;
            this.tail=node;
            return;
        }
        this.tail.next=node;
        this.tail=node;
    }

    public int poll(){
        if(this.head==null){
            throw new RuntimeException("队列为空！");
        }
        int oldData=this.head.val;
        if (this.head.next==null){
            this.head=null;
            this.tail=null;
        } else {
            this.head=this.head.next;
        }

        return oldData;
    }

    public int peek(){
        if(this.head==null){
            throw new RuntimeException("队列为空！");
        }
        int oldData=this.head.val;
        return oldData;
    }

    public boolean isEmpty(){
        return this.head==null;
    }

}
