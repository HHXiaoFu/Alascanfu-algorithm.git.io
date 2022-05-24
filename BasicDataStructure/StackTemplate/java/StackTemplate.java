import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/26 18:38
 * @description： StackTemplate
 * @modified By： Alascanfu
 **/
public class StackTemplate {
    static int N = 100010;
    static int[] stk ;
    static int top ;
    
    /**
     * 功能描述
     * 栈的初始化
     * @date 2022/4/26
     * @author Alascanfu
     */
    static void init() {
        stk = new int[N];
        top = 0 ;
    }
    
    /**
     * 功能描述
     * 入栈操作
     * @date 2022/4/26
     * @author Alascanfu
     */
    static void push(int x){
        stk[++top] = x;
    }
    
    /**
     * 功能描述
     * 弹出元素操作
     * @date 2022/4/26
     * @author Alascanfu
     */
    static void pop(){
        top--;
    }
    
    /**
     * 功能描述
     * 判断栈是否为空
     * @date 2022/4/26
     * @author Alascanfu
     */
    static void empty(){
        if (top > 0){
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }
    }
    
    /**
     * 功能描述
     * 查询栈顶元素
     * @date 2022/4/26
     * @author Alascanfu
     */
    static void query(){
        System.out.println(stk[top]);
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        int m = Integer.parseInt(br.readLine());
        while (m -- > 0){
            String[] params = br.readLine().split(" ");
            String operate = params[0];
            if (operate.equals("push")){
                int x = Integer.parseInt(params[1]);
                push(x);
            }else if (operate.equals("pop")){
                pop();
            }else if (operate.equals("empty")){
                empty();
            }else if (operate.equals("query")){
                query();
            }
        }
    }
}
