package listas.encadeada;

public class NoDuplo {

    private Integer dado;
    private NoDuplo anterior;
    private NoDuplo proximo;

    public NoDuplo(Integer dado) {
        this.dado = dado;
        this.anterior = null;
        this.proximo = null;
    }

    public NoDuplo(Integer dado, NoDuplo anterior, NoDuplo proximo) {
        this.dado = dado;
        this.anterior = anterior;
        this.proximo = proximo;
    }


    public int getDado() {
        return dado;
    }

    public void setDado(Integer dado) {
        this.dado = dado;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }

    public NoDuplo getProximo() {
        return proximo;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }
}
