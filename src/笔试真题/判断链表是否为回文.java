package 笔试真题;

import java.util.Stack;

/**
 * @ClassName 判断链表是否为回文
 * @Description 判断链表是否为回文（数字是否相等）
 * @Author ChongqingWangYu
 * @DateTime 2019/3/31 16:13
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 判断链表是否为回文 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 2, 1};
        Node head = createList(arr);
        System.out.println(isPalindrome1(head));
    }

    /**
     * 压栈法
     * 时间复杂度O(n) 空间复杂度O(n)
     */
    private static boolean isPalindrome1(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node car = head;
        //压栈
        while (car != null) {
            stack.push(car.value);
            car = car.next;
        }
        //比较
        while (head != null) {
            if (head.value != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 折半压栈法
     * 空间复杂度O(n/2)
     */
    private static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;
        //当cur走完，right走到一半
        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Integer> stack = new Stack<>();
        //压栈
        while (right != null) {
            stack.push(right.value);
            right = right.next;
        }
        //比较
        while (!stack.isEmpty()) {
            if (head.value != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 改变指针法 1(n2)->2->3<-2<-1(n1) 对n2和n1进行比对，最后还原指针
     * 时间复杂度O(1) 空间复杂度O(1)
     */
    private static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        //两个指针
        Node n1 = head;
        Node n2 = head;
        //n1每次走一步，n2每次走两步。当n2走完，n1刚好走到mid
        while (n2.next != null && n2.next.next != null) {
            //n1->mid
            n1 = n1.next;
            //n2->end
            n2 = n2.next.next;
        }
        //n2 = mid.next
        n2 = n1.next;
        //mid.next = null
        n1.next = null;
        //temp
        Node n3 = null;
        //逆指针
        while (n2 != null) {
            //存放n2.next
            n3 = n2.next;
            //n2指针逆向 n1<-n2.next
            n2.next = n1;
            //n1代表的是上一个节点，将n2做为n3的上一个节点
            n1 = n2;
            //准备对n3进行指针逆向 n2<-n3.next
            n2 = n3;
            //12321举例最终结果为 1->2->3<-2<-1
        }
        //保存最后一个节点
        n3 = n1;
        //指向根节点
        n2 = head;
        boolean res = true;
        //检查回文
        //n1为最后一个节点，n2为第一个节点
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            //n1.next指向下一个节点
            n1 = n1.next;
            //n2.next指向上一个节点
            n2 = n2.next;
            //mid.next指向null
        }
        //n1 = end.next 由于mid后面的节点被逆序 1->2->3<-2<-1 ，所以最后一个节点指向倒数第二个节点
        //n1 = 2(倒数第二个节点)
        n1 = n3.next;
        //n3 = 1(最后一个节点)
        //1->2->3<-2  1->null 最后一个节点指向空
        n3.next = null;
        //恢复链表1->2->3->2->1
        while (n1 != null) {
            //n2 = 3 1->2->3(n2)<-2(n1)  1(n3) 保存倒数第三个节点 (当n1为mid时，n2==null，即当前循环为最后一次循环)
            n2 = n1.next;
            //1->2->3(n2)<-2(n1)  1(n3) 当前指针情况
            //====恢复方向====
            //1->2->3(n2)  2(n1)->1(n3) 倒数第二个节点指向最后一个节点
            n1.next = n3;
            //1->2->3(n2)  2(n3)->1  n3 = 2 倒数第二个节点变为最后一个节点
            n3 = n1;
            //1->2->3(n1)  2(n3)->1  n3 = 2 倒数第二个节点变为最后一个节点
            n1 = n2;
        }
        return res;
    }

    /**
     * 根据数组构造链表并返回根节点
     */
    private static Node createList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node root = new Node(arr[0]);
        Node temp = root;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return root;
    }

    /**
     * 链表节点
     */
    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

    }
}
