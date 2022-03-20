## 📝题目📝

### 📝**AcWing春季打卡活动—— 1459奶牛体操**

> 为了提高健康水平，奶牛们开始进行体操训练了！
>
> 农夫约翰选定了他最喜爱的奶牛 Bessie 来执教其他 N 头奶牛，同时评估她们学习不同的体操技术的进度。
>
> K 次训练课的每一次，Bessie 都会根据 N 头奶牛的表现给她们进行排名。
>
> 之后，她对这些排名的一致性产生了好奇。
>
> 称一对不同的奶牛是一致的，当且仅当其中一头奶牛在每次训练课中都表现得都比另一头要好。
>
> 请帮助 Bessie 计算一致的奶牛的对数。

****

> #### 输入格式
>
> 输入的第一行包含两个正整数 K 和 N。
>
> 以下 K 行每行包含整数 1…N 的某种排列，表示奶牛们的排名（奶牛们用编号 1…N 进行区分）。
>
> 如果在某一行中 AA 出现在 BB 之前，表示奶牛 AA 表现得比奶牛 BB 要好。
>
> #### 输出格式
>
> 输出一行，包含一致的奶牛的对数。
>
> #### 数据范围
>
> 1≤K≤10
>1≤N≤20
> 
>#### 输入样例：
> 
>```
> 3 4
>4 1 2 3
> 4 1 3 2
>4 2 1 3
> ```
>
> #### 输出样例：
>
> ```
> 4
> ```
> 
> #### 样例解释
> 
> 一致的奶牛对为 (1,4)、(2,4)、(3,4)、(1,3)

****

#### 📝思路

**数学排列+枚举**

-  有所给的数据范围可以知道最多一行中会产生 $P{_{20}^2}$ 排列序对也就是**一行最多也就出现 380个有序的数对，一共最多可能出现十行 ，那么就算枚举每对有序数对进行判断 其范围也是可接受的数据范围**。

- 我们可以通过预处理设置每一行中每个数字所处在的位置，**然后每次只需要对当前这两个数对中在数组中的位置是否满足条件进行判断**，如果满足则进行结果记录，反之不记录。

****

#### 📝代码实现

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/19 13:15
 * @description： AcWing春季打卡活动—— 1459奶牛体操
 * @modified By： Alascanfu
 **/
class Main {
    static int K = 12;
    static int N = 22;
    static int[][] p ;
    
    static void init(){
        p = new int[K][N];
    }
    
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] params = br.readLine().split(" ");
        init();
        int m = Integer.parseInt(params[0]);
        int n = Integer.parseInt(params[1]);
        
        for (int i = 1; i<=m ;i++){
            String[] paramsNum = br.readLine().split(" ");
            for (int j = 1;j<=n;j++){
                // 获取处于当前位置的元素
                int x = Integer.parseInt(paramsNum[j-1]);
                // 将数据当前位置标记在数组中
                // 表示的是第 i 行 中的 x元素的位置为 j
                p[i][x] = j;
            }
        }
        
        int res = 0 ;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=n;j++){
                // 没有元素对相对位置进行交换
                boolean flag = true;
                for (int k = 1;k<=m;k++){
                    // 如果当前i元素的位置处于j元素的位置之后则说明数对交换了，就不能满足条件了
                    if (p[k][i] >= p[k][j])flag = false;
                }
                if (flag)res++;
            }
        }
        System.out.print(res);
    }
}
```

