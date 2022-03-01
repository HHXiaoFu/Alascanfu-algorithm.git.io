import java.util.Scanner;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 23:04
 * @description： TestDuplicateNumberInArray 测试类
 * @modified By： Alascanfu
 **/
public class TestDuplicateNumberInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串数字中间由`,`隔开:");
        String[] str = sc.nextLine().split(",");
        int[] arr = new int[str.length];
        for (int i = 0;i< str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.println("重复的数字是：");
        System.out.println(new SolutionDuplicateNumberInArray().findRepeatNumber(arr));
    }
}
