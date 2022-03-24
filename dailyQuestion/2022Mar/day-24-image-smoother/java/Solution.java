/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/24 17:10
 * @description： Leetcode每日一题 661.图片平滑器 2022/03/24
 * @modified By： Alascanfu
 **/
class Solution661 {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] s = new int[m+1][n+1];
        
        for (int i = 1 ; i<=m;i++){
            for (int j = 1 ;j<=n;j++){
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1]+img[i-1][j-1];
            }
        }
        
        int [][] res = new int[m][n];
        for (int i = 0;i<m;i++){
            for (int j = 0 ; j<n;j++){
                int left = Math.max(0,j-1);
                int right = Math.min(n-1,j+1);
                
                int top = Math.max(0,i-1);
                int down = Math.min(m-1,i+1);
                int cnt = (right - left + 1) * (down - top + 1);
                int val = s[down+1][right+1] - s[top][right+1] - s[down+1][left] + s[top][left];
                res[i][j] =  val / cnt;
            }
        }
        return res;
    }
}
