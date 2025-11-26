package pesquisa;

public class PesquisaSequencial {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 6, 2};
        int valor = 8;
        int resultado = PesquisaSequencial(array, valor);

        if (resultado != -1) {
            System.out.println("Valor " + valor + " encontrado no índice: " + resultado);
            System.out.print("Array: ");
            for (int num : array) {
                System.out.print(num + " ");
            }
        } else {
            System.out.println("Valor não encontrado.");
        }
    }

    public static int PesquisaSequencial(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == valor) {
                return i;
            }
        }
        return -1;
    }
}
