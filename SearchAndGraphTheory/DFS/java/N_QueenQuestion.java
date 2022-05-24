import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/14 13:53
 * @description： N_QueenQuestion
 * @modified By： Alascanfu
 **/
public class N_QueenQuestion {
    
    static char[][] cs;
    static boolean[] col, dg, udg;
    
    static void init(int n) {
        cs = new char[n][n];
        col = new boolean[n];
        dg = new boolean[2 * n];
        udg = new boolean[2 * n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cs[i][j] = '.';
            }
        }
    }
    
    static void dfs(int n, int i) {
        if (i == n) {
            for (int k = 0; k < n; k++) {
                System.out.println(cs[k]);
            }
            System.out.println();
            return;
        }
        
        for (int j = 0; j < n; j++) {
            if (!col[j] && !dg[i + j] && !udg[j - i + n]) {
                col[j] = dg[i + j] = udg[j - i + n] = true;
                cs[i][j] = 'Q';
                dfs(n, i + 1);
                col[j] = dg[i + j] = udg[j - i + n] = false;
                cs[i][j] = '.';
            }
        }
        
    }
    
    public static void main(String[] args) throws  IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int n = Integer.parseInt(br.readLine());
        init(n);
        dfs(n, 0);
    }
}

class N_QueenQuestion_1{
    static char[][] cs;
    static boolean[] col , row , dg , udg ;
    
    static void init(int n ){
        cs = new char[n][n];
        col = new boolean[n];
        row = new boolean[n];
        dg  = new boolean[2 * n];
        udg = new boolean[2 * n];
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ; j < n ; j++){
                cs[i][j] = '.';
            }
        }
    }
    
    static void dfs (int i , int j , int n ,int queenNum){
        if (j == n){
            j = 0 ;
            i ++;
        }
        if (i == n){
            if (queenNum == n){
                for (int k = 0 ; k < n ; k++){
                    System.out.println(cs[k]);
                }
                System.out.println();
            }
            return ;
        }
        
        dfs(i,j+1,n,queenNum);
        
        if (!row[i] && !col[j] && !dg[i + j] && !udg[j - i + n]){
            row[i] = col[j] = dg[i + j] = udg [j - i + n] = true;
            cs[i][j] = 'Q';
            dfs(i,j + 1,n,queenNum + 1);
            cs[i][j] = '.';
            row[i] = col[j] = dg[i + j] = udg [j - i + n] = false;
        }
        
    }
    
    public static void main(String[] args )throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int n = Integer.parseInt(br.readLine());
        int queenNum = 0;
        init(n);
        dfs(0,0,n,0);
    }
}

