package leet.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 设计循环队列
 * @Description 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。  循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。  你的实现应该支持如下操作：  MyCircularQueue(k): 构造器，设置队列长度为 k 。 Front: 从队首获取元素。如果队列为空，返回 -1 。 Rear: 获取队尾元素。如果队列为空，返回 -1 。 enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。 deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。 isEmpty(): 检查循环队列是否为空。 isFull(): 检查循环队列是否已满。    示例：  MyCircularQueue circularQueue = new MycircularQueue(3); // 设置长度为 3  circularQueue.enQueue(1);  // 返回 true  circularQueue.enQueue(2);  // 返回 true  circularQueue.enQueue(3);  // 返回 true  circularQueue.enQueue(4);  // 返回 false，队列已满  circularQueue.Rear();  // 返回 3  circularQueue.isFull();  // 返回 true  circularQueue.deQueue();  // 返回 true  circularQueue.enQueue(4);  // 返回 true  circularQueue.Rear();  // 返回 4      提示：  所有的值都在 0 至 1000 的范围内； 操作数将在 1 至 1000 的范围内； 请不要使用内置的队列库。
 * @Author cqutwangyu
 * @DateTime 2019/2/27 12:41
 * @GitHub https://github.com/cqutwangyu
 */
public class 设计循环队列 {
    /**
     * MyCircularQueue(k): 构造器，设置队列长度为 k 。
     * Front: 从队首获取元素。如果队列为空，返回 -1 。
     * Rear: 获取队尾元素。如果队列为空，返回 -1 。
     * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
     * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
     * isEmpty(): 检查循环队列是否为空。
     * isFull(): 检查循环队列是否已满。
     */
    static class MyCircularQueue {
        /**
         * 存储队列元素
         */
        private List<Integer> data;
        /**
         * 指示起始位置的指针
         */
        private int p_start;
        /**
         * 队列长度
         */
        private int p_len;

        /**
         * 在这里初始化您的数据结构，将队列的大小设置为k。
         */
        public MyCircularQueue(int k) {
            data = new ArrayList<>();
            p_start = 0;
            p_len = k;
        }

        /**
         * 向循环队列中插入一个元素。如果操作成功，返回true。
         */
        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            } else {
                data.add(value);
                return true;
            }
        }

        /**
         * 从循环队列中删除一个元素。如果操作成功，返回true。
         */
        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            } else {
                data.remove(p_start);
                p_start = p_start + 1 < p_len ? p_start++ : 0;
                System.out.println("p_start:" + p_start);
                return true;
            }
        }

        /**
         * 从队列中获取前端项。
         */
        public int Front() {
            if (isEmpty()) {
                return -1;
            } else {
                return data.get(p_start);
            }
        }

        /**
         * 从队列中获取最后一项。
         */
        public int Rear() {
            if (isEmpty()) {
                return -1;
            } else {
                return data.get(data.size() - 1);
            }
        }

        /**
         * 检查循环队列是否为空。
         */
        public boolean isEmpty() {
            return data.isEmpty();
        }

        /**
         * 检查循环队列是否已满。
         */
        public boolean isFull() {
            return p_len <= data.size();
        }
    }
}
