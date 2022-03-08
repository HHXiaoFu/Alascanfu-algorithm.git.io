## 高精度正整数加法（Java）

这里摘记——断了片了 好兄弟用来做笔记

**📝Java中有两个类可以用来处理高精度的计算**

`分别是处理整数的BigInteger和处理小数的BigDecimal`

## BigInteger 只可用于整数

> 构造方法

- **BigInteger(byte[] val)** 
  将包含BigInteger的二进制补码二进制表达式的字节数组转换为BigInteger 
- **BigInteger(int numBits, Random rnd)** 
  构造一个随机生成的BigInteger，均匀分布在0到（2 numBits - 1）的范围内。  
- **BigInteger(String val)** 
  将BigInteger的十进制字符串表示形式转换为BigInteger。

**高精度加法计算**

**注意：这种方式如果写给面试官看你会死的很惨的，知道就好可以提一下。**

```java
import java.util.*;
import java.math.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        BigInteger a = new BigInteger(br.readLine());
        BigInteger b = new BigInteger(br.readLine());
        System.out.print(a.add(b));
        br.close();
    }
}
```

**Y总模板Java实现：**

```java
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String a = br.readLine();
        String b = br.readLine();
        int aLen = a.length(),bLen = b.length();
        List<Integer> A = new ArrayList<>(aLen);
        List<Integer> B = new ArrayList<>(bLen);
        for (int i = aLen - 1;i>=0;i--)A.add(a.charAt(i) - '0');
        for (int i = bLen - 1;i>=0;i--)B.add(b.charAt(i) - '0');
        List<Integer> C = add(A,B);
        for (int i = C.size()- 1;i>=0;i--){
            System.out.print(C.get(i));
        }
    }
    public static List<Integer> add(List<Integer> A,List<Integer> B){
        List<Integer> c = new ArrayList<>(Math.max(A.size(),B.size()+2));
        int tmp = 0;
        for (int i = 0 ;i<A.size()||i<B.size();i++){
            if(i<A.size())tmp+=A.get(i);
            if(i<B.size())tmp+=B.get(i);
            c.add(tmp%10);
            tmp/=10;
        }
        if(tmp > 0)c.add(tmp);
        return c;
    }
}
```

**这里我们通常所需要进行考察程序员的点在于下述该点：**

- 数字字符串转换为整型的方法，概括起来就是一句话 `字符串减去0` , 如果想了解可以去看ASCII表或者百度。

**高精度加法这里的思想是逐位运算相加，模拟是否进位等情况，逐位计算**

```java
import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)throws IOException{
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        
        String a = br.readLine();
        String b = br.readLine();
        // 判断是否需要进位
        int addOne = 0;
        // 获取当前字符的长度
        int aLen = a.length(),bLen = b.length();
        StringBuilder res = new StringBuilder();
        // 逐位进行计算是否需要进位
        while (aLen > 0 || bLen > 0){
            // 这里三元运算判断是为了防止当一个整数位数计算之后没有位数进行计算了所以需要的
            int aNum = aLen > 0 ? a.charAt(aLen-1) - '0' : 0,bNum = bLen > 0 ? b.charAt(bLen-1)-'0' : 0;
            // 这里是判断当前位上的数值
            int num = (aNum + bNum + addOne) % 10;
            // 这里判断是否需要进行进位
            addOne = (addOne + aNum + bNum) / 10;
            // 将当前位数进行追加入结果当中
            res.append(num);
            // 逐位计算
            aLen--;
            bLen--;
        }
        // 如果最高位有进位也需要将结果追加其中
        if (addOne > 0)res.append(addOne);
        // 反转输出结果
        System.out.print(res.reverse().toString());
        br.close();
    }
}
```

****
📑 典型例题：

> [AcWing 791. 高精度加法](https://www.acwing.com/problem/content/793/)
>
> [nowCoder NC1 大数加法](https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475/)
