package listas.exceptions;

public class ListaVaziaException extends Exception {

    public ListaVaziaException() {
        super("A lista está vazia");
    }

    public ListaVaziaException(String mensagem) {
        super(mensagem);
    }
}
