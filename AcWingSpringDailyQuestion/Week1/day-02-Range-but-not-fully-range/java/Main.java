import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/15 12:17
 * @description： AcWing 3358.放养但没有完全放养
 * @modified By： Alascanfu
 **/
class Main3358 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
    
        String cowLanguage = br.readLine();
        String cowSing = br.readLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i< cowLanguage.length();i++){
            map.put(cowLanguage.charAt(i),i);
        }
        int cnt = 0 ;
        for (int i = 0;i< cowSing.length()-1;i++){
            if (map.get(cowSing.charAt(i)) < map.get(cowSing.charAt(i+1)))continue;
            else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
