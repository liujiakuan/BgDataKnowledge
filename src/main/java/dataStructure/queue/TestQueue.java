package dataStructure.queue;

import org.apache.log4j.Logger;

import java.util.Arrays;

/**
 * 队列，先进先出
 */
public class TestQueue {

    private static Logger logger = Logger.getLogger(TestQueue.class);

    //队列，这里使用数组模拟队列底层数据存储
    private int[] queue;

    public static void main(String[] ljk) {
        TestQueue testQueue = new TestQueue();
        testQueue.addQueue(1);
        testQueue.addQueue(2);
        testQueue.addQueue(3);
        System.out.println(Arrays.toString(testQueue.queue));
        testQueue.outQueue();
        System.out.println(Arrays.toString(testQueue.queue));
    }

    private TestQueue() {
        queue = new int[0];
    }

    //入队列
    private void addQueue(int value) {
        int[] newQueue = new int[queue.length + 1];
        System.arraycopy(queue, 0, newQueue, 0, queue.length);
        newQueue[queue.length] = value;
        queue = newQueue;
    }

    //出队列
    private void outQueue() {
        if (0 == queue.length) {
            logger.error("queue is null ,please don't to out");
            return;
        }
        int[] newQueue = new int[queue.length - 1];
        System.arraycopy(queue, 1, newQueue, 0, newQueue.length);
        queue = newQueue;
    }
}
