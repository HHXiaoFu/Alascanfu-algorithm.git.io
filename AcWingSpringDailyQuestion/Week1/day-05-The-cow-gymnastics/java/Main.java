import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/19 13:15
 * @description： AcWing春季打卡活动—— 1459奶牛体操
 * @modified By： Alascanfu
 **/
class Main1459 {
    static int K = 12;
    static int N = 22;
    static int[][] p ;
    
    static void init(){
        p = new int[K][N];
    }
    
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] params = br.readLine().split(" ");
        init();
        int m = Integer.parseInt(params[0]);
        int n = Integer.parseInt(params[1]);
        
        for (int i = 1; i<=m ;i++){
            String[] paramsNum = br.readLine().split(" ");
            for (int j = 1;j<=n;j++){
                // 获取处于当前位置的元素
                int x = Integer.parseInt(paramsNum[j-1]);
                // 将数据当前位置标记在数组中
                // 表示的是第 i 行 中的 x元素的位置为 j
                p[i][x] = j;
            }
        }
        
        int res = 0 ;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=n;j++){
                // 没有元素对相对位置进行交换
                boolean flag = true;
                for (int k = 1;k<=m;k++){
                    // 如果当前i元素的位置处于j元素的位置之后则说明数对交换了，就不能满足条件了
                    if (p[k][i] >= p[k][j])flag = false;
                }
                if (flag)res++;
            }
        }
        System.out.print(res);
    }
}
