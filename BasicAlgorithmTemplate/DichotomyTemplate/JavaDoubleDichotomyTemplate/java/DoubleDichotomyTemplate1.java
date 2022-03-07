/***
 * @author： Alascanfu
 * @date ： Created in 2022/3/6 14:10
 * @description： DoubleDichotomyTemplate1
 * @modified By： Alascanfu
 **/
public class DoubleDichotomyTemplate1 {
    // 检查x是否满足某种性质
    public boolean check(double x){
        return true;
    }
    
    public double bSearch_3(double l ,double r){
        double eps = 1e-6; // eps 表示精度，取决于题目对精度要求
        while(r - l > eps){
            double mid = (l + r) / 2;
            if (check(mid)) r = mid;
            else l = mid;
        }
        Integer.toString(100,7);
        return l;
    }
}
