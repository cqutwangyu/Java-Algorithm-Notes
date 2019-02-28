package 算法题库;

import java.util.*;

/**
 * @ClassName 打开转盘锁
 * @Description 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。  锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。  列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。  字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。     示例 1:  输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202" 输出：6 解释： 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的， 因为当拨动到 "0102" 时这个锁就会被锁定。 示例 2:  输入: deadends = ["8888"], target = "0009" 输出：1 解释： 把最后一位反向旋转一次即可 "0000" -> "0009"。 示例 3:  输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888" 输出：-1 解释： 无法旋转到目标数字且不被锁定。 示例 4:  输入: deadends = ["0000"], target = "8888" 输出：-1    提示：  死亡列表 deadends 的长度范围为 [1, 500]。 目标数字 target 不会在 deadends 之中。 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
 * @Author ChongqingWangYu
 * @DateTime 2019/2/28 19:08
 * @GitHub https://github.com/ChongqingWangYu
 */
public class 打开转盘锁 {
    /**
     * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
     * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
     * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
     * 字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。
     * 示例 1:
     * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
     * 输出：6
     * 解释：
     * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
     * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
     * 因为当拨动到 "0102" 时这个锁就会被锁定。
     * 示例 2:
     * 输入: deadends = ["8888"], target = "0009"
     * 输出：1
     * 解释：
     * 把最后一位反向旋转一次即可 "0000" -> "0009"。
     * 示例 3:
     * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
     * 输出：-1
     * 解释：
     * 无法旋转到目标数字且不被锁定。
     * 示例 4:
     * 输入: deadends = ["0000"], target = "8888"
     * 输出：-1
     * 提示：
     * 死亡列表 deadends 的长度范围为 [1, 500]。
     * 目标数字 target 不会在 deadends 之中。
     * 每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
     *
     * @param args
     */
    public static void main(String[] args) {
//        String[] stirngs = {"0201", "0101", "0102", "1212", "2002"};
        String[] stirngs = {"8888"};
        String target = "0009";
        System.out.println(openLock(stirngs, target));
    }

    /**
     * 不熟悉BFS广度优先搜索算法，这题难度太大，查阅了资料https://blog.csdn.net/qq_27480345/article/details/86499958
     * 大神的代码真是难以理解，3个小时且查阅资料才勉强完成这道题，思路并不清晰。
     *
     * @param deadends
     * @param target
     * @return
     */
    public static int openLock(String[] deadends, String target) {
        List<String> list=Arrays.asList(deadends);
        if(list.contains("0000")){
            return -1;
        }
        // 队列存储等待处理的所有节点
        Queue<String> queue = new LinkedList<>();
        // 存储所有使用过的节点
        Set<String> used = new HashSet<>();
        // 从根节点到当前节点所需的步骤数
        int step = 0;
        // 初始化
        //向queue添加根
        queue.add("0000");
        //向used添加根
        used.add("0000");
        // BFS
        //queue不是空的
        while (!queue.isEmpty()) {
            // 迭代queue中已经存在的节点
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                //queue中的第一个节点
                String cur = queue.peek();
                //如果cur与target相同，则返回step
                if (cur.equals(target)) {
                    return step;
                }
                List<String> neighbors = arrCurByNeighbors(cur);
                //遍历cur的邻居
                for (String next : neighbors) {
                    //next不是使用过的
                    if (!used.contains(next)&&!list.contains(next)) {
                        //添加next到queue
                        queue.add(next);
                        //添加next到used
                        used.add(next);
                    }
                }
                System.out.println(queue.element());
                //删除queue中第一个节点
                queue.poll();
            }
            step++;
        }
        // 没有办法从root找到target
        return -1;
    }

    /**
     * @param cur
     * @return
     */
    private static List<String> arrCurByNeighbors(String cur) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < cur.length(); i++) {
            char ch = cur.charAt(i);

            char newCh = ch == '0' ? '9' : (char) (ch - 1);
            StringBuilder builder = new StringBuilder(cur);
            builder.setCharAt(i, newCh);
            list.add(builder.toString());

            newCh = ch == '9' ? '0' : (char) (ch + 1);
            builder = new StringBuilder(cur);
            builder.setCharAt(i, newCh);
            list.add(builder.toString());
        }
        return list;
    }

    /**
     * LeetCode最优解，大神的代码。
     * @param deadends
     * @param target
     * @return
     */
    public int openLock1(String[] deadends, String target) {
        boolean[] isVisit=new boolean[10000];
        boolean[] isDead=new boolean[10000];
        for (String deadEnd : deadends) {
            int deadNum = Integer.parseInt(deadEnd);
            isDead[deadNum] = true;
        }
        //如果"0000"在deadEnds中，返回-1
        if(isDead[0]) {
            return -1;
        }
        if("0000".equals(target)) {
            return 0;
        }

        int step=0;


        Queue<Integer> queue=new ArrayDeque<>();
        queue.offer(Integer.parseInt(target));
        isVisit[Integer.parseInt(target)]=true;
        int last=Integer.parseInt(target);
        int cenglast=last;
        while(!queue.isEmpty())
        {
            while(true)
            {
                int[] neighbor=new int[8];
                int head=queue.poll();
                if(head==0) {
                    return step;
                }
                int[] nei=neighbor(head);
                for(int i=0;i<8;i++)
                {
                    int trans=nei[i];
                    if(isVisit[trans] || isDead[trans]) {
                        continue;
                    }
                    queue.offer(trans);
                    last=trans;
                    isVisit[trans]=true;
                }
                if(head==cenglast) {
                    break;
                }
            }
            step++;
            cenglast=last;
        }
        return -1;


    }

    /**
     * LeetCode最优解，大神的代码。
     * @param code
     * @return
     */
    private int[] neighbor(int code)
    {
        int[] res=new int[8];
        int a=code%10;
        int b=(code/10)%10;
        int c=(code/100)%10;
        int d=(code/1000)%10;
        res[0]=d*1000+c*100+b*10+(a+10-1)%10;
        res[1]=d*1000+c*100+b*10+(a+1)%10;
        res[2]=d*1000+c*100+((b+10-1)%10)*10+a;
        res[3]=d*1000+c*100+((b+1)%10)*10+a;
        res[4]=d*1000+((c+10-1)%10)*100+b*10+a;
        res[5]=d*1000+((c+1)%10)*100+b*10+a;
        res[6]=((d+10-1)%10)*1000+c*100+b*10+a;
        res[7]=((d+1)%10)*1000+c*100+b*10+a;
        return res;
    }
}

