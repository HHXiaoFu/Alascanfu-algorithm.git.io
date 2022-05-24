import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/27 17:41
 * @description： CircleQueueTemplate
 * @modified By： Alascanfu
 **/
public class CircleQueueTemplate {
    static int N = 100010;
    static int[] q ;
    static int head ,tail;
    
    // 初始化队列
    static void init() {
        q = new int[N];
        head = 0;
        tail = 0 ;
    }
    // 往队尾插入元素
    static void push(int x){
        q[tail++] = x;
        // 到达末尾此时 tail 指向 0
        if (tail == N){
            tail = 0 ;
        }
    }
    // 队首元素弹出
    static void pop(){
        head++;
        // 到达末尾此时 head指向 0
        if (head == N){
            head = 0;
        }
    }
    // 判断当前队列是否为空
    static void empty(){
        if (head != tail){
            System.out.println("NO");
        }else {
            System.out.println("YES");
        }
    }
    // 返回队首元素
    static void query(){
        System.out.println(q[head]);
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
