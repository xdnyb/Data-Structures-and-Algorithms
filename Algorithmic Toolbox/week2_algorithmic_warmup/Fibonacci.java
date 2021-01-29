import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    
    if (n <= 1)
      return n;
    int[] Fibo = new int [n+1];
    Fibo[0]=0;
    Fibo[1]=1;
    for (int i =2; i<=n; i++){
      Fibo[i] = Fibo[i-1]+Fibo[i-2];
    }
    return Fibo[n];
  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
