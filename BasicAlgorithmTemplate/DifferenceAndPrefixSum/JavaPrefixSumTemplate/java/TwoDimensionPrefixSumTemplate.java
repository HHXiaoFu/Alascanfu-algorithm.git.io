import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/20 13:25
 * @description： two-dimension 二维前缀和公式递推
 * @modified By： Alascanfu
 **/
class TwoDimensionPrefixSumTemplate {
    static int N = 1010;
    static int[][] S ;
    static int[][] a ;
    
    static void init(){
        S = new int[N][N];
        a = new int[N][N];
    }
    public static void main(String[] args)throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        String[] params1 = br.readLine().split(" ");
        int n = Integer.parseInt(params1[0]);
        int m = Integer.parseInt(params1[1]);
        int q = Integer.parseInt(params1[2]);
        
        for (int i = 1;i<=n;i++){
            String[] params2 = br.readLine().split(" ");
            for (int j = 1;j<=m;j++){
                a[i][j] = Integer.parseInt(params2[j-1]);
            }
        }
        
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=m;j++){
                S[i][j] = S[i-1][j] + S[i][j-1] - S[i-1][j-1] + a[i][j];
            }
        }
        
        while (q-- > 0){
            String[] params3 = br.readLine().split(" ");
            int x1 = Integer.parseInt(params3[0]);
            int y1 = Integer.parseInt(params3[1]);
            int x2 = Integer.parseInt(params3[2]);
            int y2 = Integer.parseInt(params3[3]);
    
            System.out.println(S[x2][y2] - S[x1-1][y2] - S[x2][y1-1] + S[x1-1][y1-1]);
        }
    }
}
