public class RekursionTestklasse {

    public static void main(String[] args) {
//        System.out.println(fakultaet(7));
//        System.out.println(umdrehen("Lager"));
//        System.out.println(fib(6));
//        System.out.println(med(100));
        System.out.println(kap(4));
    }

    private static int fakultaet(int n) {
        if (n <= 0) {
            return 1;
        } else {
            return n * fakultaet(n - 1);
        }
    }

    private static String umdrehen(String s) {
        if( s.length() < 2) {
            return s;
        }
        System.out.println(s);
        return umdrehen(s.substring(1)) + s.charAt(0);

    }


    private static int fib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    return fib(n-1) + fib(n-2);
    }

    private static double med(int n) {
        if(n == 1) {
            return 5 * 0.4;
        }
        else return (med(n-1) + 5 )* 0.4;
    }

    private static double kap(int n) {
        if (n == 0) return 1000;
        if (n == 1) return 1000 * 1.05;
        return kap(n - 1) * 1.05;
    }




}
