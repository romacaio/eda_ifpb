package listas.encadeada;

import listas.exceptions.ListaIndiceForaLimiteException;
import listas.exceptions.ListaVaziaException;

public class ListaEncadeadaComDescritor {

    private No inicio;
    private No ultimo;
    private int quantidade = 0;

    private final int NAO_ECONTRADO = -1;


    public void inserirNoFinal(Integer e) {
        No no = new No(e);

        if (this.quantidade == 0) {
            this.inicio = no;

        } else {
            this.ultimo.setProximo(no);
        }
        this.ultimo = no;
        this.quantidade++;
    }

    public void inserirNoInicio(Integer e) {
        if (isVazia()) {
            No no = new No(e);
            this.inicio = no;
            this.ultimo = no;

        } else {
            No no = new No(e, this.inicio);
            this.inicio = no;
        }

        this.quantidade++;

    }

    public void inserir(Integer e, int posicao) throws ListaIndiceForaLimiteException, ListaVaziaException {
        if (posicao < 0 || posicao > this.quantidade) {
            throw new ListaIndiceForaLimiteException();
        }

        // inicio
        if (posicao == 0) {
            inserirNoInicio(e);

            // final
        } else if (posicao == this.quantidade) {
            inserirNoFinal(e);

            // meio
        } else {
            No noAnterior = buscaNo(posicao - 1);
            No proximoNo = noAnterior.getProximo();
            No novoNo = new No(e, proximoNo);
            noAnterior.setProximo(novoNo);

            this.quantidade++;
        }

    }

    public Integer removerInicio() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        Integer lixo = this.inicio.getDado();
        this.inicio = inicio.getProximo();

        this.quantidade--;

        if (isVazia()) {
            this.ultimo = null;
        }

        return lixo;
    }

    public Integer removerFinal() throws ListaVaziaException, ListaIndiceForaLimiteException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        if (this.quantidade == 1) {
            return removerInicio();
        }

        No penultimoNo = buscaNo(this.quantidade - 2);
        Integer lixo = penultimoNo.getProximo().getDado();

        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;

        this.quantidade--;
        return lixo;
    }

    public Integer remover(int posicao) throws ListaVaziaException, ListaIndiceForaLimiteException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        if (posicao < 0 || posicao >= quantidade) {
            throw new ListaIndiceForaLimiteException();
        }

        // final
        if (posicao == quantidade - 1) {
            return removerFinal();

            // início
        } else if (posicao == 0) {
            return removerInicio();
        }

        // meio
        No noAnterior = buscaNo(posicao - 1);
        No noAtual = noAnterior.getProximo();
        No proximoNo = noAtual.getProximo();

        Integer lixo = noAtual.getDado();

        noAnterior.setProximo(proximoNo);
        noAtual.setProximo(null);

        quantidade--;
        return lixo;

    }

    public No buscaNo(int posicao) throws ListaVaziaException, ListaIndiceForaLimiteException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        if (posicao >= this.quantidade || posicao < 0) {
            throw new ListaIndiceForaLimiteException();
        }

        No atual = this.inicio;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public int buscaPorPosicao(int posicao) throws ListaVaziaException, ListaIndiceForaLimiteException {
        return buscaNo(posicao).getDado();

    }

    public int busca(Integer e) {
        No atual = this.inicio;
        int posicao = 0;

        while (atual != null) {
            if (atual.getDado() == e) {
                return posicao;
            }

            atual = atual.getProximo();
            posicao++;
        }
        return NAO_ECONTRADO;
    }

    public void imprimir() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        No atual = inicio;
        System.out.print("[");

        while (atual != null) {
            System.out.print(atual.getDado());

            if (atual.getProximo() != null) {
                System.out.print(", ");
            }

            atual = atual.getProximo();
        }

        System.out.print("]");
    }

    public void limpa() {

        for (No atual = this.inicio; atual != null; ) {
            No proximo = atual.getProximo();

            atual.setDado(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.ultimo = null;
        this.quantidade = 0;
    }


    public boolean isVazia() {
        return this.quantidade == 0;
    }

    public int getQuantidade() {
        return this.quantidade;
    }


}
