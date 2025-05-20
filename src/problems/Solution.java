package problems;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner in = new Scanner(System.in);
        while(true) {
            int i = in.nextInt();
            solution.printer(i);
            System.out.println(solution.solution(i));
        }

    }

    public int[] solution(int[] A, int K) {
        int size = A.length;
        int times = (int) (K / size);
        int shiftValue = K - size * times;

        int[] newPositions = new int[size];
        for (int i=0; i<size; i++) {
            int x = i + shiftValue;
            if (x >= size) {
                x -= size;
            }

            newPositions[x] = A[i];
        }

        return newPositions;
    }

    public int solution(int N) {
        byte[] arr = new byte[32];
        for (int i=0; i<32; i++) {
            int val = N;
            arr[i] = (byte) ((val >> i) & 1);
        }

        byte max = 0;
        byte currentMax = 0;
        byte position = 0;

        boolean rightBorder = false;
        boolean leftBorder = false;

        while (position < 32) {
            if (arr[position] == 0 && !rightBorder) {
                position++;
                continue;
            }

            if (arr[position] == 1 && !rightBorder) {
                rightBorder = true;
                position++;
                continue;
            }

            if (arr[position] == 0) {
                currentMax++;
                position++;
                continue;
            }

            if (arr[position] == 1) {

                if (currentMax > max) {
                    max = currentMax;
                }

                currentMax = 0;
                position++;
            }
        }

        return max;
    }

    void printer(int N) {
        for (int i=0; i<32; i++) {
            int val = N;
            System.out.print(((val >> i) & 1) + " ");
        }

        System.out.println();
    }
}
