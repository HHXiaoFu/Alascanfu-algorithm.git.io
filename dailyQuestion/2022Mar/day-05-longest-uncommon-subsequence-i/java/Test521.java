import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/5 9:47
 * @description： Leetcode每日一题521.最长特殊序列1 测试类
 * @modified By： Alascanfu
 **/
public class Test521 {
    public static void main(String[] args)throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("请输入字符串a,和字符串b，中间由空格隔开：");
        String[] params = br.readLine().split(" ");
        String a = params[0];
        String b = params[1];
        System.out.println("最长特殊序列长度为：");
        System.out.println(new Solution521().findLUSlength(a,b));
    }
}
