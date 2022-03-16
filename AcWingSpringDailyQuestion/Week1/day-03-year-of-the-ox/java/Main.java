import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/16 16:46
 * @description： AcWing 3370.牛年
 * @modified By： Alascanfu
 **/
class Main3370 {
    static int N = 200 ;
    /** 用于记录十二生肖所对应的相对位置 */
    static String[] year  ;
    /** 预处理 200 年的牛牛相对年龄区间 */
    static String[] allYear ;
    /** 用于记录每只牛出生的年份 */
    static HashMap<String ,Integer> cowBirth;
    
    /** 初始化*/
    static void init(){
        year = new String[]{"Ox","Tiger", "Rabbit", "Dragon", "Snake", "Horse"
            ,"Goat","Monkey", "Rooster", "Dog", "Pig","Rat"};
        allYear = new String[N];
        cowBirth = new HashMap<>();
        for (int i = 0 ; i< N ;i++){
            allYear[i] = year[i % 12];
        }
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0){
            /** 获取所需参数*/
            String[] parmas = br.readLine().split(" ");
            String cow1 = parmas[0];
            String cow2 = parmas[parmas.length-1];
            String preOrNext = parmas[3];
            /** 将Bessie作为基准值记录相对位置设置其假定出生在96年 */
            if (!cowBirth.containsKey(cow2)){
                cowBirth.put(cow2,96);
            }
            /** 如果当前牛的出生在cow2牛之前*/
            if (preOrNext.equals("previous")){
                int j = cowBirth.get(cow2) - 1  ;
                while(!allYear[j].equals(parmas[4]))j--;
                cowBirth.put(cow1,j);
            }else {
                int j = cowBirth.get(cow2) + 1 ;
                while(!allYear[j].equals(parmas[4]))j++;
                cowBirth.put(cow1,j);
            }
        }
        System.out.print(Math.abs(cowBirth.get("Elsie") - cowBirth.get("Bessie")));
    }
}
