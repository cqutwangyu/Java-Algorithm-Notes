package sword.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName 从尾到头打印链表
 * @Description 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @Author cqutwangyu
 * @DateTime 2019/3/19 20:33
 * @GitHub https://github.com/cqutwangyu
 */
public class 从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(0);
        ListNode temp = listNode;
        for (int i = 1; i < 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        Solution solution = new Solution();
        ArrayList<Integer> integers = solution.printListFromTailToHead(listNode);
        System.out.println(integers.toString());
    }

    private static class Solution {
        ArrayList<Integer> list = new ArrayList<>();

        ArrayList<Integer> ret = new ArrayList<>();

        public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
            //如果当前节点不为空
            if (listNode != null) {
                //递归传入当前节点的next
                printListFromTailToHead(listNode.next);
                //当递归结束后以递归出栈顺序将值add到ArrayList。起到逆序的作用。
                ret.add(listNode.val);
            }
            return ret;
        }

        public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
            //头插法构建逆序链表
            ListNode head = new ListNode(-1);
            while (listNode != null) {
                //记录当前节点的next
                ListNode memo = listNode.next;
                //将当前节点的next指向head的next（从第二个节点开始就实现了逆序，指向了前一个节点）
                listNode.next = head.next;
                //head的next指向当前节点
                head.next = listNode;
                //listNode赋值为next,进入下一次循环
                listNode = memo;
            }
            //head的next开始为有效值
            head = head.next;
            //依次将链表值add到ArrayList中
            while (head != null) {
                ret.add(head.val);
                head = head.next;
            }
            return ret;
        }

        public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
            //创建一个栈
            Stack<Integer> stack = new Stack<>();
            //依次将链表的值压栈
            while (listNode != null) {
                stack.add(listNode.val);
                listNode = listNode.next;
            }
            ArrayList<Integer> ret = new ArrayList<>();
            //依次弹栈
            while (!stack.isEmpty()) {
                ret.add(stack.pop());
            }
            return ret;
        }

        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            //当链表存在下一个节点时，继续递归，直到下一个节点为空，则为最后一个节点，然后依次出栈形成逆序列表
            if (listNode != null) {
                this.printListFromTailToHead(listNode.next);
                list.add(listNode.val);
            }
            return list;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
