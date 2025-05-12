public class Queue {
    private Consignment[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    public Queue(int size) {
        arr = new Consignment[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public void enqueue(Consignment item) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    public Consignment dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        Consignment item = arr[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    public Consignment peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return arr[front];
    }
    private void swap(int fpos, int spos) {
        Consignment tmp;
        tmp = arr[fpos];
        arr[fpos] = arr[spos];
        arr[spos] = tmp;
    }

    public void remove(Consignment Val){
        for(int i = front ; i <= rear ; i++){
            if (arr[i].equals(Val)){
                for(int j =i ; j< rear ; j++){
                    swap(j , j+1);
                }
                this.rear--;
                break;
            }
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public boolean isFull() {
        return (size() == capacity);
    }


}
