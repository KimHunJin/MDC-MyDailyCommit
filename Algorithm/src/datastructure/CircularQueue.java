package datastructure;

public class CircularQueue {
    int[] Q;
    int front;
    int rear;
    int size;
    int values;

    public CircularQueue() {
        size = 5;
        Q = new int[size];
        rear = front = values = 0;
    }

    public void enQueue(int e) {
        if (!isFull()) {
            Q[rear] = e;
            values++;
            rear = (rear + 1) % size;
        }
    }

    public int deQueue() {
        front = (front + 1) % size;
        values--;
        return Q[front - 1];
    }

    public boolean isEmpty() {
        return (values == 0);
    }

    public boolean isFull() {
        return (values == size);
    }

    public int peek() {
        return Q[front];
    }

    public void display() {
        int i = values;
        int j = front;
        System.out.println("Valuesently in the Queue:");
        while (i > 0) {
            i--;
            System.out.println(Q[j]);
            j = (j + 1) % size;
        }
    }
}
