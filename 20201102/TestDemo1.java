import java.util.ArrayList;
import java.util.List;

/**
 * Program:20201102
 * description:
 * author:ZOU zijuan
 * create:2020-11-02 17:03
 **/
public class TestDemo1 {

    public static void main(String[] args) {
        int[][] grid=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(shiftGrid(grid, 100));
    }
    //二维网络迁移
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<Integer> num=new ArrayList<>();
        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j <grid[0].length ; j++) {
                num.add(grid[i][j]);
            }
        }
        int tmp=num.size()-1;
        List<Integer> shift=new ArrayList<>();
        k=k%num.size();
        for (int i =k-1; i>=0; i--) {
            int tmpNum=num.get(tmp-i);
            shift.add(tmpNum);
        }
        for (int i = 0; i<=tmp-k; i++) {
            int tmpNum=num.remove(0);
            shift.add(tmpNum);
        }
       List<List<Integer>> lists=new ArrayList<>(grid.length);
        for (int i = 0; i <grid.length ; i++) {
            List<Integer> listOne=new ArrayList<>();
            for (int j = 0; j <grid[0].length ; j++) {
                listOne.add(shift.remove(0));
            }
            lists.add(listOne);
        }
        return lists;
    }





    //将数组分成和相等的三部分
    public boolean canThreePartsEqualSum(int[] A) {
            int sum=0;
            for (int x:A) {
                sum+=x;
            }
            if(sum%3!=0){
                return false;
            }

            sum/=3;
            int count=0;
            int tmp=0;
            for (int i = 0; i <A.length ; i++) {
                tmp+=A[i];
                if(tmp==sum){
                    tmp=0;
                    count++;
                }
            }
            return count>=3;
    }
}






//员工的重要性
class Solution {
    public int getImportance(List<Employee> employees, int id) {
        if (employees.size() == 0) {
            return 0;
        }
        for (Employee employee : employees) {
            if (employee.id == id) {
                if (employee.subordinates.size() == 0) {
                    return employee.importance;
                }
                for (int subId : employee.subordinates) {
                    employee.importance += getImportance(employees, subId);

                }
                return employee.importance;
            }
        }
        return 0;
    }
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };






    //小镇法官
    public int findJudge(int N, int[][] trust) {
        int[][] people = new int[N][2];//N个人,第一列a,第二列b
        for (int[] row : trust) {
            //a相信b,b被a信任
            int a = row[0];
            int b = row[1];

            people[a - 1][0]++;//a相信的人数
            people[b - 1][1]++;//相信b的人数
        }
        for (int i = 0; i < N; i++) {
            if (people[i][0] == 0 && people[i][1] == N - 1) {
                return i+1;
            }

        }
        return -1;
    }
}