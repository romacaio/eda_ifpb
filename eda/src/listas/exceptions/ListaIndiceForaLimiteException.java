package listas.exceptions;

public class ListaIndiceForaLimiteException extends Exception {

    public ListaIndiceForaLimiteException() {
        System.out.println("Índice fora dos limites da lista");
    }

    public ListaIndiceForaLimiteException(String mensagem) {
        super(mensagem);
    }
}
