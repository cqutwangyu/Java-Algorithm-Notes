package Test;

/**
 * @ClassName Test
 * @Description
 * @Author ChongqingWangYu
 * @DateTime 2019/3/12 22:27
 * @GitHub https://github.com/ChongqingWangYu
 */
public class Test {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
        sb.append(" a b c d ");
        for (int i = 0; i < sb.length(); i++) {
            if (sb.substring(i, i + 1).equals(" ")) {
                sb.delete(i, i + 1);
                sb.insert(i, "%20");
            }
        }
        System.out.println(sb.toString());
    }
}
