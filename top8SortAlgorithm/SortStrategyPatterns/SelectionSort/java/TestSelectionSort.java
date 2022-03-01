import java.util.Scanner;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/1 15:30
 * @description： SelectionSort 测试类
 * @modified By： Alascanfu
 **/
public class TestSelectionSort {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一连串需要进行排序的数字，数字之间用`,`隔开：");
        String str[] = sc.nextLine().split(",");
        int arr[] = new int [str.length];
        for (int i = 0 ; i< arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        SolutionSelectionSort solution = new SolutionSelectionSort();
        System.out.println("排序结果：");
        for (int i : solution.sort(arr)) {
            System.out.print(i+"\t");
        }
    }
}
