package listas;

import listas.exceptions.ListaCheiaException;
import listas.exceptions.ListaIndiceForaLimiteException;
import listas.exceptions.ListaVaziaException;

public interface Lista {

    // inserção
    public void inserirNoFinal(int x) throws ListaCheiaException;

    public void inserirNoComeco(int x) throws ListaCheiaException;

    public void inserir(int x, int i) throws ListaIndiceForaLimiteException, ListaCheiaException;

    // remoção
    public int removerDoFinal() throws ListaVaziaException;

    public int removerDoComeco() throws ListaVaziaException;

    public int remover(int i) throws ListaVaziaException, ListaIndiceForaLimiteException;

    // impressão
    public void imprimir();

    // validação
    public boolean isCheia();

    public boolean isVazia();

    //busca
    public int busca(int x);

    // tamanho
    public int quantidade();

}
