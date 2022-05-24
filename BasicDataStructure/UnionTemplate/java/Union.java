import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/9 21:06
 * @description： UnionTemplate
 * @modified By： Alascanfu
 **/
public class Union {
    static int[] p , size ;
    public Union(int n){
        p = new int[n+1];
        size = new int[n+1];
        for (int i = 1 ;i <= n;i++){
            p[i] = i;
            size[i] = 1;
        }
    }
    
    int find(int x){
        if (p[x] != x){
            p[x] = find(p[x]);
        }
        return p[x];
    }
    
    void union(int a , int b){
        if (find(a) == find(b)){
            return ;
        }
        size[find(b)] += size[find(a)];
        p[find(a)] = find(b);
    }
    
    int queryCnt(int a){
        return size[find(a)];
    }
}

class Main{
    public static void main(String[] args ) throws IOException, IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        Union u = new Union(n);
        while (m -- > 0){
            String[] params1 = br.readLine().split(" ");
            String operate = params1[0];
            if (operate.equals("C")){
                int a = Integer.parseInt(params1[1]);
                int b = Integer.parseInt(params1[2]);
                u.union(a,b);
            }else if (operate.equals("Q1")){
                int a = Integer.parseInt(params1[1]);
                int b = Integer.parseInt(params1[2]);
                if (u.find(a) == u.find(b)){
                    System.out.println("Yes");
                }
                else{
                    System.out.println("No");
                }
            }else {
                int a = Integer.parseInt(params1[1]);
                System.out.println(u.queryCnt(a));
            }
        }
    }
}