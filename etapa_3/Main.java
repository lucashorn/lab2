

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        //  Checkbrackets
        System.out.println("Verificando parênteses:");
        Etapa3 etapa3 = new Etapa3();

        Stack<Character> s1 = new Stack<>();
        s1.push('(');
        s1.push('A');
        s1.push('+');
        s1.push('B');
        s1.push(')');
        
        etapa3.checkBrackets(s1);
        System.out.println( etapa3.checkBrackets(s1));

        Stack<Character> s2 = new Stack<>();
        s2.push(')');
        s2.push('A');
        s2.push('+');
        s2.push('B');
        s2.push(')');
        
        etapa3.checkBrackets(s2);
        System.out.println( etapa3.checkBrackets(s2));

        Stack<Character> s3 = new Stack<>();
        s3.push('(');
        s3.push('A');
        s3.push('-');
        s3.push('C');
        s3.push('+');
        s3.push('(');
        s3.push('B');
        s3.push(')');
        
        etapa3.checkBrackets(s3);
        System.out.println( etapa3.checkBrackets(s3));

        // Contagem de elemento
        System.out.println("Contagem de Elementos:");
        StaticList<Integer> list = new StaticList<>(10);
        Scanner scanner = new Scanner(System.in);

        // recebendo numeros para a lista
        java.util.Random rand = new java.util.Random();
        for (int i = 0; i < 10; i++) {
            int element = rand.nextInt(5) + 1;
            list.insert(element, i);
        }

        //printa a lista
        System.out.println("Lista de elementos:");
        for (int i = 0; i < list.numElements(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // recebendo os elementos para contagem
        System.out.println("\nInsira um elemento para contar suas ocorrências:");
        int el = scanner.nextInt();

        // contagem de elementos
        int count = list.contaElementos(el);
        System.out.println("O elemento " + el + " aparece " + count + " vezes na lista.");

        scanner.close();
    }
}
