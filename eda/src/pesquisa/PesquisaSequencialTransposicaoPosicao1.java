package pesquisa;

public class PesquisaSequencialTransposicaoPosicao1 {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int valor = 20;

        System.out.print("Array antes da transposição: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int resultado = PesquisaSequencial(array, valor);
        if (resultado != -1) {
            System.out.print(valor + " encontrado na posição: " + resultado);
            System.out.print("\nArray depois da transposição: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Valor não econtrado.");
        }

    }

    public static int PesquisaSequencial(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                int temp = array[i];
                for (int j = i; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;
                return i;
            }

        }
        return -1;
    }
}
