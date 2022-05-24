import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/4/6 17:22
 * @description： AcWing 区间合并的基础问题模板思想理解与解决
 * @modified By： Alascanfu
 **/
public class IntervalMergeTemplate {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        int n = Integer.parseInt(br.readLine());
        List<P> alls = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String[] params = br.readLine().split(" ");
            int st = Integer.parseInt(params[0]);
            int ed = Integer.parseInt(params[1]);
            alls.add(new P(st, ed));
        }
        Collections.sort(alls);
        System.out.println(merge(alls));
    }
    
    static int merge(List<P> alls) {
        List<P> res = new ArrayList<>();
        int st = (int) -2e9;
        int ed = (int) -2e9;
        for (P p : alls) {
            if (ed < p.st) {
                if (ed != (int) -2e9) {
                    res.add(new P(st, ed));
                }
                st = p.st;
                ed = p.ed;
            } else {
                ed = Math.max(ed, p.ed);
            }
        }
        if (ed != (int) -2e9) res.add(new P(st, ed));
        return res.size();
    }
}

class P implements Comparable<P> {
    int st, ed;
    
    public P(int st, int ed) {
        this.st = st;
        this.ed = ed;
    }
    
    @Override
    public int compareTo(P p) {
        return Integer.compare(st, p.st);
    }
}

/**
 * 功能描述
 * 小付的方法
 * @author Alascanfu
 * @date 2022/4/6
 */
class Main{
    static int N = 100010;
    static int[][] intervals ;
    static void init(){
        intervals = new int[N][2];
    }
    public static void main(String[] args) throws IOException{
        init();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i<= n;i++){
            String [] params = br.readLine().split(" ");
            int l = Integer.parseInt(params[0]);
            int r = Integer.parseInt(params[1]);
            intervals[i][0] = l;
            intervals[i][1] = r;
        }
        
        int cnt = 0 ;
        PriorityQueue<int []> pq = new PriorityQueue<>((a, b)->{
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        for(int i = 1; i<= n;i++){
            pq.add(intervals[i]);
        }
        int[] interval = pq.poll();
        int st = interval[0];
        int ed = interval[1];
        while (!pq.isEmpty()){
            int [] tmp = pq.poll();
            int tmpSt = tmp[0];
            int tmpEd = tmp[1];
            if (tmpSt <= ed){
                ed = Math.max(ed, tmpEd);
            }else {
                cnt ++;
                st = tmpSt;
                ed = tmpEd;
            }
        }
        cnt ++ ;
        System.out.println(cnt);
    }
}