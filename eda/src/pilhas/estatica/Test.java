package pilhas.estatica;

public class Test {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(6);

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
