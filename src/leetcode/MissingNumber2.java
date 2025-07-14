package leetcode;

class MissingNumber2 {
    public int solution(int[] A) {
        int size = A.length;
        int val = 0;
        for (int i=0; i<size; i++) {
            val = val ^ A[i];
        }

        int biggestPossibleNumber = size + 1;
        int bitsNumber = (int) Math.ceil(Math.log(biggestPossibleNumber) / Math.log(2));
        int biggestForGivenBits = (int) (Math.pow(2, bitsNumber) );
        for (int i=biggestPossibleNumber + 1; i<biggestForGivenBits; i++) {
            val = val ^ i;
        }

        return val;

    }
}
