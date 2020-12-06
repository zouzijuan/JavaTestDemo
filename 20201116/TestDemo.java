import java.util.*;

/**
 * program:20201116
 * description:
 * author:Zou zijuan
 * create:2020-11-16-10:18
 **/
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class TestDemo {

    //字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        char[] ch=s.toCharArray();
        HashMap<Character,Integer> map=new HashMap<>();
        for (char key:ch) {
            if(map.containsKey(key)){
                int value=map.get(key);
                map.put(key,value+1);
            }else {
                map.put(key,1);
            }
        }

        int count=0;
        for (char key:ch) {
            if (map.get(key)==1){
                return count;
            }
            count++;
        }
            return -1;
    }

    //两个数组的交集
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set=new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }
        HashSet<Integer> set1=new HashSet<>();
        for (int num:nums2) {
            if(set.contains(num)){
                set1.add(num);
            }
        }
        Iterator<Integer> it=set1.iterator();
        int [] nums=new int[set1.size()];
        int i=0;
        while (it.hasNext()){
            nums[i++]=it.next();
        }
        return nums;
    }

    //两个数组的交集Ⅱ
    public class Solution {

        public int[] intersect(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums1){
                map.put(num,map.getOrDefault(num,0) + 1) ;
            }

            List<Integer> resultList = new ArrayList<>() ;
            for (int num : nums2){
                if(map.getOrDefault(num,-1) > 0){
                    resultList.add(num) ;
                    map.put(num,map.get(num) -1) ;
                }
            }


            int[] result = new int[resultList.size()] ;

            int index =0 ;
            for (int num : resultList)
                result[index ++] = num ;
            return result;
        }
    }

    //同构字符串
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            if(!map.containsKey(s.charAt(i))){
                if(map.containsValue(t.charAt(i))){
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            }else{
                if(map.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        String strMust=scan.nextLine();
        String strAct=scan.nextLine();
        func(strMust,strAct);
    }
    //旧键盘
    public static void func(String strMust,String strAct){
        HashSet<Character> setAct=new HashSet<>();
        strAct.toUpperCase();
        for (char ch:strAct.toUpperCase().toCharArray()) {
            setAct.add(ch);
        }
        HashSet<Character> setBroken=new HashSet<>();
        for (char ch:strMust.toUpperCase().toCharArray()) {
            if(!setAct.contains(ch)&&!setBroken.contains(ch)){
                setBroken.add(ch);
                System.out.print(ch);
            }
        }
    }

    //宝石与石头
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> setJ=new HashSet();
        char[] chJ=J.toCharArray();
        for(char ch:chJ){
            setJ.add(ch);
        }
        int count=0;
        for(int i=0;i<S.length();i++){
            if(setJ.contains(S.charAt(i))){
                count++;
            }
        }
        return count;
    }

    //复制带随机指针的链表
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap();
        Node cur=head;
        while(cur!=null){
            Node node=new Node(cur.val);
            map.put(cur,node);
            cur=cur.next;
        }

        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }

    //只出现一次的数字
    public int singleNumber(int[] nums) {
        int ret=0;
        for(int i:nums){
            ret^=i;//0异或任何数等于任何数，相同的数异或等于0;
        }
        return ret;
    }

    //1.list当中存放的数据为10万个，找出第一个重复的数据
    public static void main1(String[] args){
        ArrayList<Integer> elements=new ArrayList<>();
        Random random=new Random();
        for (int i = 0; i <100000; i++) {
            int num=random.nextInt(100000);
            elements.add(num);
        }
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i <elements.size() ; i++) {
            if(set.contains(elements.get(i))){
                System.out.println(elements.get(i));
                return;
            } else {
                set.add(elements.get(i));
            }
        }
        /*for (int i = 0; i <elements.size(); i++) {
            boolean flag=set.add(elements.get(i));
            if(flag==false){
                System.out.println(elements.get(i));
                return;
            }
        }*/
    }
    //2.list当中有10万个数据，把重复的数字全部都去重
    //1.list当中存放的数据为10万个，找出第一个重复的数据
    public static void main2(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            list.add(num);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10_0000; i++) {
            set.add(list.get(i));
        }
        //遍历set
    }

    //3.将10万个数据，统计重复数字及出现次数
    public static void main3(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10_0000; i++) {
            int num = random.nextInt(10_0000);
            list.add(num);
        }
        for (Integer key : list) {
            if(map.get(key) == null) {
                map.put(key,1);
            }else {
                int val = map.get(key);
                map.put     (key,val+1);
            }
        }

        for (Map.Entry<Integer,Integer> entry :map.entrySet()) {
            if(entry.getValue() > 1) {
                System.out.println("重复的数字:"
                        +entry.getKey()+"次数："+entry.getValue());
            }
        }
    }

}
