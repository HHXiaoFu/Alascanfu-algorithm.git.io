import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/7 12:15
 * @description： LeetCode每日一题 2100.适合打劫银行的日子 测试类
 * @modified By： Alascanfu
 **/
public class Test2100 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("请输入security数组中保安的个数中间由空格隔开：");
        String[] params = br.readLine().split(" ");
        int[] security = new int[params.length];
        for (int i = 0; i < params.length; i++) security[i] = Integer.parseInt(params[i]);
        System.out.println("请输入一个time，满足条件:");
        int time = Integer.parseInt(br.readLine());
        System.out.println("适合打劫银行的日子：");
        System.out.println(new Solution2100().goodDaysToRobBank(security, time));
    }
}
