/**
 * Program:20201022
 * description:
 * author:ZOU zijuan
 * create:2020-10-22 09:30
 **/
public class TestDemo {

    //输入两个链表，找出它们的第一个公共节点。
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA!=null||headB!=null){
            return null;
        }
        Node pl=headA;
        Node ps=headB;

        int lenA=0;
        while(pl!=null){
            lenA++;
            pl= pl.next;
        }

        int lenB=0;
        while(ps!=null){
            lenB++;
            ps= ps.next;
        }

        pl=headA;
        ps=headB;

        int len=lenA-lenB;
        if(len<0){
            pl=headB;
            ps=headA;
            len=lenB-lenA;
        }

        for (int i = 0; i <len ; i++) {
            pl=pl.next;
        }

        while(pl!=ps&&pl!=null&&ps!=null){
            pl=pl.next;
            ps=ps.next;
        }
        if(ps==pl&&pl!=null){
            return pl;
        }
        return null;
    }

    //将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
    public Node mergeTwoLists(Node headA,Node headB){
        Node newHead=new Node(-1);
        Node tmp=newHead;

        while(headA!=null&&headB!=null){
            if(headA.data<headB.data){
                tmp.next=headA;
                tmp=tmp.next;
                headA=headA.next;
            } else {
                tmp.next=headB;
                tmp=tmp.next;
                headB=headB.next;
            }
        }
        if(headA!=null){
            tmp.next=headA;
        } else {
            tmp.next=headB;
        }
        return newHead.next;
    }


    public static void main(String[] args) {
        MySingleList mySingleList1=new MySingleList();
        mySingleList1.addLast(1);
        mySingleList1.addLast(3);
        mySingleList1.addLast(5);
        mySingleList1.addLast(7);

        MySingleList mySingleList2=new MySingleList();
        mySingleList2.addLast(2);
        mySingleList2.addLast(4);
        mySingleList2.addLast(6);
        mySingleList2.addLast(8);

        TestDemo testDemo=new TestDemo();
        Node ret=testDemo.mergeTwoLists(mySingleList1.head,mySingleList2.head);
        mySingleList1.display2(ret);

    }
}
