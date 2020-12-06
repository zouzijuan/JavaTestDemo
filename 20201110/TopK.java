import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * program:20201110
 * description:
 * author:Zou zijuan
 * create:2020-11-13-16:35
 **/
public class TopK {
    public static void topK(int[] array,int k){
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (int i = 0; i < array.length; i++) {
            if (maxHeap.size()<k) {
                maxHeap.offer(array[i]);
            } else {
                int tmp=maxHeap.peek();
                if(array[i]<maxHeap.peek()){
                    maxHeap.poll();
                    maxHeap.offer(array[i]);
                }
            }
        }
        System.out.println(maxHeap);
    }

    public static void main(String[] args) {
        int[] array={1,3,2,4,5,6,7,8,9};
        topK(array,5);

    }
}
