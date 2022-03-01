import java.util.Scanner;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 15:30
 * @description： ShellSort 测试类
 * @modified By： Alascanfu
 **/
public class TestShellSort {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一连串需要进行排序的数字，数字之间用`,`隔开：");
        String str[] = sc.nextLine().split(",");
        int arr[] = new int [str.length];
        for (int i = 0 ; i< arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        SolutionShellSort solution = new SolutionShellSort();
        System.out.println("排序结果：");
        for (int i : solution.sort(arr)) {
            System.out.print(i+"\t");
        }
    }
}
