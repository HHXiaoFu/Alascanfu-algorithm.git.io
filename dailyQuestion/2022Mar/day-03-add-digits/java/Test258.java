import java.util.Scanner;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/3 12:28
 * @description： LeetCode 每日一题. 258各位相加 2022/03/03 测试类
 * @modified By： Alascanfu
 **/
public class Test258 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字：");
        int num = sc.nextInt();
        System.out.println("它的各位之和一位数为：");
        System.out.println(new Solution258().addDigits(num));
    }
}
