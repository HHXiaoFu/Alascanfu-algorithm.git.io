import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/5/7 20:10
 * @description： TrieTemplate
 * @modified By： Alascanfu
 **/
public class TrieTemplate {
    static int N = 100010;
    static int[][] trie;
    static int[] cnt;
    static int idx;
    
    
    static void init() {
        trie = new int[N][26];
        cnt = new int[N];
        idx = 0;
    }
    
    static void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) trie[p][u] = ++idx;
            p = trie[p][u];
        }
        cnt[p]++;
    }
    
    
    static int search(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) return 0;
            p = trie[p][u];
        }
        return cnt[p];
    }
    
    public static void main(String[] args) throws IOException {
        init();
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] params = br.readLine().split(" ");
            String operate = params[0];
            String s = params[1];
            if (operate.equals("I")) {
                insert(s);
            } else {
                System.out.println(search(s));
            }
            
        }
    }
}
