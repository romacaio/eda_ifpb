package pilhas.dinamica;

public class Test {

    public static void main(String[] args) {

        PilhaDinamica pilha = new PilhaDinamica();

        try {

            pilha.push(1);
            pilha.push(4);
            pilha.push(0);
            pilha.push(6);

            pilha.pop();

            pilha.push(pilha.peek());
            pilha.push(3);

            pilha.pop();

            pilha.push(2);
            pilha.push(3);

            pilha.pop();

            pilha.push(4);

            pilha.imprimir();

        } catch (RuntimeException e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}

