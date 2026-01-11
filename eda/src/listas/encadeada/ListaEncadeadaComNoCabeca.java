package listas.encadeada;

import listas.exceptions.ListaIndiceForaLimiteException;
import listas.exceptions.ListaVaziaException;

public class ListaEncadeadaComNoCabeca {

    private No cabeca;
    private No ultimo;
    private int quantidade;

    private final int NAO_ECONTRADO = -1;

    public ListaEncadeadaComNoCabeca() {
        this.cabeca = new No(null);
        this.ultimo = null;
        this.quantidade = 0;
    }


    public void inserirNoFinal(Integer e) {
        No novoNo = new No(e);

        if (this.quantidade == 0) {
            this.cabeca.setProximo(novoNo);

        } else {
            this.ultimo.setProximo(novoNo);
        }
        this.ultimo = novoNo;
        this.quantidade++;
    }

    public void inserirNoInicio(Integer e) {
        No novoNo = new No(e);

        if (isVazia()) {
            this.ultimo = novoNo;
        }
        novoNo.setProximo(cabeca.getProximo());
        this.cabeca.setProximo(novoNo);

        quantidade++;
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

    public int removerInicio() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        No removido = this.cabeca.getProximo();

        this.cabeca.setProximo(removido.getProximo());

        this.quantidade--;

        if (isVazia()) {
            this.ultimo = null;
        }

        return removido.getDado();
    }

    public int removerFinal() throws ListaVaziaException, ListaIndiceForaLimiteException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        if (this.quantidade == 1) {
            return removerInicio();
        }

        No penultimoNo = buscaNo(this.quantidade - 2);
        int lixo = penultimoNo.getProximo().getDado();
        penultimoNo.setProximo(null);
        this.ultimo = penultimoNo;

        this.quantidade--;
        return lixo;
    }

    public int remover(int posicao) throws ListaVaziaException, ListaIndiceForaLimiteException {
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

        int removido = noAtual.getDado();

        noAnterior.setProximo(proximoNo);
        noAtual.setProximo(null);

        quantidade--;
        return removido;

    }

    public No buscaNo(int posicao) throws ListaVaziaException, ListaIndiceForaLimiteException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        if (posicao >= this.quantidade || posicao < 0) {
            throw new ListaIndiceForaLimiteException();
        }

        No atual = this.cabeca.getProximo();
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    public int buscaPorPosicao(int posicao) throws ListaVaziaException, ListaIndiceForaLimiteException {
        return buscaNo(posicao).getDado();

    }

    public int busca(Integer e) {
        No atual = this.cabeca.getProximo();
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

        if (quantidade == 1) {
            System.out.println("[" + this.cabeca.getProximo().getDado() + "]");
            return;
        }

        No atual = this.cabeca.getProximo();
        System.out.print("[" + atual.getDado() + ",");

        for (int i = 1; i < this.quantidade - 1; i++) {
            atual = atual.getProximo();
            System.out.print(atual.getDado() + ",");
        }

        System.out.print(atual.getProximo().getDado() + "]");

    }

    public void limpa() {
        this.cabeca = null;
        this.ultimo = null;
        quantidade = 0;
    }


    public boolean isVazia() {
        return this.quantidade == 0;
    }

    public int getQuantidade() {
        return this.quantidade;
    }


}
