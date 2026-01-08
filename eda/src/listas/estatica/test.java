package listas.estatica;

import listas.exceptions.ListaCheiaException;
import listas.exceptions.ListaIndiceForaLimiteException;
import listas.exceptions.ListaVaziaException;

public class test {

    public static void main(String[] args) {

        ListaEstatica lista = new ListaEstatica(5);

        try {
            lista.inserirNoFinal(1);
            lista.inserirNoFinal(10);
            lista.inserirNoFinal(3);
            lista.inserirNoComeco(4);
            lista.inserir(2, 2);
            lista.remover(3);
            lista.removerDoFinal();
            lista.removerDoComeco();


        } catch (ListaCheiaException | ListaIndiceForaLimiteException | ListaVaziaException e) {
            System.out.println(e.getMessage());

        }
        lista.imprimir();
    }
}
