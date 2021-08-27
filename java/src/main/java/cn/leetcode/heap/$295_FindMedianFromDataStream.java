package cn.leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class $295_FindMedianFromDataStream {
    Queue<Integer> maxQ;
    Queue<Integer> minQ;

    /**
     * initialize your data structure here.
     */
    public $295_FindMedianFromDataStream() {
        maxQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        minQ = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    }

    public void addNum(int num) {
        if (maxQ.size() == minQ.size()) {
            maxQ.offer(num);
            minQ.offer(maxQ.poll());
            maxQ.offer(minQ.poll());
        } else if (maxQ.size() == minQ.size() + 1) {
            maxQ.offer(num);
            minQ.offer(maxQ.poll());
        }
    }

    public double findMedian() {
        if (maxQ.size() == minQ.size()) {
            return (maxQ.peek() + minQ.peek()) / 2.0;
        } else if (maxQ.size() == minQ.size() + 1) {
            return maxQ.peek();
        }
        return -1;
    }

    public static void main(String[] args) {
        $295_FindMedianFromDataStream instance = new $295_FindMedianFromDataStream();
        instance.addNum(1);
        instance.addNum(2);
        double res = instance.findMedian();
        instance.addNum(3);
        instance.findMedian();
        System.out.println(res);
    }
}
