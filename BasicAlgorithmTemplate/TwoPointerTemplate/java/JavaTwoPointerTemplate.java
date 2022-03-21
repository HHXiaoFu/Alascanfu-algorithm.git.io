import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/21 21:32
 * @description： 双指针模板
 * @modified By： Alascanfu
 **/
public class JavaTwoPointerTemplate {
    
    static int N = 100010;
    static int[] a, s;
    
    static void init() {
        a = new int[N];
        s = new int[N];
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        
        int n = Integer.parseInt(br.readLine());
        String[] params = br.readLine().split(" ");
        int res = 0;
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(params[i - 1]);
        }
        
        for (int i = 1, j = 1; i <= n; i++) {
            // 将当前出现的数字数量+1
            s[a[i]]++;
            // 如果当前字符出现的数目>1则说明[j,i]区间内有重复元素，则需要将指针位置后移直至当前[j,i]区间中没有重复元素。
            while (s[a[i]] > 1) {
                s[a[j]]--;
                j++;
            }
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);
    }
}
