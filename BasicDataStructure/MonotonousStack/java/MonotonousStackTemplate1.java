import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/27 17:51
 * @description： Monotonous stack
 * @modified By： Alascanfu
 **/
public class MonotonousStackTemplate1 {
    
    static void init() {
    
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
    
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < n ; i ++){
            while (!stack.isEmpty() && nums[i] <= stack.peek()){
                stack.pop();
            }
            if (!stack.isEmpty()) System.out.print(stack.peek());
            else System.out.print("-1 ");
            stack.add(nums[i]);
        }
    }
}
