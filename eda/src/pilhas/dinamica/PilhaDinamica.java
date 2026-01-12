package pilhas.dinamica;

public class PilhaDinamica {

    private No topo;
    private int quantidade;

    public PilhaDinamica() {
        this.topo = null;
        this.quantidade = 0;
    }

    public void push(Integer e) {

        No novoNo = new No(e);
        novoNo.setProximo(topo);
        topo = novoNo;

        quantidade++;
    }

    public Integer pop() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia");
        }

        No removido = topo;
        int valor = topo.getDado();

        topo = topo.getProximo();

        removido.setProximo(null);
        removido.setDado(null);

        quantidade--;
        return valor;
    }

    public Integer peek() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia");
        }

        return topo.getDado();
    }

    public void imprimir() {
        if (isEmpty()) {
            throw new RuntimeException("A pilha está vazia");
        }

        System.out.print("[");
        for (No atual = topo; atual != null; ) {
            System.out.print(atual.getDado());

            if (atual.getProximo() != null) {
                System.out.print(", ");

            }

            atual = atual.getProximo();
        }
        System.out.print("]");
    }

    public boolean isEmpty() {
        return quantidade == 0;
    }

}
