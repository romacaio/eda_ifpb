package listas.estatica;

import listas.Lista;
import listas.exceptions.ListaCheiaException;
import listas.exceptions.ListaIndiceForaLimiteException;
import listas.exceptions.ListaVaziaException;

public class ListaEstatica implements Lista {

    private int[] array;
    private int quantidade;

    public ListaEstatica(int tamanho) {
        array = new int[tamanho];
        quantidade = 0;
    }

    @Override
    public boolean isCheia() {
        return quantidade == array.length;
    }

    @Override
    public boolean isVazia() {
        return quantidade == 0;
    }

    @Override
    public void inserirNoFinal(int x) throws ListaCheiaException {
        if (isCheia()) {
            throw new ListaCheiaException();
        }
        array[quantidade] = x;
        quantidade++;
    }

    @Override
    public void inserirNoComeco(int x) throws ListaCheiaException {
        if (isCheia()) {
            throw new ListaCheiaException();
        }
        for (int i = quantidade; i > 0; i--) {
            array[i] = array[i - 1];
        }

        array[0] = x;
        quantidade++;
    }

    @Override
    public void inserir(int x, int i) throws ListaIndiceForaLimiteException, ListaCheiaException {
        if (i > array.length || i < 0 || i > quantidade) {
            throw new ListaIndiceForaLimiteException();
        }
        if (isCheia()) {
            throw new ListaCheiaException();
        }

        for (int j = quantidade; j > i; j--) {
            array[j] = array[j - 1];
        }
        array[i] = x;
        quantidade++;
    }

    @Override
    public int removerDoComeco() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }
        int lixo = array[0]; // elemento removido

        for (int i = 0; i < quantidade - 1; i++) {
            array[i] = array[i + 1];
        }
        quantidade--;
        return lixo;
    }

    @Override
    public int removerDoFinal() throws ListaVaziaException {
        if (isVazia()) {
            throw new ListaVaziaException();
        }
        int lixo = array[quantidade - 1];
        quantidade--;

        return lixo;
    }

    @Override
    public int remover(int i) throws ListaVaziaException, ListaIndiceForaLimiteException {
        if (i > array.length || i < 0 || i > quantidade) {
            throw new ListaIndiceForaLimiteException();
        }

        if (isVazia()) {
            throw new ListaVaziaException();
        }

        int lixo = array[0];

        for (int j = i; j < quantidade - 1; j++) {
            array[i] = array[i + 1];
        }
        quantidade--;
        return lixo;
    }

    @Override
    public void imprimir() {
        for (int i = 0; i <= quantidade - 1; i++) {
            if (i == quantidade - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }
        System.out.println(" <- Fim\n");
    }

    @Override
    public int quantidade() {
        return this.quantidade;
    }

    @Override
    public int busca(int x) {
        for (int i = 0; i < quantidade - 1; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return -1;
    }


}




