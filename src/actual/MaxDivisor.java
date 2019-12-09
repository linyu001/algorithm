package actual;

/**
 * 求两个数的最大公约数
 * 更相减损术和位移运算
 * 时间复杂度为O(log(max(a,
 * b)))。
 */
public class MaxDivisor {
    public static int gcd(int a,int b){
        if(a==b){
            return a;
        }
        if((a&1)==0&&(b&1)==0){
            return gcd(a>>1,b>>1)<<1;
        }else if ((a&1)==0&&(b&1)==1){
            return gcd(a>>1,b);
        }else if ((a&1)==1&&(b&1)==0){
            return gcd(a,b>>1);
        }else {
            int big=a>b?a:b;
            int small=a<b?a:b;
            return gcd(big-small,small);
        }

    }
    public static void main(String[] args) {
        System.out.println(gcd(20,15));
    }
}
