package listas.encadeada;

import listas.exceptions.ListaIndiceForaLimiteException;
import listas.exceptions.ListaVaziaException;

public class ListaDuplamenteEncadeada {

    private NoDuplo cabeca;
    private NoDuplo ultimo;
    private int quantidade;


    public ListaDuplamenteEncadeada() {
        this.cabeca = new NoDuplo(null);
        this.ultimo = null;
        this.quantidade = 0;
    }

    public void inserirNoFinal(Integer e) {
        NoDuplo novoNo = new NoDuplo(e);
        if (isVazia()) {
            cabeca.setProximo(novoNo);
            novoNo.setAnterior(cabeca);
        } else {
            ultimo.setProximo(novoNo);
            novoNo.setAnterior(ultimo);
        }

        ultimo = novoNo;
        quantidade++;
    }

    public void inserirNoInicio(Integer e) {
        NoDuplo novoNo = new NoDuplo(e);
        novoNo.setProximo(cabeca.getProximo());
        novoNo.setAnterior(cabeca);

        if (isVazia()) {
            ultimo = novoNo;
        } else {
            cabeca.getProximo().setAnterior(novoNo);
        }

        cabeca.setProximo(novoNo);
        quantidade++;
    }

    public void inserir(Integer e, int posicao) throws ListaVaziaException, ListaIndiceForaLimiteException {

        if (posicao < 0 || posicao > quantidade) {
            throw new ListaIndiceForaLimiteException();
        }

        if (posicao == 0) {
            inserirNoInicio(e);

        } else if (posicao == quantidade) {
            inserirNoFinal(e);

        } else {
            NoDuplo proximoNo = buscaNo(posicao);
            NoDuplo noAnterior = proximoNo.getAnterior();

            NoDuplo noNovo = new NoDuplo(e, noAnterior, proximoNo);
            noAnterior.setProximo(noNovo);
            proximoNo.setAnterior(noNovo);

            quantidade++;
        }

    }


    public Integer removerInicio() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        NoDuplo removido = cabeca.getProximo();
        NoDuplo proximo = removido.getProximo();

        cabeca.setProximo(proximo);

        if (proximo != null) {
            proximo.setAnterior(cabeca);
        }

        quantidade--;

        if (isVazia()) {
            ultimo = null;
        }

        int valor = removido.getDado();

        removido.setProximo(null);
        removido.setAnterior(null);
        removido.setDado(null);

        return removido.getDado();
    }

    public Integer removerFinal() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        if (quantidade == 1) {
            return removerInicio();
        }

        NoDuplo removido = ultimo;
        removido.getAnterior().setProximo(null);
        ultimo = removido.getAnterior();

        quantidade--;

        int valor = removido.getDado();
        removido.setProximo(null);
        removido.setAnterior(null);
        removido.setDado(null);

        return valor;

    }

    public Integer remover(int posicao) throws ListaVaziaException, ListaIndiceForaLimiteException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        if (posicao < 0 || posicao >= quantidade) {
            throw new ListaIndiceForaLimiteException();
        }

        if (posicao == 0) {
            return removerInicio();

        } else if (posicao == quantidade - 1) {
            return removerFinal();

        } else {
            NoDuplo noAtual = buscaNo(posicao);
            Integer valor = noAtual.getDado();

            NoDuplo noAnterior = noAtual.getAnterior();
            NoDuplo proximoNo = noAtual.getProximo();

            noAnterior.setProximo(proximoNo);
            proximoNo.setAnterior(noAnterior);

            noAtual.setProximo(null);
            noAtual.setAnterior(null);
            noAtual.setDado(null);

            quantidade--;
            return valor;

        }
    }

    public NoDuplo buscaNo(int posicao) throws ListaVaziaException, ListaIndiceForaLimiteException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        if (posicao < 0 || posicao >= quantidade) {
            throw new ListaIndiceForaLimiteException();
        }

        NoDuplo atual = cabeca.getProximo();

        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();

        }
        return atual;

    }

    public void imprimir() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        NoDuplo atual = cabeca.getProximo();
        System.out.print("[");

        while (atual != null) {
            System.out.print(atual.getDado());

            if (atual.getProximo() != null) {
                System.out.print(", ");
            }
            atual = atual.getProximo();
        }

        System.out.println("]");
    }

    public void imprimirInverso() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }

        NoDuplo atual = ultimo;
        System.out.print("[");

        while (atual != cabeca) {
            System.out.print(atual.getDado());

            if (atual.getAnterior() != cabeca) {
                System.out.print(", ");
            }
            atual = atual.getAnterior();
        }

        System.out.println("]");
    }


    public boolean isVazia() {
        return quantidade == 0;
    }
}