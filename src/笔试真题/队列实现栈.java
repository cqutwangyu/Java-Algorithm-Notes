package 笔试真题;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName 队列实现栈
 * @Description
 * @Author ChongqingWangYu
 * @DateTime 2019/3/26 21:15
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 队列实现栈 {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        System.out.println(s.pop());
        s.push(3);
        s.push(4);
        s.push(5);
        System.out.println(s.toString());
        System.out.println("peek:" + s.peek());
        System.out.println(s.toString());
        s.push(6);
        System.out.println(s.pop());
        System.out.println(s.pop());
    }

    /**
     * 使用两个队列实现栈，制造栈的假象，队尾的数一定是最后进入的，根据栈的规则后入先出，操作最后一个数。
     * 压入时：优先入q队列，若help不为空，先优先入help队列（因为非空队列的值肯定是先进入的值）
     * 出栈时：将非空队列的数，先进先出的次序存入空队列，留下最后一个数，弹出最后一个数就是后入先出。
     * 查看时：将非空队列的数，先进先出的次序存入空队列，留下最后一个数，返回最后一个数的值，然后将最后一个数存入空队列（还原队列）。
     */
    static class MyStack {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> help = new LinkedList<>();


        /**
         * 压入
         */
        public void push(int n) {
            //优先存入q
            if (q.isEmpty() && help.isEmpty()) {
                q.add(n);
                return;
            }
            //如果q为空，help不为空，则存到help
            if (q.isEmpty()) {
                help.add(n);
            }
            //如果help为空，q不为空，则存到q
            if (help.isEmpty()) {
                q.add(n);
            }
        }

        /**
         * 弹出
         */
        public int pop() {
            //两个栈都为空，则没有元素可以弹出，抛异常
            if (q.isEmpty() && help.isEmpty()) {
                try {
                    throw new Exception("satck is empty!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {

                //如果q为空，help不为空，将help中元素依次放入q，并弹出
                if (q.isEmpty()) {
                    dao(help, q);
                    return help.poll();
                }

                //如果help为空，q不为空，将q中元素依次放入help，并弹出
                if (help.isEmpty()) {
                    dao(q, help);
                    return q.poll();
                }
            }
            return -1;
        }

        /**
         * 返回栈顶值，但不弹出
         */
        public int peek() {
            int res = 0;
            //两个栈都为空，则没有元素可以看，抛异常
            if (q.isEmpty() && help.isEmpty()) {
                try {
                    throw new Exception("satck is empty!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                //如果q为空，help不为空，将help中元素依次放入q，并返回
                if (q.isEmpty()) {
                    dao(help, q);
                    res = help.peek();
                    //将最后一个数还原队尾
                    q.add(help.poll());
                }

                //如果help为空，q不为空，将q中元素依次放入help，并返回
                if (help.isEmpty()) {
                    dao(q, help);
                    res = q.peek();
                    //将最后一个数还原队尾
                    help.add(q.poll());
                }
            }
            return res;
        }

        /**
         * q队列倒入help队列
         *
         * @param q    非空队列
         * @param help 空队列
         */
        private void dao(Queue<Integer> q, Queue<Integer> help) {
            while (q.size() > 1) {
                help.add(q.poll());
            }
        }


        @Override
        public String toString() {
            return "MyStack{" +
                    "q=" + q +
                    ", help=" + help +
                    '}';
        }
    }
}
