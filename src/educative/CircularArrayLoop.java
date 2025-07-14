package educative;
import java.util.*;

class CircularArrayLoop {

    public static void main(String[] args) {
        circularArrayLoop(new int[]{2,1,-1,-2});
    }

    public static boolean circularArrayLoop(int[] nums) {
        Set<Integer> visited = new HashSet<>();

        int size = nums.length;
        int currentIndex = 0;
        while (true) {
            visited.add(currentIndex);

            int step = nums[currentIndex];
            if (step > 0) {
                currentIndex = forward(currentIndex, step, size);
            } else {
                currentIndex = backward(currentIndex, (-1)*step, size);
            }

            if (visited.contains(currentIndex)) {
                return true;
            }

            if (visited.size() == size) {
                return false;
            }

        }


    }

    // steps > 0
    static int forward(int currentPosition, int steps, int size) {
        if (steps > size) {
            steps = steps % size;
        }

        int newPosition = currentPosition + steps;
        if (newPosition >= size) {
            newPosition = newPosition - size;
        }

        return newPosition;
    }

    // steps > 0
    static int backward(int currentPosition, int steps, int size) {
        if (steps > size) {
            steps = steps % size;
        }

        int newPosition = currentPosition - steps;
        if (newPosition < 0) {
            newPosition = newPosition + size;
        }

        return newPosition;
    }

}
