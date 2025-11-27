package pesquisa;

public class PesquisaBinaria {
    public static void main(String[] args) {
        int[] array = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int valor = 23;
        int resultado = PesquisaBinaria(array, valor);

        if (resultado != -1) {
            System.out.println(valor + " encontrado no índice: " + resultado);
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }

    public static int PesquisaBinaria(int[] array, int valor) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            // evitar overflow (em casos com números grandes) -> inicio + (fim-inicio) /2
            // calcula a diferença entre o fim e o início, evitando somas que possam causar overflow
            int meio = (inicio + fim) / 2;

            if (array[meio] == valor) {
                return meio;
            } else if (array[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return -1;
    }

}
