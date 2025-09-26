public class LinkedStack<E> implements Stack<E> {
    private Node T;
    private int size;

    public LinkedStack() {
        T = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return T == null;
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
    // Adiciona um elemento ao topo da pilha
    public void push(E element) throws OverflowException {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(T);
        T = newNode;
        size++;
    }

    @Override
    // Retorna o elemento do topo da pilha sem removê-lo
    public E top() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        return (E) T.getData();
    }

     @Override
    // Remove e retorna o elemento do topo da pilha
    public E pop() throws UnderflowException {
        if (isEmpty()) {
            throw new UnderflowException();
        }
        Object data = T.getData();
        T = T.getNext();
        size--;
        return (E) data;
    }

}