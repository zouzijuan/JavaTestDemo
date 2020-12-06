/**
 * Program:20201103
 * description:
 * author:ZOU zijuan
 * create:2020-11-03 12:56
 **/
class MyCircularQueue{
    public int[] elem;
    public int front;
    public int rear;

    public MyCircularQueue(int k){
        this.elem=new int[k];
    }

    public boolean isEmpty(){
        if(this.front==this.rear){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if((this.rear+1)%this.elem.length==this.front){
            return true;
        }
        return false;
    }

    public boolean enQueue(int value){
        if(isFull()){
            return false;
        }
        this.elem[this.rear]=value;
        this.rear=(this.rear+1)%this.elem.length;
        return true;
    }

    public boolean deQueue(){
        if(isEmpty()){
            return false;
        }
        this.front=(this.front+1)%this.elem.length;
        return true;
    }

    public int Front(){
        if(isEmpty()){
            return -1;
        }
        return this.elem[this.front];
    }

    public int Rear(){
        if(isEmpty()){
            return -1;
        }
        int index=this.rear==0?this.elem.length:this.rear-1;
        return this.elem[index];
    }
}
public class TestDemo3 {

}
