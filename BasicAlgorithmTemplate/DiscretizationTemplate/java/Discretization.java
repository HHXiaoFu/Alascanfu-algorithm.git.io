import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/6 15:32
 * @description： AcWing 离散化 区间和 问题 基础模板
 * @modified By： Alascanfu
 **/
public class Discretization {
    static int N = 300010;
    static int[] s, a;
    static List<Integer> alls;
    static List<P> adds, querys;
    
    static void init() {
        a = new int[N];
        s = new int[N];
        alls = new ArrayList<>();
        adds = new ArrayList<>();
        querys = new ArrayList<>();
    }
    
    public static void main(String[] args) throws IOException {
        init();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        String[] params = br.readLine().split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        for (int i = 1; i <= n; i++) {
            String[] params1 = br.readLine().split(" ");
            int x = Integer.parseInt(params1[0]);
            int c = Integer.parseInt(params1[1]);
            adds.add(new P(x, c));
            alls.add(x);
        }
        
        for (int i = 1; i <= m; i++) {
            String[] params1 = br.readLine().split(" ");
            int l = Integer.parseInt(params1[0]);
            int r = Integer.parseInt(params1[1]);
            querys.add(new P(l, r));
            alls.add(l);
            alls.add(r);
        }
        
        Collections.sort(alls);
        alls = new ArrayList<>(new LinkedHashSet<>(alls));
        
        for (P p : adds){
            int idx = findIdx(alls,p.a);
            a[idx] += p.b;
        }
        for (int i = 1 ; i<= alls.size();i++){
            s[i] = s[i-1] + a[i];
        }
        
        for (P p : querys){
            int l = findIdx(alls,p.a);
            int r = findIdx(alls,p.b);
            System.out.println(s[r] - s[l-1]);
        }
    }
    
    static int findIdx(List<Integer> alls, int target) {
        int l = 0;
        int r = alls.size();
        while (l < r) {
            int mid = l + r >> 1;
            if (alls.get(mid) >= target) r = mid;
            else l = mid + 1;
        }
        return l + 1;
    }
}

class P {
    int a, b;
    
    public P(int a, int b) {
        this.a = a;
        this.b = b;
    }
}