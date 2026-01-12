package pilhas.estatica;

public class Pilha {

    private int[] elementos;
    private int topo;
    private int quantidade;

    public Pilha(int tamanho) {
        this.elementos = new int[tamanho];
        this.topo = -1;
        this.quantidade = 0;
    }

    public void push(int e) {
        if (isFull()) {
            throw new RuntimeException("A pilha está cheia");
        }

        topo++;
        elementos[topo] = e;

        quantidade++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia");
        }

        int valor = elementos[topo];
        topo--;
        quantidade--;

        return valor;

    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia");
        }

        return elementos[topo];
    }

    public void imprimir() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia");
        }

        System.out.print("[");
        for (int i = topo; i >= 0; i--) {
            System.out.print(elementos[i]);

            if (i != 0) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == elementos.length - 1;
    }


    public int getQuantidade() {
        return quantidade;
    }

}