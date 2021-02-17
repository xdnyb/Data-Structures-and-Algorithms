import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }


    private static long getFibonacciSum(long n){
        if (n<=1) return n;
        long p = 0;
        long q = 1;
        long w = p+q;
        long m = n%60;
        for (int i = 0;i<m;i++){
            p=q;
            q=w%10;
            w=(p+q)%10;
        }
        if (w==0){
            return 9;
        }else{
        return w-1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        //long s = getFibonacciSumNaive(n);
        long s = getFibonacciSum(n);
        System.out.println(s);
    }
}

