import java.util.Scanner;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/2 17:18
 * @description： LeetCode 每日一题——564.寻找最近回文串
 * @modified By： Alascanfu
 **/
public class Test564 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串数字：");
        String n = sc.nextLine();
        System.out.println("它的最近回文串为:");
        System.out.println(new Solution564().nearestPalindromic(n));
    }
}
