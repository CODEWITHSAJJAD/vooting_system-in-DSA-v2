class VoteQueue {
    private Object[] array;
    private int front, rear, capacity;

    public VoteQueue(int size) {
        array = new Object[size];
        capacity = size;
        front = rear = 0;
    }

    public void enqueue(Object item) {
        if ((rear + 1) % capacity == front) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }

        array[rear] = item;
        rear = (rear + 1) % capacity;
    }

    public Object dequeue() {
        if (front == rear) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }

        Object item = array[front];
        front = (front + 1) % capacity;
        return item;
    }

    public boolean isEmpty() {
        return front == rear;
    }

}