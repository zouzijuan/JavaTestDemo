import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * program:20201110
 * description:
 * author:Zou zijuan
 * create:2020-11-10-19:06
 **/
public class TestHeap {
    public int elem[];
    public int usedSize;
    public TestHeap(){
        this.elem=new int[10];
    }

    public void adjustDown(int parent,int len) {
        int child=parent*2+1;

        while(child<len){
            if(child+1<len&&elem[child]<elem[child+1]){
                child++;
            }
            if(elem[child]>elem[parent]){
                int tmp=elem[parent];
                elem[parent]=elem[child];
                elem[child]=tmp;
                parent=child;
                child=2*parent+1;
            } else {
                break;
            }

        }


    }

    public void initHeap(int[] array){

        for (int i = 0; i <array.length ; i++) {
            this.elem[i]=array[i];
            this.usedSize++;
        }

        for (int i = (this.usedSize-1-1)/2; i >=0 ; i--) {
            adjustDown(i,this.usedSize);//O(log₂n)
        }
    }

    public void adjustUp(int child){
        int parent=(child-1)/2;
        while (parent>=0){
            if(elem[child]>elem[parent]){
                int tmp=elem[child];
                elem[child]=elem[parent];
                elem[parent]=tmp;
                child=parent;
                parent=(child+1)/2;
            } else {
                break;
            }
        }
    }

    public void push(int val){
        if(isFull()){
            this.elem=Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.usedSize]=val;
        this.usedSize++;
        adjustUp(this.usedSize-1);

    }

    public boolean isFull(){
       return this.usedSize==this.elem.length;
    }

    public void pop(){
        if(isEmpty()) return;
        int tmp=elem[0];
        elem[0]=elem[this.usedSize-1];
        this.usedSize--;
        adjustDown(0,this.usedSize);
    }

    public boolean isEmpty(){
        return this.usedSize==0;
    }

    public void heapSort(){
        int end = this.usedSize - 1;
        while (end > 0) {
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }

    public void show() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}
