/**
 * Program:20201023
 * description:
 * author:ZOU zijuan
 * create:2020-10-23 16:34
 **/
class Node{
    public int data;
    public Node prev;
    public Node next;

    public Node(int data){
        this.data=data;
    }
}

//无头双向链表实现
public class DoubleList {
    public Node head;
    public Node last;


    //头插法  
    public void addFirst(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        } else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }


    //尾插法   
    public void addLast(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            this.last=node;
        } else {
            this.last.next=node;
            node.prev=this.last;
            this.last=node;
        }
    }

    public Node searchIndex(int index){
        if(index<0||index>size()){
            return null;
        }
        Node cur=this.head;
        while (index!=0){
            cur=cur.next;
            index--;
        }
        return cur;
    }


    //任意位置插入,第一个数据节点为0号下标  
    public void addIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return;
        }
        if(index==size()){
            addLast(data);
        }
        Node node=new Node(data);
        Node cur=searchIndex(index);
        if(cur==null){
            return;
        }

    }


    //查找是否包含关键字key是否在单链表当中    
    public boolean contains(int key){
        Node cur=this.head;
        while (cur!=null){
            if(cur.data==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }


    //删除第一次出现关键字为key的节点    
    public void remove(int key){
        Node cur=this.head;
        while (cur!=null){
            if(cur.data==key){
                if(this.head.data==key){
                    this.head=this.head.next;
                    this.head.prev=null;
                } else {
                    cur.prev.next=cur.next;
                    if(cur.next!=null){
                        cur.next.prev=cur.prev;
                    } else {
                        this.last=this.last.prev;
                    }
                }
                return;
            }
            cur=cur.next;
        }
    }


    //删除所有值为key的节点    
    public void removeAllKey(int key){
        Node cur = this.head;
        while (cur != null) {
            if(cur.data == key) {
                if(this.head.data == key) {
                    if(this.head.next == null) {
                        this.head = null;
                        return;
                    }
                    this.head = this.head.next;
                    this.head.prev = null;
                }else {
                    cur.prev.next = cur.next;
                    if(cur.next!=null) {
                        //当前的cur不是最后一个节点
                        cur.next.prev = cur.prev;
                    }else {
                        this.last = this.last.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }


    //得到单链表的长度    
    public int size(){
        Node cur=this.head;
        int count=0;
        while (cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }


    public void display(){
        Node cur=this.head;
        while (cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();

    }


    public void clear(){
        this.head=null;
        this.last=null;

    }
}
