package real;

import java.util.Stack;

/**
 * @ClassName 栈实现队列
 * @Description
 * @Author cqutwangyu
 * @DateTime 2019/3/26 21:15
 * @GitHub https://github.com/cqutwangyu
 */
public class 栈实现队列 {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.add(1);
        q.add(2);
        System.out.println("peek:" + q.peek());
        q.add(3);
        q.add(4);
        System.out.println(q.poll());
        System.out.println(q.poll());
        System.out.println("peek:" + q.peek());
        System.out.println(q.poll());
        System.out.println("peek:" + q.peek());
        System.out.println(q.poll());
    }

    /**
     * 使用两个栈实现队列，利用后进先出的规则，全部倒入另一个队列中再弹出，即可达成先进先出。
     * 弹出后，需将逆序的栈数据，再倒回原来的栈，以保持原来的队形，防止中途加入的数扰乱顺序。
     */
    static class MyQueue {
        Stack<Integer> s = new Stack<>();
        Stack<Integer> help = new Stack<>();

        public void add(int n) {
            if (s.isEmpty() && help.isEmpty()) {
                s.add(n);
                return;
            }
            if (s.isEmpty()) {
                help.add(n);
                return;
            }
            if (help.isEmpty()) {
                s.add(n);
            }
        }

        public int poll() {
            int res = -1;
            if (s.isEmpty() && help.isEmpty()) {
                try {
                    throw new Exception("queue is empty!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (s.isEmpty()) {
                dao(help, s);
                res = s.pop();
                dao(s, help);
            }
            if (help.isEmpty()) {
                dao(s, help);
                res = help.pop();
                dao(help, s);
            }
            return res;
        }

        public int peek() {
            int res = -1;
            if (s.isEmpty() && help.isEmpty()) {
                try {
                    throw new Exception("satck is empty!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                if (s.isEmpty()) {
                    dao(help, s);
                    res = s.peek();
                    dao(s, help);
                }
                if (help.isEmpty()) {
                    dao(s, help);
                    res = help.peek();
                    dao(help, s);
                }
            }
            return res;
        }

        /**
         * s倒入help
         *
         * @param s    非空栈
         * @param help 空栈
         */
        private void dao(Stack<Integer> s, Stack<Integer> help) {
            while (!s.isEmpty()) {
                help.add(s.pop());
            }
        }
    }
}
