package listas.encadeada.test;

import listas.encadeada.ListaEncadeadaComDescritor;
import listas.exceptions.ListaIndiceForaLimiteException;
import listas.exceptions.ListaVaziaException;

public class ListaEncadeadaTest {
    public static void main(String[] args) {
        //testesIniciais();
        //inserirNoInicio();
        //inserirPorPosicao();
        //removerInicio();
        //removerFinal();
        removerPorPosicao();


    }

    public static void removerPorPosicao() {
        ListaEncadeadaComDescritor lista = new ListaEncadeadaComDescritor();
        lista.inserirNoFinal(1);
        lista.inserirNoFinal(2);
        lista.inserirNoFinal(3);
        lista.inserirNoFinal(4);
        lista.inserirNoFinal(5);

        try {
            System.out.println("Elemento removido: " + lista.remover(2));
            lista.imprimir();

            System.out.println("\nElemento removido: " + lista.remover(0));
            lista.imprimir();

            System.out.println("\nElemento removido: " + lista.remover(1));
            lista.imprimir();

        } catch (ListaVaziaException | ListaIndiceForaLimiteException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void removerFinal() {
        ListaEncadeadaComDescritor lista = new ListaEncadeadaComDescritor();
        lista.inserirNoFinal(2);
        lista.inserirNoFinal(5);
        lista.inserirNoFinal(1);

        try {
            System.out.println("Elemento removido: " + lista.removerFinal());
            lista.imprimir();

            System.out.println("\nElemento removido: " + lista.removerFinal());
            lista.imprimir();

            System.out.println("\nElemento removido: " + lista.removerFinal());
            lista.imprimir();

        } catch (ListaVaziaException | ListaIndiceForaLimiteException e) {
            System.out.println("\n" + e.getMessage());
        }
    }


    public static void removerInicio() {
        ListaEncadeadaComDescritor lista = new ListaEncadeadaComDescritor();
        lista.inserirNoFinal(2);
        lista.inserirNoFinal(5);
        lista.inserirNoFinal(1);

        try {
            System.out.println("Elemento removido: " + lista.removerInicio());
            lista.imprimir();

        } catch (ListaVaziaException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void inserirNoInicio() {
        ListaEncadeadaComDescritor lista = new ListaEncadeadaComDescritor();
        lista.inserirNoInicio(3);
        lista.inserirNoInicio(2);
        lista.inserirNoInicio(1);  // 1, 2, 3

        try {
            lista.imprimir();

        } catch (ListaVaziaException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void inserirPorPosicao() {
        ListaEncadeadaComDescritor lista = new ListaEncadeadaComDescritor();
        try {
            lista.inserirNoFinal(1);
            lista.inserirNoFinal(2);
            lista.inserirNoFinal(4);

            lista.inserir(0, 0);
            lista.inserir(3, 4);
            lista.imprimir();

        } catch (ListaIndiceForaLimiteException | ListaVaziaException e) {
            System.out.println("\n" + e.getMessage());
        }
    }

    public static void testesIniciais() {
        // inserir no final

        ListaEncadeadaComDescritor lista = new ListaEncadeadaComDescritor();

        lista.inserirNoFinal(2);
        lista.inserirNoFinal(5);
        lista.inserirNoFinal(6);

        try {
            lista.imprimir();

        } catch (ListaVaziaException e) {
            System.out.println("\n" + e.getMessage());
        }

        // busca por valor

        System.out.println("\nBusca por valor: ");

        System.out.println(lista.busca(0)); // -1 elemento não econtrado
        System.out.println(lista.busca(5));
        System.out.println(lista.busca(2));

        // busca por posição

        System.out.println("\nBusca por posição: ");

        try {
            System.out.println(lista.buscaPorPosicao(2));
            System.out.println(lista.buscaPorPosicao(0));
            System.out.println(lista.buscaPorPosicao(1));

        } catch (ListaVaziaException | ListaIndiceForaLimiteException e) {
            System.out.println("\n" + e.getMessage());
        }
    }
}
