import java.util.Arrays;

/**
 * Program:20201019
 * description:
 * author:ZOU zijuan
 * create:2020-10-19 20:27
 **/
public class MyArrayList {
    public int[] elem;
    public int usedSize;

    public MyArrayList() {
        this.elem = new int[10];
        this.usedSize = 0;
    }

    public MyArrayList(int capacity) {
        this.elem = new int[capacity];
        this.usedSize = 0;
    }

    public boolean isFull(){
        if(this.usedSize==this.elem.length) {
            return true;
        }
        return false;
    }

    public void resize(){
    this.elem=Arrays.copyOf(this.elem,this.elem.length*2);
    }

    //在pos位置新增元素
    public void add(int pos, int data) {
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        if (isFull()) {
           // System.out.println("顺序表为满");
            resize();
            //return;
        }

        for (int i = this.usedSize - 1; i >= pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    // 打印顺序表
    public void display() {
        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    //判断是否包含某个元素
    public boolean contains(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (elem[i] == toFind) {
                return true;

            }
        }
        return false;
    }

    //查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < this.usedSize; i++) {
            if (elem[i] == toFind) {
                return i;

            }
        }
        return -1;
    }

    //获取pos位置的元素
    public int getPos(int pos) {
        if (pos < 0 || pos >= this.usedSize) {
            System.out.println("pos位置不合法");
            return -1;
        }
        return this.elem[pos];
    }

    //给pos位置的元素设为value
    public void setPos(int pos, int value) {
        if (pos < 0 || pos > this.usedSize) {
            System.out.println("pos位置不合法");
            return;
        }
        this.elem[pos] = value;
    }

    //删除第一次出现的关键字key
    public void remove(int remove) {
        //1.找到这个元素的位置
        int index = search(remove);
        if (index == -1) {
            System.out.println("没有这个元素");
            return;
        }
        //2. 删除
        for (int i = index; i < this.usedSize - 1; i++) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;
    }

    // 清空顺序表
    public void clear() {
        this.usedSize = 0;
    }

    public static void main(String[] args) {
        MyArrayList myArrayList=new MyArrayList(5);
        myArrayList.add(0,1);
        myArrayList.add(0,2);
        myArrayList.add(0,3);
        myArrayList.add(0,4);

        myArrayList.display();

        myArrayList.add(2,19);
        myArrayList.display();

    }

}
