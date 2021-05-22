package real;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 奇特的栈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.next());
        String cmd = "";
        Node node = new Node();
        while (n >= 0) {
            n--;
            cmd = sc.nextLine();
            String[] s = cmd.split(" ");
//            System.out.println(Arrays.toString(s));
            switch (s[0]) {
                case "push":
                    node.push(Integer.valueOf(s[1]));
                    break;

                case "pop":
                    node.pop();
                    break;

                case "delete":
                    node.delete(Integer.valueOf(s[1]));
                    break;
                case "query":
                    int query = node.query();
                    System.out.println(query);
                    break;

                default:
                    break;
            }

        }
    }

    private static class Node {
        List<Integer> list = new ArrayList<>();

        //1、push v 表示把v元素压入栈中。
        public void push(int v) {
            list.add(v);
        }

        //2. pop 表示弹出当前的栈顶元素，如果栈空则无操作。
        public void pop() {
            if (!list.isEmpty()) {
                list.remove(list.size() - 1);
            }
        }

        //3. delete v 表示删除距离栈顶最近的v元素，如果不存在v，则不删除。
        public void delete(int v) {
            if (!list.contains(v)) {
                return;
            }
            for (int i = list.size() - 1; i >= 0; i--) {
                if (list.get(i) == v) {
                    list.remove(i);
                    return;
                }
            }
        }

        //4. query 询问栈顶元素的大小，如果栈为空，输出0。
        public int query() {
            if (list.isEmpty()) {
                return 0;
            } else {
                return list.get(list.size() - 1);
            }
        }

    }
}
