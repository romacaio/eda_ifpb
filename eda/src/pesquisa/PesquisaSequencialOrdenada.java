package pesquisa;

public class PesquisaSequencialOrdenada {
    public static void main(String[] args) {
        int[] arrray = {10, 20, 30, 40, 50};
        int valor = 25;

        int resultado = PesquisaSequencial(arrray, valor);
        if (resultado != -1) {
            System.out.println(valor + " encontrado no índice: " + resultado);
        } else {
            System.out.println("Valor não econtrado");
        }
        System.out.print("Array: ");
        for (int num : arrray) {
            System.out.print(num + " ");
        }
    }

    public static int PesquisaSequencial(int[] array, int valor) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > valor) {
                break;
            } else if (array[i] == valor) {
                return i;
            }
        }
        return -1;
    }
}
