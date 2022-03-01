import java.util.Scanner;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 14:38
 * @description： Leetcode每日一题——6.Z字形变换 测试类
 * @modified By： Alascanfu
 **/
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入numRows:");
        int numRows = sc.nextInt();
        sc.nextLine();
        System.out.println("请输入需要进行变换的字符串：");
        String s = sc.nextLine();
        Solution6 solution = new Solution6();
        System.out.println(solution.convert(s,numRows));
    }
}
