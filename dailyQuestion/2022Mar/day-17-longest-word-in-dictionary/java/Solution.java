/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/17 20:39
 * @description： Leetcode 每日一题 720词典中的最长单词
 * @modified By： Alascanfu
 **/
class Solution720 {
    public String longestWord(String[] words) {
        Trie trie = new Trie();
        for (String s : words)trie.insert(s);
        
        String res = "";
        for (String s : words){
            int m = res.length();
            int n = s.length();
            if (n < m)continue;
            if (m == n && s.compareTo(res) > 0)continue;
            if (trie.search(s))res = s;
        }
        return res;
    }
}
class Trie {
    int N =30030;
    int[][] trie ;
    int [] cnt ;
    int idx;
    public Trie(){
        trie = new int [N][26];
        cnt = new int [N];
        idx = 0;
    }
    
    public void insert(String s){
        int p = 0 ;
        for (int i = 0 ;i< s.length();i++){
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0)trie[p][u] = ++ idx;
            p = trie[p][u];
        }
        cnt[p]++ ;
    }
    
    
    public boolean search(String s ){
        int p = 0 ;
        for (int i = 0 ;i< s.length();i++){
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0)return false;
            p = trie[p][u];
            if (cnt[p]==0) return false;
        }
        return true;
    }
    
}