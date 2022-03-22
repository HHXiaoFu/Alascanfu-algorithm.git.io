import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/22 11:59
 * @description： AcWing春季打卡活动—— 1442单词处理器
 * @modified By： Alascanfu
 * 双指针解决
 **/
class Main1442 {
    static int N = 110;
    static String[] words;
    static void init(){
        words = new String[N];
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        String[] parmas1 = br.readLine().split(" ");
        int n = Integer.parseInt(parmas1[0]);
        int k = Integer.parseInt(parmas1[1]);
        String[] parmas2 = br.readLine().split(" ");
    
        for (int i = 1; i<= n;i++){
            words[i] = parmas2[i-1];
        }
        
        for (int i = 1 ; i<=n;){
            int j = i+1;
            int len = words[i].length();
            while ( words[j]!= null && (len+=words[j].length()) <= k )j++;
            for (int idx = i;i<j;i++){
                if (i != j-1)
                    System.out.print(words[i]+" ");
                else
                    System.out.print(words[i]);
            }
            System.out.println();
            i=j;
        }
    }
}

/**
 * 功能描述
 *  暴力解决
 * @author Alascanfu
 * @date 2022/3/22
 */
class Main1442_anotherMethod{
    public static void main(String[] args) throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] parmas1 = br.readLine().split(" ");
        int n = Integer.parseInt(parmas1[0]);
        int k = Integer.parseInt(parmas1[1]);
        String[] words = br.readLine().split(" ");
        int cnt = k;
        for (int i = 0;i<n;){
            if (words[i].length() <= cnt){
                if (cnt != k) System.out.print(" ");
                cnt-=words[i].length();
                System.out.print(words[i++]);
            }else {
                cnt = k;
                System.out.println();
            }
        }
    }
}