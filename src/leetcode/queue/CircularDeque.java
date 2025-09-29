package leetcode.queue;

class CircularDeque {

    int[] deque;
    int size;
    int capacity;

    int front;
    int rear;

    public CircularDeque(int k) {
        capacity = k;
        deque = new int[k];

        front = capacity - 1;
        rear = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;

        front++;
        if (front >= capacity) front = 0;
        deque[front] = value;

        size++;

        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;

        rear--;
        if (rear < 0) rear = capacity - 1;
        deque[rear] = value;

        size++;

        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;

        front--;
        if (front < 0) front = capacity - 1;

        size--;

        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;

        rear++;
        if (rear >= capacity) rear = 0;

        size--;

        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;

        if (front == -1) return deque[front];
        return deque[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }


}
