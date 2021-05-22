package real;

import java.util.Arrays;

/**
 * @ClassName 特殊的栈
 * @Description 普通栈基础上实现随时返回栈中最小值，pop、push、getMin的时间复杂度都要求为O(1)
 * @Author cqutwangyu
 * @DateTime 2019/3/26 20:25
 * @GitHub https://github.com/cqutwangyu
 */
public class 特殊的栈 {
    public static void main(String[] args) {
        SpecialStack s = new SpecialStack(10);
        s.push(5);
        s.push(9);
        s.push(4);
        s.push(7);
        s.push(8);
        s.push(3);
        s.push(4);
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
        System.out.println("pop:" + s.pop());
    }

    static class SpecialStack {
        int[] arr;
        int[] min;
        int stackTop = 0;

        public SpecialStack(int initSize) {
            arr = new int[initSize];
            min = new int[initSize];
        }

        public int pop() {
            System.out.println(toString());
            if (stackTop == 0) {
                throw new RuntimeException("栈空");
            }
            return arr[--stackTop];
        }

        public void push(int num) {
            if (stackTop >= arr.length) {
                throw new RuntimeException("栈指针溢出");
            }
            arr[stackTop] = num;
            pushMin(num);
            stackTop++;
        }

        public int getMin() {
            if (stackTop > 0) {
                return min[stackTop - 1];
            }
            return -1;
        }

        private void pushMin(int num) {
            if (stackTop > 0) {
                if (num < min[stackTop - 1]) {
                    min[stackTop] = num;
                } else {
                    min[stackTop] = min[stackTop - 1];
                }
            } else {
                min[stackTop] = num;
            }
        }

        @Override
        public String toString() {
            return "SpecialStack{\n" +
                    "arr=" + Arrays.toString(arr) +
                    ",\nmin=" + Arrays.toString(min) +
                    ",\nstackTop=" + stackTop +
                    ",min=" + getMin() + '}';
        }
    }

}
