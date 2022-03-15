## 📝题目📝

### 📝**AcWing春季打卡活动—— 3358.放养但又没有完全放养**

> 一个鲜为人知的事实是，奶牛拥有自己的文字：「牛文」。
>
> 牛文由 2626 个字母 `a` 到 `z` 组成，但是当奶牛说牛文时，可能与我们所熟悉的 `abcdefghijklmnopqrstuvwxyz` 不同，她会按某种特定的顺序排列字母。
>
> 为了打发时间，奶牛 Bessie 在反复哼唱牛文字母歌，而 Farmer John 好奇她唱了多少遍。
>
> 给定一个小写字母组成的字符串，为 Farmer John 听到 Bessie 唱的字母，计算 Bessie 至少唱了几遍完整的牛文字母歌，使得 Farmer John 能够听到给定的字符串。
>
> Farmer John 并不始终注意 Bessie 所唱的内容，所以他可能会漏听 Bessie 唱过的一些字母。
>
> 给定的字符串仅包含他记得他所听到的字母。

****

> #### 输入格式
>
> 输入的第一行包含 2626 个小写字母，为`a`到`z`的牛文字母表顺序。
>
> 下一行包含一个小写字母组成的字符串，为 Farmer John 听到 Bessie 唱的字母。
>
> #### 输出格式
>
> 输出 Bessie 所唱的完整的牛文字母歌的最小次数。
>
> #### 数据范围
>
> 字符串的长度不小于 11 且不大于 10001000。
>
> #### 输入样例：
>
> ```
> abcdefghijklmnopqrstuvwxyz
> mood
> ```
>
> #### 输出样例：
>
> ```
> 3
> ```
>
> #### 样例解释
>
> 在这个样例中，牛文字母表与日常的字母表的排列一致。
>
> Bessie 至少唱了三遍牛文字母歌。
>
> 有可能 Bessie 只唱了三遍牛文字母歌，而 Farmer John 听到了以下被标记为大写的字母。
>
> ```
> abcdefghijklMnOpqrstuvwxyz
> abcdefghijklmnOpqrstuvwxyz
> abcDefghijklmnopqrstuvwxyz
> ```

****

#### 📝思路

**针对于奶牛唱歌，我们很容易想到先将牛文存储在Hash表当中，key 为 当前字符，val 为当前字符在牛文中顺序。**

-  遍历 Farmer John 听到的牛文，而却 相邻之间的牛文应该满足是否在牛文字典序中的顺序符合前者小于后者 ，如果`大于或者等于则需要🐮再唱第二遍的时候才能听到`，所以牛要唱的遍数就要+1，反之在这遍牛文中还可以找到 Farmer John 听到的牛文。

****

#### 📝代码实现

```java
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
    
        String cowLanguage = br.readLine();
        String cowSing = br.readLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i< cowLanguage.length();i++){
            map.put(cowLanguage.charAt(i),i);
        }
        int cnt = 1 ;
        for (int i = 0;i< cowSing.length()-1;i++){
            if (map.get(cowSing.charAt(i)) < map.get(cowSing.charAt(i+1)))continue;
            else {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
```

