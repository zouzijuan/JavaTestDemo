package book;

/**
 * Program:20201028
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 08:46
 **/
public class BookList {
    private Book[] elem=new Book[10];
    private int usedSize;

    public BookList(){
        this.elem[0]=new Book("三国演义","罗贯中",25,"中国古典文学");
        this.elem[1]=new Book("水浒传","施耐庵",32,"中国古典文学");
        this.elem[2]=new Book("西游记","吴承恩",30,"中国古典文学");
        this.usedSize=3;
    }

    public void setBook(int pos,Book book){
        this.elem[pos]=book;

    }

    public Book getBook(int pos){
        return this.elem[pos];

    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }
}
