package pesquisa;

public class PesquisaSequencialSentinela {
    public static void main(String[] args) {
        int[] array = {3, 8, 10, 4, 1, 7};
        int valor = 1;

        System.out.print("Posição do " + valor + ": ");
        int resultado = PesquisaSequencial(array, valor);
        if (resultado != -1) {
            System.out.print(resultado);
        } else {
            System.out.print("Valor não econtrado");
        }

        System.out.println();
        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static int PesquisaSequencial(int[] array, int valor) {
        int temp = array[array.length - 1];
        array[array.length - 1] = valor;
        int i = 0;
        while (array[i] != valor) {
            i++;
        }
        array[array.length - 1] = temp;
        if (i != array.length - 1) {
            return i;
        } else if (array[array.length - 1] == valor) {
            return array.length - 1;
        } else {
            return -1;
        }
    }
}



