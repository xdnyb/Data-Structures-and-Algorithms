import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    }

    private static long getFibonacciHuge(long n, long m){
        long p = 0;
        long q = 1;
        long w = p + q;
        int period = 0;
        List<Long> store = new ArrayList<Long>(); 
        for (int i = 0; i <=n; i++){
            store.add(p);
            p = q;
            q = w%m;
            w = (p+q)%m;
            if (p ==0&&q==1) {
                period = i+1;
                break;
            }
            period = 0;
        }
        if (period!=0){
            long index = n%period;
            return store.get((int)index);
        }else{
            return store.get((int)n);
        }
        
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        //System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibonacciHuge(n, m));
    }
}
