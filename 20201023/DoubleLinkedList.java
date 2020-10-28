/**
 * Program:20201023
 * description:
 * author:ZOU zijuan
 * create:2020-10-23 23:45
 **/
class ListNode{
    public int val;
    public ListNode prev;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

//(带有傀儡节点的)双向链表实现
public class DoubleLinkedList {
    public ListNode head;//头
    public ListNode last;//尾巴

    public DoubleLinkedList () {
        this.head = new ListNode(-1);
    }

    //头插法
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if(this.head.next == null) {
            this.head.next = node;
            node.prev = this.head;
            this.last = node;
            return;
        }
        node.next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
    }
    //尾插法
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(this.head.next == null && this.last == null) {
            this.head.next = node;
            node.prev = this.head;
            this.last = node;
            return;
        }
        node.prev = this.last;
        this.last.next= node;
        this.last = node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {

        ListNode node = new ListNode(data);
        ListNode cur = this.head.next;

        if(index < 0 || index > size()) {
            System.out.println("输入index不合法");
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if(index == size()) {
            addLast(data);
            return;
        }
        while(index > 0) {
            cur = cur.next;
            index --;
        }
        node.next = cur;
        node.prev = cur.prev;
        cur.prev.next = node;
        cur.prev = node;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        ListNode cur = this.head.next;
        while (cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        ListNode node = this.head.next;

        while(node != null) {
            if(node.val == key) {
                if(node == this.head.next) {
                    this.head.next = this.head.next.next;
                    this.head.next.prev = this.head;
                } else {
                    node.prev.next = node.next;
                    if (node.next != null) {
                        node.next.prev = node.prev;
                    } else {
                        this.last = node.prev;
                    }
                }
                return;
            } else {
                node = node.next;
            }
        }
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        ListNode node = this.head.next;

        while(node != null) {
            if(node.val == key) {

                if(node == this.head.next) {
                    this.head.next = this.head.next.next;
                    this.head.next.prev = this.head;
                } else {
                    node.prev.next = node.next;
                    if( node.next != null) {
                        node.next.prev = node.prev;
                    } else {
                        this.last = node.prev;
                    }
                }
            }
            node = node.next;
        }
    }
    //得到单链表的长度
    public int size() {
        ListNode node = this.head.next;
        int count  = 0;
        while (node != null) {
            node = node.next;
            count++;
        }
        return count;
    }
    public void display() {

        ListNode cur = this.head.next;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();

    }
    public void clear() {
        this.head = null;
        this.last = null;
    }

}