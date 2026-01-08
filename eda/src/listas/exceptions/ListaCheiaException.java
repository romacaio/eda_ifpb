package listas.exceptions;

public class ListaCheiaException extends Exception {

    public ListaCheiaException() {
        super("A lista está cheia");
    }

    public ListaCheiaException(String mensagem) {
        super(mensagem);
    }
}
