package pesquisa;

public class PesquisaSequencialTransposicaoVarios {
    public static void main(String[] args) {

        int[] array = {10, 20, 30, 40, 50};
        int valor = 40;
        int posicoes = 2;

        System.out.print("Array antes da transposição: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        int resultado = PesquisaSequencial(array, valor, posicoes);
        if (resultado != -1) {
            System.out.println(valor + " encontrado e transposto.");
            System.out.print("Array depois da transposição: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Valor não econtrado.");
        }

    }

    public static int PesquisaSequencial(int[] array, int valor, int posicoes) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                int novaPosicao = Math.max(0, i - posicoes);
                int temp = array[i];

                for (int j = i; j > novaPosicao; j--) {
                    array[j] = array[j - 1];
                }
                array[novaPosicao] = temp;
                return novaPosicao;
            }
        }
        return -1;
    }
}
