import java.util.*;

public class LCM {
  private static int gcd(int a, int b){
    if (b==0) return a;
    int c = a%b;
    return gcd(b,c);
  }

  private static long lcm_naive(int a, int b) {
  int gcd = gcd(a,b);
  return (long) a*b/gcd;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_naive(a, b));
  }
}
