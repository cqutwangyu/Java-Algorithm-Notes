package 剑指offer;

import LeetCode.两数相加;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName 从尾到头打印链表
 * @Description 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 * @Author ChongqingWangYu
 * @DateTime 2019/3/19 20:33
 * @GitHub https://github.com/ChongqingWangYu
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
