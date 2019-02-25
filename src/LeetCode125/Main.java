package LeetCode125;

/**
 * @ClassName Main
 * @Description 力扣第125场周赛主程序
 * @Author ChongqingWangYu
 * @DateTime 2019/2/24 10:18
 * @GitHub https://github.com/ChongqingWangYu
 */
public class Main {
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
