## 📝题目📝

### 📝**AcWing春季打卡活动—— 1442 单词模拟器**

> Farmer John 想要给他的奶牛们建造一个三角形牧场。
>
> 有 N 个栅栏柱子分别位于农场的二维平面上不同的点 (X1,Y1)…(XN,YN)。
>
> 他可以选择其中三个点组成三角形牧场，只要三角形有一条边与 xx 轴平行，且有另一条边与 yy 轴平行。
>
> Farmer John 可以围成的牧场的最大面积是多少？
>
> 保证存在至少一个合法的三角形牧场。

****

> #### 输入格式
>
> 输入的第一行包含整数 N。
>
> 以下 N 行每行包含两个整数 Xi 和 Yi，均在范围 −104…104 之内，描述一个栅栏柱子的位置。
>
> #### 输出格式
>
> 由于面积不一定为整数，输出栅栏柱子可以围成的合法三角形的最大面积的**两倍**。
>
> #### 数据范围
>
> 3≤N≤100
>
> #### 输入样例：
> 
>```
> 4
>0 0
> 0 1
> 1 0
> 1 2
> ```
>
> #### 输出样例：
>
> ```
> 2
> ```
> 
> #### 样例解释
> 
> 位于点 (0,0)、(1,0) 和 (1,2)的木桩组成了一个面积为 1 的三角形。所以，答案为 2⋅1=2
> 
>只有一个其他的三角形，面积为 0.50.5。

****

#### 📝思路一

**暴力枚举求解**

-  看看是否可以构成一个满足条件的三角形。
-  如果可以构成一个满足条件的三角形的话
-  判断是否是一个**满足条件的三角形**，只要`满足点i和点j的x坐标相等`，`点j和点k的y坐标相等`。


****

#### 📝代码实现

```java
/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/23 22:02
 * @description： AcWing春季打卡活动——  1671.三角形
 * @modified By： Alascanfu
 **/

import java.io.*;
import java.util.*;

class Main1671 {
    static int N =110;
    static Pos[] p;
    static class Pos{
        int x ,y;
        public Pos(int x , int y){
            this.x = x;
            this.y = y;
        }
    }
    
    static void init() {
        p = new Pos[N];
    }
    
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        init();
        int n = Integer.parseInt(br.readLine());
        for (int i= 1;  i<= n;i++){
            String[] params = br.readLine().split(" ");
            int x = Integer.parseInt(params[0]);
            int y = Integer.parseInt(params[1]);
            p[i] = new Pos(x,y);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=n;j++){
                for (int k = 1;k<= n;k++){
                    if (i == j || j == k || k == i)continue;
                    if (p[i].x == p[j].x && p[j].y == p[k].y){
                        res = Math.max(res,Math.abs(p[i].y - p[j].y) * Math.abs(p[j].x-p[k].x));
                    }
                }
            }
        }
        System.out.println(res);
    }
    
}

```

