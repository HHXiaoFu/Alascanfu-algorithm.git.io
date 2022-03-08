import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/8 17:12
 * @description： Leetcode 每日一题 2055.蜡烛的盘子个数测试类
 * @modified By： Alascanfu
 **/
public class Test2055 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
    
        String s = br.readLine();
        
        System.out.println(Arrays.toString(new Solution2055().platesBetweenCandles(s, new int[][]{{2, 5}, {5, 9}})));
    }
}
