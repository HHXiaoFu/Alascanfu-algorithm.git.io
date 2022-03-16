## 📝题目📝

### 📝**AcWing春季打卡活动—— 3370.牛年**

> Farmer John 的奶牛们得知最近正在庆祝牛年的到来时十分兴奋。
>
> 牛年总是奶牛们的最爱。
>
> 我们知道，中国历法中每一年所对应的生肖遵循 1212 年的周期：`Ox, Tiger, Rabbit, Dragon, Snake, Horse, Goat, Monkey, Rooster, Dog, Pig, Rat`（牛、虎、兔、龙、蛇、马、羊、猴、鸡、狗、猪、鼠），然后回到牛。
>
> 奶牛 Bessie 自豪地说她是在许多年前的一个牛年出生的。
>
> 她的朋友 Elsie 想要知道她与 Bessie 出生相差多少年，并且希望你能够通过查看农场上若干奶牛出生年份之间的关系来帮助她推算。

****

> #### 输入格式
>
> 输入的第一行包含一个整数 N。
>
> 以下 N 行每行包含一个 88 个单词的短语，指定了两头奶牛的出生年份之间的关系，格式为 `Mildred born in previous Dragon year from Bessie`（Mildred 在 Bessie 出生的前一个龙年出生），或 `Mildred born in next Dragon year from Bessie`（Mildred 在 Bessie 出生的后一个龙年出生）。
>
> 最后一个单词是农场上某一头奶牛的名字，为 “Bessie” 或一头已经在之前的输入中出现过的奶牛。
>
> 第一个单词是农场上某一头奶牛的名字，不为 “Bessie” 且未在之前的输入中出现过。
>
> 所有的奶牛名字不超过 10 个字符，且仅包含字符 a..z 或 A..Z。
>
> 第 5 个单词是上述十二生肖之一。
>
> 第 4 个单词是 `previous`（之前）或 `next`（之后）之一。
>
> 例如，如果短语为 `Mildred born in previous Dragon year from Bessie`，则 Mildred 的出生年份为最为接近且严格处于 Bessie 的出生年份之前（不等于）的龙年。
>
> #### 输出格式
>
> 输出 Bessie 和 Elsie 的出生年份之间相差的年数。输入保证可以通过给定的信息求出结果。
>
> #### 数据范围
>
> $1 \le N \le 100$
>
> #### 输入样例：
>
> ```
> 4
> Mildred born in previous Dragon year from Bessie
> Gretta born in previous Monkey year from Mildred
> Elsie born in next Ox year from Gretta
> Paulina born in next Dog year from Bessie
> ```
>
> #### 输出样例：
>
> ```
> 12
> ```
>
> #### 样例解释
>
> 在以上的输入中，
>
> - Elsie 在 Bessie 之前 1212 年出生。
> - Mildred 在 Bessie 之前 99 年出生。
> - Gretta 在 Bessie 之前 1717 年出生。
> - Paulina 在 Bessie 之后 99 年出生。

****

#### 📝思路

**预处理 + 相对计算牛牛的出生位置。**

-  我们可以清楚地知道每一行给出的输入条件中，第一个单词`所指定的牛一定是之前没有出现过的牛`，其次我们应该知道的是对于每行给出的输入条件中，最后一个单词所指定的牛`一定是之前出现过的牛`，这样`才可以建立出 牛牛 之间的相对关系`。
-  有了这些基础，我们就可以知道每头牛之间的年份相对关系，然后以 `Bessie `这只牛作为中心对应找到每只 牛牛的关系，然后通过计算就可以找到 我们所需要的年龄差了。

****

#### 📝代码实现

```java
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
class Main {
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

```

