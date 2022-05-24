import java.util.Scanner;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/14 11:33
 * @description： HeapSort 测试类
 * @modified By： Alascanfu
 **/
public class TestHeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一连串需要进行排序的数字，数字之间用`,`隔开：");
        String str[] = sc.nextLine().split(",");
        int arr[] = new int [str.length];
        for (int i = 0 ; i< arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        SolutionHeapSort solution = new SolutionHeapSort();
        System.out.println("排序结果：");
        for (int i : solution.sort(arr)) {
            System.out.print(i+"\t");
        }
    }
}
