package leetcode.heap;

class KClosestPointsToOrigin {

    Point[] heap;
    int size = 0;

    public int[][] kClosest(int[][] points, int k) {
        heap = new Point[points.length + 1];

        for (int i=0; i<points.length; i++) {
            add(new Point(points[i]));
        }

        int[][] result = new int[k][];
        for (int i=0; i<k; i++) {
            result[i] = getMin().point;
        }

        return result;
    }

    void add(Point point) {
        size++;
        heap[size] = point;

        int index = size;
        while (index > 1) {
            int parent = index / 2;
            if (heap[parent].distance > heap[index].distance) {
                Point temp = heap[parent];
                heap[parent] = heap[index];
                heap[index] = temp;
                index = parent;
            } else {
                break;
            }
        }
    }

    Point getMin() {
        Point min = heap[1];
        heap[1] = heap[size];
        size--;

        int index = 1;
        while (index <= size / 2) {
            int left = index*2;
            int right = index*2 + 1;
            if (heap[index].distance > heap[left].distance || heap[index].distance > heap[right].distance) {
                if (heap[left].distance > heap[right].distance) {
                    Point temp = heap[right];
                    heap[right] = heap[index];
                    heap[index] = temp;
                    index = right;
                } else {
                    Point temp = heap[left];
                    heap[left] = heap[index];
                    heap[index] = temp;
                    index = left;
                }
            } else {
                break;
            }
        }

        return min;
    }

    static class Point {
        int[] point;
        double distance;

        Point(int[] point) {
            this.point = point;
            this.distance = distance(point[0], point[1]);
        }

        double distance(int x, int y) {
            return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }
    }
}
