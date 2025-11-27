package pesquisa;

public class PesquisaSequencialTransposicao1 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int valor = 30;
        System.out.print("Array antes da transposição: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int resultado = PesquisaSequencial(array, valor);
        if (resultado != -1) {
            System.out.println(valor + " encontrado na posição: " + (resultado + 1) +
                    " (após transposição): " + resultado);
        } else {
            System.out.println("Valor não econtrado");
        }
        System.out.print("Array pós transposição: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static int PesquisaSequencial(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                if (i > 0) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    return i - 1;
                }
                return i;
            }
        }
        return -1;
    }
}