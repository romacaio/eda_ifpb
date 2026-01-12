package pilhas.dinamica;

public class No {

    private Integer dado;
    private No proximo;

    public No(Integer dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public Integer getDado() {
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
