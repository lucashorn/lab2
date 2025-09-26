import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedStack<Integer> stack = new LinkedStack<>();
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        System.out.println("Digite os números (digite -1 para parar):");
        // popula stack e queue
        while (true) {
            int num = scanner.nextInt();
            if (num == -1) break;
            stack.push(num);
            queue.enqueue(num);
        }

        scanner.close();

        // LIFO
        System.out.println("Topo da pilha: " + stack.top());
        System.out.println("Elementos na pilha: " + stack.numElements());
        while (!stack.isEmpty()) {
            System.out.println("Desempilhando: " + stack.pop());
        }

        // FIFO
        System.out.println("\nPrimeiro na fila: " + queue.front());
        System.out.println("Último na fila: " + queue.back());
        System.out.println("Elementos na fila: " + queue.numElements());
         while (!queue.isEmpty()) {
            System.out.println("Desenfileirando: " + queue.dequeue());
        }
    }
}