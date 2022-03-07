import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/7 12:40
 * @description： LeetCode 每日一题 504 7进制数 2022/03/07 测试类
 * @modified By： Alascanfu
 **/
public class Test504 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("请输入一个数字：");
        int num = Integer.parseInt(br.readLine());
        System.out.println("其7进制表示为：");
        System.out.println(new Solution504().convertToBase7(num));
    }
}
