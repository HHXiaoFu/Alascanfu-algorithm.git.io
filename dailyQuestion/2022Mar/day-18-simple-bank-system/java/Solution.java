/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/18 9:48
 * @description： Leetcode 每日一题2043 简单银行系统
 * @modified By： Alascanfu
 **/
class Solution2043 {

}
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

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */