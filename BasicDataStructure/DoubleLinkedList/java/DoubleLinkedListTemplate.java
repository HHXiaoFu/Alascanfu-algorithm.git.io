import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/25 20:11
 * @description： DoubleLinkedListTemplate
 * @modified By： Alascanfu
 **/
public class DoubleLinkedListTemplate {
    static int N = 100010;
    static int[] e , l , r ;
    static int idx ;
    
    /**
     * 功能描述
     * 初始化双向链表结构 其中 0 代表 head 节点 1 代表 tail 节点
     * r[0] = 1 代表 head 的右节点为 tail 节点
     * l[1] = 0 代表 tail 的左节点为 head 节点
     * @date 2022/4/25
     * @author Alascanfu
     */
    static void init() {
        e = new int[N] ;
        l = new int[N] ;
        r = new int[N] ;
        r[0] = 1;
        l[1] = 0;
        idx = 2 ;
    }
    
    /**
     * 功能描述
     * 在下标为 k 的节点的右侧添加一个值为 val 的节点
     * @date 2022/4/25
     * @author Alascanfu
     */
    static void insertToRight(int k , int val){
        e[idx] = val;
        r[idx] = r[k];
        l[idx] = k;
        l[r[k]] = idx;
        r[k] = idx++;
    }
    
    /**
     * 功能描述
     * 删除第 k个节点
     * @date 2022/4/25
     * @author Alascanfu
     */
    static void delete(int k ){
        r[l[k]] = r[k];
        l[r[k]] = l[k];
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        int m =Integer.parseInt(br.readLine());
        while (m -- > 0){
            String[] params = br.readLine().split(" ");
            String operation = params[0];
            if (operation.equals("L")){
                int x = Integer.parseInt(params[1]);
                insertToRight(0,x);
            }else if (operation.equals("R")){
                int x = Integer.parseInt(params[1]);
                insertToRight(l[1],x);
            }else if (operation.equals("D")){
                int k = Integer.parseInt(params[1]);
                delete(k + 1);
            }else if (operation.equals("IL")){
                int k = Integer.parseInt(params[1]);
                int x = Integer.parseInt(params[2]);
                insertToRight(l[k+1],x);
            }else if (operation.equals("IR")){
                int k = Integer.parseInt(params[1]);
                int x = Integer.parseInt(params[2]);
                insertToRight(k+1,x);
            }
        }
        for (int i = r[0] ;i != 1 ;i = r[i]){
            System.out.print(e[i] + " ");
        }
    }
}
