import java.util.*;

/**
 * Program:20201102
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 17:04
 **/
class Student{
    public String name;
    public String classes;
    public double score;

    public Student(String name, String classes, double score) {
        this.name = name;
        this.classes = classes;
        this.score = score;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                ", score=" + score +
                '}';
    }
}
public class ListDemo {
    public static List<String> func(String str1,String str2){
        List<String> list=new ArrayList<>();
        for (int i = 0; i <str1.length() ; i++) {
            char tmp=str1.charAt(i);
            if(!str2.contains(tmp+"")){
                list.add(tmp+"");
            }
        }
        return list;

    }

    //杨辉三角
    public static List<List<Integer>> generate(int numRows){
        if(numRows==0){
            return null;
        }
        List<List<Integer>> ret=new ArrayList<>();
        List<Integer> one=new ArrayList<>();
        one.add(1);
        ret.add(one);
        for (int i = 1; i <numRows; i++) {
            List<Integer> curRow=new ArrayList<>();
            curRow.add(1);

            List<Integer> preRow=ret.get(i-1);
            for (int j = 1; j <i ; j++) {
                int tmp=preRow.get(i)+preRow.get(i-1);
                curRow.add(tmp);
            }
            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }

    public static void main(String[] args) {

    }

    //删除重复元素
    public static void main3(String[] args) {
        List<String> list=func("welcome to China","come");
        for (String str:list) {
            System.out.println(str);
        }
    }


    //用Collections.sort进行排序
    public static void main2(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(3);

        Collections.sort(list);

        System.out.println(list);

    }

    //学生考试成绩
    public static void main1(String[] args) {
        List<Student> list=new ArrayList<>();
        list.add(new Student("aa","Java1",99));
        list.add(new Student("bb","Java2",77));
        list.add(new Student("cc","Java3",85));

        for (Student student:list) {
            System.out.println(student);

        }

    }

}
