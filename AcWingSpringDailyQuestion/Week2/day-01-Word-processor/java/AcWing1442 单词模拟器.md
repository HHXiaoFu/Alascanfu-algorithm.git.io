## 📝题目📝

### 📝**AcWing春季打卡活动—— 1442 单词模拟器**

> 奶牛 Bessie 正在完成她的写作课的一篇作文。
>
> 由于她写字很难看，她决定用一个单词处理器来输入这篇作文。
>
> 这篇作文共有 N 个单词，用空格分隔。
>
> 每个单词的长度在 1 到 15 之间，仅由大写和小写字母组成。
>
> 根据作业的要求，这篇作文需要用一种特别的方式排版：
>
> 每一行包含的字符不超过 K 个，空格不计。
>
> 幸好 Bessie 的单词处理器能够处理这样的要求，它会按照如下的方式：
>
> - 如果 Bessie 输入了一个单词，这个单词能够放进当前行，就放在当前行。
> - 否则，将这个单词放到下一行，然后继续向下一行添加单词。
>
> 当然，同一行中的单词之间仍然用一个空格分隔。每一行的结尾都不应当有空格。
>
> 很不幸，Bessie 的单词处理器刚好坏了。
>
> 请帮助她正确地排版她的作文！

****

> #### 输入格式
>
> 输入的第一行包含两个空格分隔的整数 N 和 K。
>
> 下一行包含 N 个单词，单词之间用单个空格分隔。
>
> 所有单词的长度都不超过一行中的字符上限数 K。
>
> #### 输出格式
>
> 输出正确排版的 Bessie 的作文。
>
> #### 数据范围
>
> 1≤N≤100
> 1≤K≤80
>
> #### 输入样例：
>
> ```
> 10 7
> hello my name is Bessie and this is my essay
> ```
>
> #### 输出样例：
>
> ```
> hello my
> name is
> Bessie
> and this
> is my
> essay
> ```
>
> #### 样例解释
>
> 第一行包含 7 个非空格字符，包括 “hello” 以及 “my”。
>
> 再加入 “name” 会使得第一行包含 11>7 个非空格字符，所以这个单词会被放到下一行。

****

#### 📝思路一

**双指针求解**

-  思路在于当前指针i指向当前单词位置，并且记录 `指针j最远能到达的单词位置`，如果期间单词的`字符总数小于K 则说明指针j可以后移`，然后输出`i到j`区间内的**所有单词即可**。


****

#### 📝代码实现

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/22 11:59
 * @description： AcWing春季打卡活动—— 1442单词处理器
 * @modified By： Alascanfu
 **/
class Main {
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

```

#### 📝思路二

**暴力模拟——笛卡觉得很赞OTZ**

-  单词的位置做出改变则记录当前还能在本行输出的字符数量，如果无法继续输出，则更新长度，直接换行。

****

#### 📝代码实现

```java
import java.util.Scanner;

public class Main{

    static int n, k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        String s = sc.nextLine();
        String[] txt = sc.nextLine().split(" ");
        int cnt = k;

        for(int i = 0; i < n; ) {
            if(txt[i].length() <= cnt) {
                if(cnt != k) System.out.print(" ");
                cnt -= txt[i].length();
                System.out.print(txt[i++]);
            } else {
                cnt = k;
                System.out.println();
            }
        }

        System.out.println();
    }
}
```

