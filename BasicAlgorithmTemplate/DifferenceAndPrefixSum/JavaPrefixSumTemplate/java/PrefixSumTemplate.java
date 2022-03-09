import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/9 23:32
 * @description： PrefixSumTemplate
 * @modified By： Alascanfu
 **/
public class PrefixSumTemplate {
    public static void main(String[] args)throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[]params1 = br.readLine().split(" ");
        int n = Integer.parseInt(params1[0]);
        int m = Integer.parseInt(params1[1]);
        int[]nums = new int[n+1];
        String[] params2 = br.readLine().split(" ");
        int[] prefix = new int[n+1];
        prefix[0] = 0;
        for (int i = 1;i <= n;i++){
            nums[i] = Integer.parseInt(params2[i-1]);
        }
        
        for (int i = 1 ;i<=n;i++){
            prefix[i] = prefix[i-1] + nums[i];
        }
        
        while (m > 0 ){
            String[] params3 = br.readLine().split(" ");
            int l = Integer.parseInt(params3[0]);
            int r = Integer.parseInt(params3[1]);
            int sum = prefix[r] - prefix[l-1];
            System.out.println(sum);
            m--;
        }
        
    }
}
