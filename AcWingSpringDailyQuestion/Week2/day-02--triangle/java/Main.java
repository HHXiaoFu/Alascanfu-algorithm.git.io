/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/23 22:02
 * @description： AcWing春季打卡活动——  1671.三角形
 * @modified By： Alascanfu
 **/

import java.io.*;
import java.util.*;

class Main1671 {
    static int N =110;
    static Pos[] p;
    static class Pos{
        int x ,y;
        public Pos(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static void init() {
        p = new Pos[N];
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        int n = Integer.parseInt(br.readLine());
        for (int i= 1;  i<= n;i++){
            String[] params = br.readLine().split(" ");
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            p[i] = new Pos(x,y);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=n;j++){
                for (int k = 1;k<= n;k++){
                    if (i == j || j == k || k == i)continue;
                    if (p[i].x == p[j].x && p[j].y == p[k].y){
                        res = Math.max(res,Math.abs(p[i].y - p[j].y) * Math.abs(p[j].x-p[k].x));
                    }
                }
            }
        }
        System.out.println(res);
    }
    
}
