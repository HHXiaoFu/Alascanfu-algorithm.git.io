import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/27 20:40
 * @description： MonotonousStackTemplate2
 * @modified By： Alascanfu
 **/
public class MonotonousStackTemplate2 {
    static int N = 100010;
    static int [] stk ;
    static int top ;
    static void init() {
        stk = new int[N];
        top = 0;
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        int n = Integer.parseInt(br.readLine());
        String[] params = br.readLine().split(" ");
        int [] nums = new int[n];
        for (int i = 0 ; i < n;i++){
            nums[i] = Integer.parseInt(params[i]);
        }
        for (int i = 0 ; i < n ; i++){
            while(top > 0 && stk[top] >= nums[i]){
                top--;
            }
            if (top > 0 ){
                System.out.print(stk[top] + " ");
            }else System.out.print("-1 ");
            stk[++top] = nums[i];
        }
    }
}
