package real;

import AlgorithmBased.MySort;

/**
 * @ClassName 链表的荷兰国旗问题
 * @Description
 * @Author cqutwangyu
 * @DateTime 2019/4/1 21:06
 * @GitHub https://github.com/cqutwangyu
 */
public class 链表的荷兰国旗问题 {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 0};
        Node head = createLinkdList(arr);
        printLinkeList(head);
        int pivot = 2;
        head = listPartition2(head, pivot);
        printLinkeList(head);
    }


    /**
     * 第一种方法，使用额外数组partition
     * 空间复杂度O(n)
     */
    public static Node listPartition1(Node head, int pivot) {
        if (head == null) {
            return head;
        }
        Node cur = head;
        //得出链表的长度
        int i = 0;
        while (cur != null) {
            i++;
            cur = cur.next;
        }
        //将链表的节点存入数组
        Node[] nodeArr = new Node[i];
        cur = head;
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        //排序
        arrPartition(nodeArr, pivot);
        //将数组中的节点连起来
        for (i = 1; i != nodeArr.length; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        //最后一个节点指向空
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }

    private static void arrPartition(Node[] nodeArr, int pivot) {
        int small = -1;
        int big = nodeArr.length;
        int index = 0;
        while (index != big) {
            if (nodeArr[index].value < pivot) {
                MySort.swap(nodeArr, ++small, index++);
            } else if (nodeArr[index].value == pivot) {
                index++;
            } else {
                MySort.swap(nodeArr, --big, index);
            }
        }
    }

    /**
     * 第二种方法，使用Node变量来控制三个区域的头和尾
     * 空间复杂度O(1)
     */
    public static Node listPartition2(Node head, int pivot) {
        //小值区域的头尾
        Node sH = null, sT = null;
        //等值区域的头尾
        Node eH = null, eT = null;
        //大值区域的头尾
        Node bH = null, bT = null;
        //保存下一个node
        Node next = null;
        //每个节点分布到三个列表
        while (head != null) {
            //5(head)->3(next)->2->1->0 保存下一个节点
            next = head.next;
            //5(head)->3(next)  2->1->0 当前节点的next指向空
            head.next = null;
            //如果小于枢轴
            if (head.value < pivot) {
                //如果小区域的头为空
                if (sH == null) {
                    //将当前节点设为小区域的头和尾
                    sH = head;
                    sT = head;
                } else {
                    //如果小区域的头不为空
                    //将当前节点添加到小区域的尾部
                    sT.next = head;
                    sT = head;
                }
            } else if (head.value == pivot) {
                //如果等于枢轴
                //如果等于区域的头为空
                if (eH == null) {
                    //将当前节点设为等于区域的头和尾
                    eH = head;
                    eT = head;
                } else {
                    //如果等于区域的头不为空
                    //将当前节点添加到等于区域的尾部
                    eT.next = head;
                    eT = head;
                }
            } else {
                //否则为大于枢轴
                //如果大于区域的头为空
                if (bH == null) {
                    //当前节点设为大于区域的头和尾
                    bH = head;
                    bT = head;
                } else {
                    //如果大于区域不为空
                    //将当前节点添加到大于区域的尾部
                    bT.next = head;
                    bT = head;
                }
            }
            //指针后移
            head = next;
        }
        //小值区域和等值区域连接
        if (sT != null) {
            sT.next = eH;
            eT = eT == null ? sT : eT;
        }
        //所有区域连接
        if (eT != null) {
            eT.next = bH;
        }
        //如果小区域的头不为空
        if (sH != null) {
            //返回小区域的头结点
            return sH;
        } else if (eH != null) {
            //否则如果等于区域的头结点不为空
            //返回等于区域的头结点
            return eH;
        } else {
            //否则返回大于区域的头结点
            return bH;
        }
        //简写如下
//        return sH != null ? sH : eH != null ? eH : bH;
    }

    /**
     * 随机生成随机链表
     */
    private static Node generateList(int lenght, int maxValue) {
        Node head = new Node((int) ((maxValue + 1) * Math.random()));
        Node temp = head;
        for (int i = 0; i < lenght - 1; i++) {
            temp.next = new Node((int) ((maxValue + 1) * Math.random()));
            temp = temp.next;
        }
        return head;
    }

    /**
     * 根据数组生成链表
     */
    private static Node createLinkdList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    /**
     * 输出链表
     */
    private static void printLinkeList(Node head) {
        Node temp = head;
        System.out.print("Linked List:");
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
