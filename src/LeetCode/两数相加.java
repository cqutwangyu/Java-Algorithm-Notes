package LeetCode;

import java.math.BigInteger;

/**
 * @ClassName 两数相加
 * @Description 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。  示例：  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * @Author ChongqingWangYu
 * @DateTime 2019/2/25 13:35
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 两数相加 {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * 示例：
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public static void main(String[] args) {
        ListNode l1 = stringtolistnode("342");
        ListNode l2 = stringtolistnode("465");
        printListNode(l1);
        printListNode(l2);
        printListNode(addTwoNumbers(l1, l2));
    }

    /**
     * 输出ListNode链表中的值
     *
     * @param l1
     */
    private static void printListNode(ListNode l1) {
        ListNode temp = l1;
        System.out.print(temp.val);
        while ((temp = temp.next) != null) {
            System.out.print("->");
            System.out.print(temp.val);
        }
        System.out.println();
    }

    /**
     * 将String转换为ListNode链表
     *
     * @param str
     * @return
     */
    private static ListNode stringtolistnode(String str) {
        int n = str.length();
        ListNode temp = new ListNode(Integer.valueOf((str.substring(n - 1, n))));
        ListNode ln = temp;
        for (int i = n - 1; i > 0; i--) {
            temp.next = new ListNode(Integer.valueOf((str.substring(i - 1, i))));
            temp = temp.next;
        }
        return ln;
    }

    /**
     * 将两个链表的值相加，并以链表形式返回结果。
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode temp;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append(l1.val);
        sb2.append(l2.val);
        temp = l1.next;
        while (temp != null) {
            sb1.append(temp.val);
            temp = temp.next;
        }
        temp = l2.next;
        while (temp != null) {
            sb2.append(temp.val);
            temp = temp.next;
        }
        BigInteger b1 = new BigInteger(sb1.reverse().toString());
        BigInteger b2 = new BigInteger(sb2.reverse().toString());
        BigInteger num = b1.add(b2);
        listNode = stringtolistnode(num.toString());
        return listNode;
    }

    /**
     * 链表结构
     */
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * LeetCode大神耗时最短的解法，复制下来并尝试理解。
     *
     * @param l1
     * @param l2
     * @return
     */
    private ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        //临时链表
        ListNode temp = new ListNode(0);
        //最终返回的链表
        ListNode head = temp;
        //临时存放l1
        ListNode temp1 = l1;
        //临时存放l2
        ListNode temp2 = l2;
        //满十进一时临时存放值的变量
        int iOver10 = 0;
        //一边循环读取l1和l2的val，一边计算两数之和，一边形成最终结果链表。节省时间，减少循环次数，减少资源消耗。真大神！
        while (temp1 != null || temp2 != null) {
            //临时存放val1加val2的和
            ListNode temp3 = new ListNode(0);
            //存放l1的val，空则为0
            int val1 = temp1 == null ? 0 : temp1.val;
            //存放l2的val，空则为0
            int val2 = temp2 == null ? 0 : temp2.val;
            //将l1和l2的val相加，并满十进一
            int sum = val1 + val2 + iOver10;
            //是否满十，满十进一
            if (sum >= 10) {
                temp3.val = sum - 10;
                iOver10 = 1;
            } else {
                temp3.val = sum;
                iOver10 = 0;
            }

            //将计算结果临时存放在temp.next中，并使temp指向temp.next;
            temp.next = temp3;
            //下面这行代码等同于temp = temp.next;
            temp = temp3;
            //l1的next是否为空，不为空则指向next，为空则赋值为null
            temp1 = temp1 == null ? null : temp1.next;
            //l2的next是否为空，不为空则指向next，为空则赋值为null
            temp2 = temp2 == null ? null : temp2.next;
        }

        //如果有满十未进的值，则增加一个节点并赋值为1
        if (iOver10 == 1) {
            ListNode temp3 = new ListNode(1);
            temp.next = temp3;
            temp = temp3;
        }
        //返回head.next的原因是head.val=0，真正有效值从head.next开始
        return head.next;
    }
}
