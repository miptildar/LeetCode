package leetcode.queue;

class CircularQueue {

    static final int MISSING_VALUE = -1;

    int[] queue;
    int size = 0;
    int capacity;

    int front;
    int end;

    public CircularQueue(int k) {
        capacity = k;
        queue = new int[k];

        front = capacity - 1;
        end = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        queue[front] = value;

        front++;
        if (front >= capacity) front = 0;

        size++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        queue[end] = MISSING_VALUE;
        end++;
        if (end >= capacity) end = 0;

        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return queue[end];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
