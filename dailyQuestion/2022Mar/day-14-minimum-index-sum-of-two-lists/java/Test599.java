import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/14 16:33
 * @description： Leetcode 每日一题 599.两个列表的最小索引和 2022/03/14
 * @modified By： Alascanfu
 **/
public class Test599 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("请输入Andy最爱的餐厅列表，餐厅名之间用,隔开：");
        String[] list1 = br.readLine().split(",");
        System.out.println("请输入Doris最爱的餐厅列表，餐厅名之间用,隔开：");
        String[] list2 = br.readLine().split(",");
        System.out.println("他们共同喜爱的最小索引和餐厅为：");
        System.out.println(Arrays.toString(new Solution599().findRestaurant(list1, list2)));
    }
}
