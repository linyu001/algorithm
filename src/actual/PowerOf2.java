package actual;

/**
 * 求一个数是否是2的整数次幂
 * 对于一个整数n， 只需要计算n&(n-1)的结果是不是0。是0就是2的整数次幂，否则不是
 * 这个方法的时间复杂度只有O（1）
 */
public class PowerOf2 {
    public static void main(String[] args) {
        System.out.println(20&20-1);
        System.out.println(16&16-1);

    }
}
