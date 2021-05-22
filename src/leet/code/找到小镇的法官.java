package leet.code;

/**
 * @ClassName 找到小镇的法官
 * @Description 力扣第125场周赛主程序
 * @Author cqutwangyu
 * @DateTime 2019/2/24 10:18
 * @GitHub https://github.com/cqutwangyu
 */
public class 找到小镇的法官 {
    /**
     * 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
     *
     * 如果小镇的法官真的存在，那么：
     *
     * 1、小镇的法官不相信任何人。
     * 2、每个人（除了小镇法官外）都信任小镇的法官。
     * 3、只有一个人同时满足属性 1 和属性 2 。
     * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
     *
     * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
     * @param args
     */
    public static void main(String[] args) {
        int[][] trust={{1,2},{2,3}};
        System.out.println(findJudge(3,trust));
//        int[][] trust={{1,3},{1,4},{2,3},{2,4},{4,3}};
//        System.out.println(findJudge(4,trust));
    }
    //法官不信任任何人
    //任何人信任法官
    public static int findJudge(int N, int[][] trust) {
        //法官的下标
        int result=-1;
        int[] arr=new int[N];
        //是否不信任任何人
        boolean flag=false;
        for (int i = 1; i <=N ; i++) {
            flag=false;
            for (int j = 0; j <trust.length ; j++) {
                if(trust[j][0]==i){
                    flag=true;
                    break;
                }
            }
            if(!flag){
                result=i;
            }
        }
        int r;
        int count=0;
        //遍历所有信任对
        for (int i = 0; i <trust.length ; i++) {
            r=trust[i][1];
            if(r==result){
                //信任result的人数+1
                count++;
            }
        }
        //如果不是除了自己以外的所有人都信任result则不是法官
        if (count!=N-1){
            result=-1;
        }
        return result;
    }

}
