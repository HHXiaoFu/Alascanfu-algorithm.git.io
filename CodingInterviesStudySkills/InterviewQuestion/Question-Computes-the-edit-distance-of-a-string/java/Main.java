import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/19 20:01
 * @description： Computes the edit distance of a string
 * @modified By： Alascanfu
 **/
class Main {
    static int N = 1010;
    static int[] A;
    static int[] B;
    static int[][]dp;
    
    static void init(){
        A = new int[N];
        B = new int[N];
        dp = new int[N][N];
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        String a = br.readLine();
        String b = br.readLine();
        
        for (int i = 1 ; i<= a.length();i++){
            A[i-1] = a.charAt(i-1) - 'a';
            dp[i][0] = i;
        }
        
        for (int j = 1 ;j <= b.length();j++){
            B[j-1] = b.charAt(j-1) - 'a';
            dp[0][j] = j;
        }
        
        for (int i = 1 ;i<=a.length();i++){
            for (int j = 1;j<=b.length();j++){
                if (A[i-1] == B[i-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))+1;
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}
