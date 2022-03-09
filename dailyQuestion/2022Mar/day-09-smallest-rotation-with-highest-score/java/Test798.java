import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/9 16:40
 * @description： Leetcode每日一题 798. 得分最高的最小轮调 2022/03/09 测试类
 * @modified By： Alascanfu
 **/
public class Test798 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("请输入一串数字构成数组中，数字之间由`，`隔开：");
        String[] params = br.readLine().split(",");
        int[] nums = new int[params.length];
        if(params.length > 1e5)throw new RuntimeException("请输入合理的范围的数字的个数");
        for (int i = 0 ; i< nums.length;i++){
            nums[i] = Integer.parseInt(params[i]);
            if (nums[i] >= nums.length)throw new RuntimeException("您输入的数值必须在 0 <= nums[i] < nums.length 的区间");
        }
        System.out.println("得分最高的最小论调为：");
        System.out.println(new Solution798().bestRotation(nums));
    }
}
