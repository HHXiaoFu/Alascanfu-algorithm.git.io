import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/5 14:17
 * @description： Acwing 789.数的范围
 * @modified By： Alascanfu
 **/
public class ScopeOfNum {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        String[] params1 = br.readLine().split(" ");
        int n = Integer.parseInt(params1[0]);
        int q = Integer.parseInt(params1[1]);
        
        String[] params2 = br.readLine().split(" ");
        int[] nums =new int[n];
        for (int i = 0 ; i< n ; i++){
            nums[i] = Integer.parseInt(params2[i]);
        }
        
        while (q-- > 0){
            int x = Integer.parseInt(br.readLine());
            int l = 0;
            int r = n - 1;
            while (l < r){
                int mid = l + r >> 1;
                if (nums[mid] >= x)r = mid;
                else l = mid + 1;
            }
            if (nums[l] != x) System.out.println("-1 -1");
            else {
                System.out.print(l);
                l = 0 ;
                r = n-1;
                while (l < r){
                    int mid = l + r + 1 >> 1;
                    if (nums[mid] <= x)l = mid;
                    else r = mid - 1;
                }
                System.out.println(" "+l);
            }
        }
        
    }
}
