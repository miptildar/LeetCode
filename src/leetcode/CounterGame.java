package leetcode;

public class CounterGame {
    public static String counterGame(long n) {
        int steps = 0;

        while (n != 1) {
            System.out.println("Steps " + steps + ": " + n);
            long temp = n;
            if ((temp & (temp - 1)) == 0) {
                n = n >> 1;
            } else {
                long powOf2 = 1L << closestPow(n);
                n = n - powOf2;
            }

            steps++;
        }

        if (steps % 2 == 0) {
            return "Richard";
        } else {
            return "Louise";
        }
    }

    private static int closestPow(long n) {
        byte counter = 63;
        while (counter > 0) {
            if ((n & (1L << counter)) != 0) {
                return counter;
            }
            counter--;
        }

        return counter;
    }
}
