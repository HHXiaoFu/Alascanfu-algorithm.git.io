import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/17 20:40
 * @description： Leetcode 每日一题 720词典中的最长单词 测试类
 * @modified By： Alascanfu
 **/
public class Test720 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        System.out.println("请输入一系列字符串中间由,隔开：");
        String[] words = br.readLine().split(",");
        System.out.println("词典中最长的单词为：");
        System.out.println(new Solution720().longestWord(words));
    }
}
