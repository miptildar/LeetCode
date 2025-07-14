package educative;

class Statement {

    public static void main(String[] args) {
        sortColors(new int[] {0,1,0});
    }

    public static int[] sortColors (int[] colors) {

        int left = 0;
        for (int color = 0; color < 3; color++) {


            for (int right = left; right < colors.length; ) {
                int leftColor = colors[left];
                int rightColor = colors[right];
                if (rightColor != color) {
                    right++;
                    continue;
                }

                int mem = colors[left];
                colors[left] = colors[right];
                colors[right] = mem;

                right++;
                left++;
            }

        }

        return colors;
    }
}
