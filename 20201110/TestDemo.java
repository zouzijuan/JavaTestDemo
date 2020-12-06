import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * program:20201110
 * description:
 * author:Zou zijuan
 * create:2020-11-10-23:27
 **/
public class TestDemo {

    //查找最后一块石头的重量
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for(int i:stones) {
            queue.offer(i);
        }
        while(queue.size() >= 2) {
            Integer x = queue.poll();

            Integer y = queue.poll();

            queue.offer(x-y);

        }
        return queue.poll();
    }
}

//查找和最小的k对数
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(k, (o1, o2)->{
            return (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1));
        });

        // 遍历所有可能的集合
        for(int i = 0; i < Math.min(nums1.length, k); i++){
            for(int j = 0; j < Math.min(nums2.length, k); j++){

                if(queue.size() == k &&
                        nums1[i]+nums2[j] > queue.peek().get(0) + queue.peek().get(1)){
                    break;
                }

                // 若比堆顶小，则弹出堆顶元素，把当前数对加入
                if(queue.size() == k){
                    queue.poll();
                }
                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                queue.add(pair);
            }
        }

        // 最后将元素弹出，倒序插入数组即可
        List<List<Integer>> res = new LinkedList<>();
        for(int i =0; i < k && !queue.isEmpty(); i++){
            res.add(0, queue.poll());
        }
        return res;
    }
}
