import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * program:20201121
 * description:
 * author:Zou zijuan
 * create:2020-11-21-15:09
 **/
public class TestDemo {

    //存在重复元素
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int key:nums) {
            if(map.containsKey(key)){
                int value=map.get(key);
                map.put(key,value+1);
            } else {
                map.put(key,1);
            }
        }

        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(entry.getValue()>=2){
                return true;
            }
        }
        return false;
    }
}

class MyHashMap {
    static class Node {
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

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        this.array = new Node[10];
        this.usedSize = 0;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = key % array.length;
        for (Node cur = array[index]; cur != null; cur = cur.next) {
            if (cur.data == key) {
                cur.value = value;
                return;
            }
        }

        Node node = new Node(key, value);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;

        if (loadFactor() > 0.75) {
            resize();
        }
    }

    public float loadFactor() {
        return this.usedSize * 1.0f / this.array.length;
    }

    public void resize() {
        Node[] newArray = new Node[2 * array.length];
        for (int i = 0; i < this.array.length; i++) {
            Node curNext = null;
            for (Node cur = this.array[i]; cur != null; cur = curNext) {
                curNext = cur.next;

                int index = cur.data % newArray.length;
                cur.next = newArray[index];
                newArray[index] = cur;
            }
        }
        this.array = newArray;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = key % this.array.length;
        for (Node cur = this.array[index]; cur != null; cur = cur.next) {
            if (cur.data == key) {
                return cur.value;
            }
        }
        return -1;
    }

    public void remove(int key) {
        int index = key % this.array.length;
        Node prev = null;

        for (Node cur = this.array[index]; cur != null; cur = cur.next) {
            if (cur.data == key) {
                if (cur == this.array[index]) {
                    this.array[index] = cur.next;
                    this.usedSize--;
                    break;
                } else {
                    prev.next = cur.next;
                    this.usedSize--;
                    break;
                }
            } else {
                prev = cur;
            }
        }
    }
}


class MyHashSet {
    static class Node{
        public int key;
        public Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    public Node[] elem;
    public int usedSize;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.elem=new Node[10];
        this.usedSize=0;
    }

    public void add(int key) {
        if(!contains(key)){
            int index=key%this.elem.length;
            Node cur=new Node(key);
            cur.next=this.elem[index];
            this.elem[index]=cur;
        } else {
            return;
        }
    }

    public void remove(int key) {
        int index=key%this.elem.length;
        Node prev=null;

        for(Node cur=this.elem[index];cur!=null;cur=cur.next){
            if(cur.key==key){
                if(cur==this.elem[index]){
                    this.elem[index]=cur.next;
                    this.usedSize--;
                    break;
                } else {
                    prev.next=cur.next;
                    this.usedSize--;
                    break;
                }
            } else{
                prev=cur;
            }
        }
    }
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index=key%this.elem.length;
        Node cur=this.elem[index];
        while (cur!=null){
            if(cur.key==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }
}