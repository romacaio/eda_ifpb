package listas.encadeada;

public class No {

    private Integer dado;
    private No proximo;

    public No(Integer dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public No(Integer dado, No proximo) {
        this.dado = dado;
        this.proximo = proximo;
    }


    public int getDado() {
        return dado;
    }

    public void setDado(Integer dado) {
        this.dado = dado;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}
