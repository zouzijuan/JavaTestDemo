import java.util.*;

/**
 * program:20201119
 * description:
 * author:Zou zijuan
 * create:2020-11-19-10:11
 **/
class HashBuck{

    static class Node{
        public int data;
        public int value;
        public Node next;

        public Node(int data, int value) {
            this.data = data;
            this.value = value;
        }
    }

    public Node[] array;
    public int usedSize;

    public HashBuck() {
        this.array= new Node[10];
        this.usedSize = 0;
    }


    public void put(int key,int value){
        int index=key%array.length;
        for(Node cur=array[index];cur!=null;cur=cur.next){
            if(cur.data==key){
                cur.value=value;
                return;
            }
        }

        Node node=new Node(key,value);
        node.next=array[index];
        array[index]=node;
        this.usedSize++;

        if(loadFactor()>0.75){
            resize();
        }
    }

    public float loadFactor(){
        return this.usedSize*1.0f/this.array.length;
    }

    public void resize(){
        Node[] newArray=new Node[2*array.length];
        for (int i = 0; i <this.array.length ; i++) {
            Node curNext=null;
            for (Node cur=this.array[i];cur!=null;cur=curNext) {
                curNext=cur.next;

                int index=cur.data%newArray.length;
                cur.next=newArray[index];
                newArray[index]=cur;
            }
        }
        this.array=newArray;
    }

    public int get(int key){
        int index=key%this.array.length;
        for(Node cur=this.array[index];cur!=null;cur=cur.next){
            if(cur.data==key){
                return cur.value;
            }
        }
        return -1;
    }
}


public class TestDemo {
    public static void main(String[] args) {
        HashBuck buck=new HashBuck();
        buck.put(1,1);
        buck.put(2,2);
        buck.put(3,3);
        System.out.println(buck.get(1));
        System.out.println(buck.usedSize);
    }
}
