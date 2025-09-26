public class LinkedQueue<E> implements Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int size;

    public LinkedQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int numElements() {
        return size;
    }

    @Override
    // Adiciona um elemento ao final da fila
    public void enqueue(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            front = newNode;
        } else {
            rear.setNext(newNode);
        }
        rear = newNode;
        size++;
    }

    @Override
    // Retorna o elemento da frente da fila sem removê-lo
    public E front() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return front.getData();
    }

    @Override
    // Retorna o elemento do final da fila sem removê-lo
    public E back() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return rear.getData();
    }

     @Override
    // Remove e retorna o elemento da frente da fila
     public E dequeue() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        E data = front.getData();
        front = front.getNext();
        if (front == null) {
            rear = null;
        }
        size--;
        return data;
    }
}