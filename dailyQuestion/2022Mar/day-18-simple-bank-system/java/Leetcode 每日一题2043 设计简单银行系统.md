# 题目
>你的任务是为一个很受欢迎的银行设计一款程序，以自动化执行所有传入的交易（转账，存款和取款）。银行共有 n 个账户，编号从 1 到 n 。每个账号的初始余额存储在一个下标从 0 开始的整数数组 balance 中，其中第 (i + 1) 个账户的初始余额是 balance[i] 。

>请你执行所有 有效的 交易。如果满足下面全部条件，则交易 有效 ：

>`指定的账户数量在 1 和 n 之间，且
取款或者转账需要的钱的总数 小于或者等于 账户余额。`

**实现 Bank 类：**

>- Bank(long[] balance) 使用下标从 0 开始的整数数组 balance 初始化该对象。
> - boolean transfer(int account1, int account2, long money) 从编号为 account1 的账户向编号为 account2 的账户转帐 money 美元。如果交易成功，返回 true ，否则，返回 false 。
> - boolean deposit(int account, long money) 向编号为 account 的账户存款 money 美元。如果交易成功，返回 true ；否则，返回 false 。
> - boolean withdraw(int account, long money) 从编号为 account 的账户取款 money 美元。如果交易成功，返回 true ；否则，返回 false 。


示例1：

```txt
输入：
["Bank", "withdraw", "transfer", "deposit", "transfer", "withdraw"]
[[[10, 100, 20, 50, 30]], [3, 10], [5, 1, 20], [5, 20], [3, 4, 15], [10, 50]]
输出：
[null, true, true, true, false, false]

解释：
Bank bank = new Bank([10, 100, 20, 50, 30]);
bank.withdraw(3, 10);    // 返回 true ，账户 3 的余额是 $20 ，所以可以取款 $10 。
                         // 账户 3 余额为 $20 - $10 = $10 。
bank.transfer(5, 1, 20); // 返回 true ，账户 5 的余额是 $30 ，所以可以转账 $20 。
                         // 账户 5 的余额为 $30 - $20 = $10 ，账户 1 的余额为 $10 + $20 = $30 。
bank.deposit(5, 20);     // 返回 true ，可以向账户 5 存款 $20 。
                         // 账户 5 的余额为 $10 + $20 = $30 。
bank.transfer(3, 4, 15); // 返回 false ，账户 3 的当前余额是 $10 。
                         // 所以无法转账 $15 。
bank.withdraw(10, 50);   // 返回 false ，交易无效，因为账户 10 并不存在。
```


## 提示
`n == balance.length`
`1 <= n, account, account1, account2 <= 10^5`
`0 <= balance[i], money <= 10^12`
`transfer, deposit, withdraw 三个函数，每个 最多调用 10^4 次`


## 📝思路📝

**本题考查知识点**
- 思路：拿到题的瞬间，`以为`今天`是一道多线程的设计题`，但是转眼发现`并没有多线程操作`，只是`在单线程下的情况用户银行存储过程的一道题`，然后又读题发现有用户，`以为每个不同的用户还需要用哈希表来存储`，但是好在直接给定的是用户账户的钱款数组，又可以无需考虑账户哈希表了，且给定的条件**三个函数最多调用** $10^4$ 并且**每次调用的金额 和给定的 金额都不会高于** $10^{12}$ 那么账户单个最大的余额不会超过 $10^{16}$ 不用考虑`long[]`数组是否会溢出。 
- 如果上述问题都需要考虑，那么这题设置为困难题我都觉得不为过，反正我是做不出来=-= ，分析问题考察的角度，以及可能出现的状况才是我们学习算法思路的本质。
## 代码实现
**简单模拟**
```java
class Bank {
    
    long[] balance ;
    
    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean check(int account){
        return account <= balance.length && account > 0 ;
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!check(account2) || !check(account1))return false;
        if(withdraw(account1,money)){
            return deposit(account2,money);
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if (!check(account))return false;
        balance[account-1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if (! check(account) || balance[account-1] < money)return false;
        balance[account-1] -= money;
        return true;
    }
}
```

- **时间复杂度:** O($1$)  
- **空间复杂度:** O($n$)


## 运行结果
**简单模拟**

![image.png](https://pic.leetcode-cn.com/1647570834-POpMKf-image.png)

