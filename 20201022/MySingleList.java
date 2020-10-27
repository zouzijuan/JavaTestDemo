/**
 * Program:20201022
 * description:
 * author:ZOU zijuan
 * create:2020-10-22 20:53
 **/
class Node{
    public int data;
    public Node next;

    public Node(int data){
        this.data=data;
    }
}

public class MySingleList {
    public Node head;

    //头插法
    public void addFirst(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
        } else {
            node.next=this.head;
            this.head=node;
        }
    }
    public void display(){
        Node cur=this.head;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    public void display2(Node newHead){
        Node cur=newHead;
        while(cur!=null){
            System.out.print(cur.data+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    //尾插法
    public void addLast(int data){
        Node node=new Node(data);
        if(this.head==null){
            this.head=node;
            return;
        }
        Node cur=this.head;
        while (cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }

    //任意位置插入，第一个数据节点为0号下标
    public void  addIndex(int index,int data){
        Node node=new Node(data);
        if (index<0||index>size()){
            System.out.println("index不合法");
            return;
        }
       if(index==0){
           addFirst(data);
           return;
       }
       Node cur=searchPrev(index);
       node.next=cur.next;
       cur.next=node;
    }

    public Node searchPrev(int index){
        int count=0;
        Node cur =this.head;
        while(count<index-1){
            cur=cur.next;
            count++;
        }
        return cur;
    }

    public int size(){
        Node cur=this.head;
        int count=0;
        while(cur!=null){
            count++;
            cur=cur.next;
        }
        return count;
    }

    //查找是否包含关键字key是否在单链表中
    public boolean contains(int key){
       Node cur=this.head;
       while(cur!=null){
           if(cur.data==key){
               return  true;
           }
           cur=cur.next;
       }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key){
       if(this.head.data==key) {
           this.head = this.head.next;
           return;
       }
       Node prev=searchPrevNode(key);
       if(prev==null){
           return;
       }
       Node del=prev.next;
       prev.next=del.next;
    }

    public Node searchPrevNode(int key){
        Node cur=this.head;
        while(cur.next!=null){
            if(cur.next.data==key){
                return cur;
            }
            cur=cur.next;
        }
        return null;//没有key的前驱
    }

    public void removeAllKey(int key){
        Node cur=this.head.next;
        Node prev=this.head;
        while(cur!=null){
            if(cur.data==key){
                prev.next=cur.next;
                //cur=cur.next;
            } else {
                prev=cur;
                //cur=cur.next;
            }
            cur=cur.next;
        }
        if(this.head.data==key){
            this.head=this.head.next;
        }
    }

    public void clear(){
        this.head=null;
    }

    //反转一个单链表
    public Node reverseList(){
        Node newHead=null;
        Node cur=this.head;
        Node prev=null;
        while(cur!=null){
            Node curNext=cur.next;
            if(curNext==null){
                newHead=cur;
            }
            cur.next=prev;
            prev=cur;
            cur=curNext;

        }
        return newHead;
    }

    //给定一个带有头节点head的非空单链表，返回链表的中间节点
    public Node middleNode(){
        Node fast=this.head;
        Node slow=this.head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个节点
    public Node FindKthToTail(int k){
        if(k<=0){
            return null;
        }
        Node fast=this.head;
        Node slow=this.head;
        while(k-1>0){
            if(fast.next==null){
                System.out.println("没有这个节点");
                return null;
            }
            fast=fast.next;
            k--;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    //编写代码，给定值x为基准将链表分割成两部分，所有小于x的节点排在大于或等于x的结点之前
    public Node partition(int x){
        Node bs=null;
        Node be=null;
        Node as=null;
        Node ae=null;
        Node cur=this.head;

        while(cur!=null){

            if(cur.data<x){

                if(bs==null){
                    bs=cur;
                    be=cur;
                } else {
                    be.next=cur;
                    be=be.next;
                }

            } else {

                if(as==null){
                    as=cur;
                    ae=cur;
                } else {
                    ae.next=cur;
                    ae=ae.next;
                }
            }
            cur=cur.next;
        }
        if (bs==null){
            return as;
        }
        be.next=as;
        if(as!=null){
            ae.next=null;
        }
        return bs;
    }

    //在一个排序的链表中，存在重复节点，请删除重复的节点，重复的节点不保留，返回链表头指针
    public Node deleteDuplication(){
        Node cur=this.head;
        Node newHead=new Node(-1);
        Node tmp=newHead;
        while(cur!=null){
            if(cur.next!=null&&cur.data==cur.next.data) {
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next=cur;
                tmp=tmp.next;
                cur=cur.next;
            }
        }
        tmp.next=null;
        return newHead;
    }

    //对于一个链表，请设计一个时间复杂度为O(n)，格外空间复杂度为O(1)的算法，判断其是否为回文结构
    public boolean chkPalindrome(){
        Node fast=this.head;
        Node slow=this.head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }

        Node cur=slow.next;
        while (cur!=null){
            Node curNext=cur.next;
            cur.next=slow;
            slow=cur;
            cur=curNext;
        }

        while (this.head!=slow){
            if(this.head.data!=slow.data){
                return false;
            }
            if(this.head.next==slow){
                return true;
            }
            this.head=this.head.next;
            slow=slow.next;
        }
        return true;
    }

    //给定一个链表，判断链表是否有环
    public boolean hasCycle(){
        Node fast=this.head;
        Node slow=this.head;

        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if (fast==null||fast.next==null){
            return false;
        }
        return true;
    }

    //给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null
    public Node detectCycle(){
        Node fast=this.head;
        Node slow=this.head;

        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                break;
            }
        }
        if (fast==null||fast.next==null){
            return null;
        }
        slow=this.head;
        while(slow!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }


}
